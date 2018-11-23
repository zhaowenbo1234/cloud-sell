package com.zhaowb.sellproduct.repository;

import com.zhaowb.sellproduct.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/23 15:42
 */
@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 根据订单状态查询订单列表
     *
     * @param productStatus 订单状态
     * @return List<ProductInfo>
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * 根据商品Id 列表 查询商品信息
     * @param productIdList 商品id list
     * @return  List<ProductInfo>
     */
    List<ProductInfo> findByProductIdIn(List<String> productIdList);

}
