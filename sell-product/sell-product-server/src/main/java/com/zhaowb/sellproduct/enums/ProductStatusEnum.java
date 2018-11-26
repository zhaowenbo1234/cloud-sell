package com.zhaowb.sellproduct.enums;

/**
 * Created with IDEA
 * 商品上下架状态
 *
 * @author zhaowb
 * @date 2018/11/24 19:02
 */
public enum ProductStatusEnum {


    UP(0, "在架"),
    DOWN(1, "下架"),
    ;
    private Integer code;
    private String message;

    ProductStatusEnum() {
    }

    ProductStatusEnum(Integer code, String message) {
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
