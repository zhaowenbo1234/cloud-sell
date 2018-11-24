package com.zhaowb.sellproduct.enums;

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

    private String messahe;

    ResultEnum() {
    }

    ResultEnum(Integer code, String messahe) {
        this.code = code;
        this.messahe = messahe;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessahe() {
        return messahe;
    }

    public void setMessahe(String messahe) {
        this.messahe = messahe;
    }
}
