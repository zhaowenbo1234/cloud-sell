package com.zhaowb.sellproduct.service.repository;

import com.zhaowb.sellproduct.service.entity.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() {
        for (ProductInfo productInfo : productInfoRepository.findByProductStatus(0)) {
            System.out.println(productInfo);
        }
        ;
    }

    @Test
    public void findByProductIdIn() {

        for (ProductInfo productInfo : productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022", "157875227953464068"))) {
            System.out.println(productInfo);
        }
        ;
    }
}