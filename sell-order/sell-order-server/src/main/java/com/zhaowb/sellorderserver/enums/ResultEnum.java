package com.zhaowb.sellorderserver.enums;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/29 17:53
 */
public enum ResultEnum {

    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
