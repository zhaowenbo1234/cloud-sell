package com.zhaowb.sellproduct.service.impl;

import com.zhaowb.sellproduct.entity.ProductCategory;
import com.zhaowb.sellproduct.repository.ProductCategoryRepository;
import com.zhaowb.sellproduct.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/23 16:14
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
