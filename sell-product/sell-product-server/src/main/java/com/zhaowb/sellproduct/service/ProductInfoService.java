package com.zhaowb.sellproduct.service;

import com.zhaowb.sellproduct.entity.ProductInfo;
import com.zhaowb.sellproductcommon.DecreaseStockInput;
import com.zhaowb.sellproductcommon.ProductInfoOutput;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/23 16:16
 */
@Service
public interface ProductInfoService {
    /**
     * 查询所有在架商品列表
     *
     * @return List<ProductInfo>
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     *
     * @param productIdList 商品id list
     * @return List<ProductInfoOutput>
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param decreaseStockInputList 减库存入参
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
