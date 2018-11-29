package com.zhaowb.sellproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/23 15:22
 */
@SpringBootApplication
@EnableDiscoveryClient

public class SellProductServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellProductServerApplication.class, args);
    }
}
