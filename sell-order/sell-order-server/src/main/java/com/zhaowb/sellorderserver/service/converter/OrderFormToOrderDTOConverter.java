package com.zhaowb.sellorderserver.service.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhaowb.sellorderserver.service.dto.OrderDTO;
import com.zhaowb.sellorderserver.service.entity.OrderDetail;
import com.zhaowb.sellorderserver.service.enums.ResultEnum;
import com.zhaowb.sellorderserver.service.exception.OrderException;
import com.zhaowb.sellorderserver.service.form.OrderForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/30 11:11
 */
public class OrderFormToOrderDTOConverter {

    private static final Logger log = LoggerFactory.getLogger(OrderFormToOrderDTOConverter.class);

    public static OrderDTO convert(OrderForm orderForm) {

        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【json转换】错误, string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
