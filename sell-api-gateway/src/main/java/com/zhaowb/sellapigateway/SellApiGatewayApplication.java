package com.zhaowb.sellapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created with IDEA
 *
 * http://localhost:8765//product/product/list?token=123 调用 product 服务示例
 * @author zhaowb
 * @date 2018/12/1 20:11
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class SellApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellApiGatewayApplication.class,args);
    }
}
