package com.zhaowb.sellapigateway.sellproductcommon;

/**
 * Created with IDEA
 * 减库存入参
 * @author zhaowb
 * @date 2018/11/23 16:39
 */
public class DecreaseStockInput {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "DecreaseStockInput{" +
                "productId='" + productId + '\'' +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
