package com.zhaowb.sellproduct.service.exception;

import com.zhaowb.sellproduct.service.enums.ResultEnum;

/**
 * Created with IDEA
 * 商品异常
 *
 * @author zhaowb
 * @date 2018/11/25 22:02
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
