package com.zhaowb.sellproduct.repository;

import com.zhaowb.sellproduct.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/23 15:42
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    /**
     * 根据商品类目编号查询 商品类目
     * @param categoryTypeList 商品类目编号列表
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
