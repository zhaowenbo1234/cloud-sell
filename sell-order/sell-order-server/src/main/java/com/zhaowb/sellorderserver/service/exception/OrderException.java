package com.zhaowb.sellorderserver.service.exception;

import com.zhaowb.sellorderserver.service.enums.ResultEnum;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/30 11:46
 */
public class OrderException extends RuntimeException{

    private Integer code;

    public OrderException( Integer code,String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
