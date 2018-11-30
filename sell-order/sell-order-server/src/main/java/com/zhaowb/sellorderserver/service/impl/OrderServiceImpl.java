package com.zhaowb.sellorderserver.service.impl;

import com.zhaowb.sellorderserver.dto.OrderDTO;
import com.zhaowb.sellorderserver.entity.OrderDetail;
import com.zhaowb.sellorderserver.entity.OrderMaster;
import com.zhaowb.sellorderserver.enums.OrderStatusEnum;
import com.zhaowb.sellorderserver.enums.PayStatusEnum;
import com.zhaowb.sellorderserver.repository.OrderDetailRepository;
import com.zhaowb.sellorderserver.repository.OrderMasterRepository;
import com.zhaowb.sellorderserver.service.OrderService;
import com.zhaowb.sellorderserver.util.KeyUtil;
import com.zhaowb.sellproductclient.SellProductClient;
import com.zhaowb.sellproductcommon.DecreaseStockInput;
import com.zhaowb.sellproductcommon.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/29 20:08
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private SellProductClient sellProductClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();

        // 查询商品信息（调用商品服务）
        List<String> productIdList = orderDTO.getOrderDetailList().stream().map(OrderDetail::getOrderId)
                .collect(Collectors.toList());
        List<ProductInfoOutput> productInfoOutputList = sellProductClient.listForOrder(productIdList);

        // 计算总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
                if (productInfoOutput.getProductId().equals(orderDetail.getProductId())) {
                    orderAmount = productInfoOutput.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);
                    BeanUtils.copyProperties(productInfoOutput, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    // 订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }
        // 扣库存（调用商品服务）
        List<DecreaseStockInput> decreaseStockInputList = orderDTO.getOrderDetailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
        sellProductClient.decreaseStock(decreaseStockInputList);

        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
