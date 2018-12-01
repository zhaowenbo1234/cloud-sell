package com.zhaowb.sellapigateway.sellproductclient;

import com.zhaowb.sellapigateway.sellproductcommon.DecreaseStockInput;
import com.zhaowb.sellapigateway.sellproductcommon.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/28 15:23
 */
@FeignClient(name = "sell-product-server")
public interface SellProductClient {

    /**
     * 获取商品列表(给订单服务用的)
     * 调用示例["157875196366160022","164103465734242707"]
     * @param productIdList 商品ID列表
     * @return List<ProductInfoOutput>
     */
    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    /**
     * 减库存
     * 前端调用例子
     *[{
     *         "productId":"157875196366160022",
     *                 "productQuantity":3
     *
     *     },
     *     {
     *         "productId":"164103465734242707",
     *             "productQuantity":3
     *     }]
     * @param decreaseStockInputList 商品待减库存列表
     */
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}

