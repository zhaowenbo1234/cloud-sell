package com.zhaowb.cloudsell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/20 20:27
 */
@EnableEurekaServer
@SpringBootApplication
public class CloudSellApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudSellApplication.class,args);
    }
}
