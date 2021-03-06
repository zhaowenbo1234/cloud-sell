package com.zhaowb.sellproduct.service.enums;

/**
 * Created with IDEA
 * 商品枚举
 *
 * @author zhaowb
 * @date 2018/11/24 18:59
 */
public enum ResultEnum {


    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存有误"),
    ;
    private Integer code;

    private String message;

    ResultEnum() {
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
