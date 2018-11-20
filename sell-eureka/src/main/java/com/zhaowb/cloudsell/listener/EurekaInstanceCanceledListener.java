package com.zhaowb.cloudsell.listener;

import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Objects;

/**
 * Created with IDEA
 * EurekaInstanceCanceledEvent 服务下线事件
 * EurekaInstanceRegisteredEvent 服务注册事件
 * EurekaInstanceRenewedEvent 服务续约事件
 * EurekaRegistryAvailableEvent Eureka注册中心启动事件
 * EurekaServerStartedEvent Eureka Server启动事件
 *
 * @author zhaowb
 * @date 2018/11/20 20:37
 */
@Configuration
@EnableScheduling
public class EurekaInstanceCanceledListener implements ApplicationListener {

    private static final Logger log = LoggerFactory.getLogger(EurekaInstanceCanceledListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        //服务挂掉自动通知
        if (applicationEvent instanceof EurekaInstanceCanceledEvent) {
            EurekaInstanceCanceledEvent event = (EurekaInstanceCanceledEvent) applicationEvent;
            //服务挂掉自动通知
            PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
            Applications applications = registry.getApplications();

            // 获取已注册节点中和当前失效节ID点一直的节点信息
            applications.getRegisteredApplications().forEach(registryApplication -> {
                registryApplication.getInstances().forEach(instanceInfo -> {
                    if (Objects.equals(instanceInfo.getInstanceId(), event.getServerId())) {
                        log.info("服务：{}挂掉了。。。", event.getAppName());
                        // TODO
                        log.info("发送邮件到维护人员邮箱");
                    }
                });
            });
        }

        if (applicationEvent instanceof EurekaInstanceRegisteredEvent) {
            EurekaInstanceRegisteredEvent event = (EurekaInstanceRegisteredEvent) applicationEvent;
            log.info("服务：{}注册成功。。。。。。", event.getInstanceInfo().getAppName());
        }
        if (applicationEvent instanceof EurekaInstanceRenewedEvent) {
            EurekaInstanceRenewedEvent event = (EurekaInstanceRenewedEvent) applicationEvent;
            log.info("服务:{} 心跳检测成功。。。。。", event.getInstanceInfo().getAppName());
        }
        if (applicationEvent instanceof EurekaRegistryAvailableEvent) {
            log.info("服务 Available...");
        }
    }
}
