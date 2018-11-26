package com.zhaowb.sellproduct.service.impl;

import com.zhaowb.sellproduct.entity.ProductInfo;
import com.zhaowb.sellproduct.enums.ProductStatusEnum;
import com.zhaowb.sellproduct.repository.ProductInfoRepository;
import com.zhaowb.sellproduct.service.ProductInfoService;
import com.zhaowb.sellproductcommon.DecreaseStockInput;
import com.zhaowb.sellproductcommon.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/26 16:33
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList).stream().map(e -> {
            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
            BeanUtils.copyProperties(e, productInfoOutput);
            return productInfoOutput;
        }).collect(Collectors.toList());
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

    }
}
