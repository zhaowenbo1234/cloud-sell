package com.zhaowb.sellorderserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/28 20:39
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SellOrderServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellOrderServerApplication.class,args);
    }
}
