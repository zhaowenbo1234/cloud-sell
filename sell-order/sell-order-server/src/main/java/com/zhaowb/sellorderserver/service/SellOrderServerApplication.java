package com.zhaowb.sellorderserver.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created with IDEA
 * 由于 feign client 属于 sell-product-client 所有要在 EnableFeignClients 指定扫描的包，默认扫描当前，扫描不到
 * @author zhaowb
 * @date 2018/11/28 20:39
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.zhaowb.sellproductclient")
public class SellOrderServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellOrderServerApplication.class,args);
    }
}
