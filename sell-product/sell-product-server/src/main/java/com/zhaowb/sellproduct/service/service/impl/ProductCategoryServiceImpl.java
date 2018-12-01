package com.zhaowb.sellproduct.service.service.impl;

import com.zhaowb.sellproduct.service.entity.ProductCategory;
import com.zhaowb.sellproduct.service.repository.ProductCategoryRepository;
import com.zhaowb.sellproduct.service.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
    public List<ProductCategory> findByCategoryTypeIn(Set<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
