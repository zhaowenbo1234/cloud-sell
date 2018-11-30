package com.zhaowb.sellorderserver.service;

import com.zhaowb.sellorderserver.dto.OrderDTO;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/29 18:02
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return OrderDTO
     */
    OrderDTO create(OrderDTO orderDTO);
}
