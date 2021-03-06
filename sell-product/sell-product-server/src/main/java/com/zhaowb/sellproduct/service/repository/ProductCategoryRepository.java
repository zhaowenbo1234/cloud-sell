package com.zhaowb.sellproduct.service.repository;

import com.zhaowb.sellproduct.service.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/23 15:42
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 根据商品类目编号查询 商品类目
     *
     * @param categoryTypeList 商品类目编号列表
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(Set<Integer> categoryTypeList);
}
