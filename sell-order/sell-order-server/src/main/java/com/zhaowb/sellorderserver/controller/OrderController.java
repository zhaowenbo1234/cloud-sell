package com.zhaowb.sellorderserver.controller;

import com.zhaowb.sellorderserver.converter.OrderFormToOrderDTOConverter;
import com.zhaowb.sellorderserver.dto.OrderDTO;
import com.zhaowb.sellorderserver.enums.ResultEnum;
import com.zhaowb.sellorderserver.exception.OrderException;
import com.zhaowb.sellorderserver.form.OrderForm;
import com.zhaowb.sellorderserver.service.OrderService;
import com.zhaowb.sellorderserver.util.ResultVOUtil;
import com.zhaowb.sellorderserver.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/30 12:01
 */
@RestController
@RequestMapping("order")
public class OrderController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private OrderService orderService;

    /**
     * 1. 参数检验
     * 2. 查询商品信息(调用商品服务)
     * 3. 计算总价
     * 4. 扣库存(调用商品服务)
     * 5. 订单入库
     *
     * 使用 postman Body form-data . items 为 json格式字符串
     * 成功返回
     * {
     *     "code": 0,
     *     "msg": "成功",
     *     "data": {
     *         "orderId": "1543562600355171615"
     *     }
     * }
     * @param orderForm  订单买家信息
     * @param result  校验
     * @return ResultVO<Map<String,Object>>
     */
    @PostMapping("/create")
    public ResultVO<Map<String,Object>> create(@Valid OrderForm orderForm, BindingResult result){
        if (result.hasErrors()){
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    result.getFieldError().getDefaultMessage());
        }
        // orderForm -> orderDTO
        OrderDTO orderDTO = OrderFormToOrderDTOConverter.convert(orderForm);

        OrderDTO orderResult = orderService.create(orderDTO);

        Map<String,Object> map = new HashMap<>(16);
        map.put("orderId",orderResult.getOrderId());

        return ResultVOUtil.success(map);
    }
}
