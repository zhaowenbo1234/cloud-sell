package com.zhaowb.sellorderserver.dto;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/29 18:03
 */
public class CartDTO {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
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
        return "CartDTO{" +
                "productId='" + productId + '\'' +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
