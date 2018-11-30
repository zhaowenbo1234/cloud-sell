package com.zhaowb.sellorderserver.exception;

import com.zhaowb.sellorderserver.enums.ResultEnum;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/30 11:46
 */
public class OrderException extends RuntimeException{

    private Integer code;

    public OrderException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
