package com.zhaowb.sellapigateway.sellconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/21 9:59
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class SellConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellConfigApplication.class,args);
    }
}
