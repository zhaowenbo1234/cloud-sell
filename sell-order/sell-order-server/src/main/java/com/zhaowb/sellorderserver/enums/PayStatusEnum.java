package com.zhaowb.sellorderserver.enums;

/**
 * Created with IDEA
 *  支付状态
 * @author zhaowb
 * @date 2018/11/29 17:52
 */
public enum  PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
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
