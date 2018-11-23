package com.zhaowb.sellproduct.service;

import com.zhaowb.sellproduct.entity.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/23 16:11
 */
@Service
public interface ProductCategoryService {

    /**
     * 根据商品类目编号查询 商品类目
     * @param categoryTypeList 商品类目编号列表
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
