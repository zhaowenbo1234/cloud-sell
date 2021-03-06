package com.zhaowb.sellproduct.service.controller;

import com.zhaowb.sellproduct.service.entity.ProductCategory;
import com.zhaowb.sellproduct.service.service.ProductCategoryService;
import com.zhaowb.sellproduct.service.service.ProductInfoService;
import com.zhaowb.sellproduct.service.util.ResultVOUtil;
import com.zhaowb.sellproduct.service.vo.ProductInfoVO;
import com.zhaowb.sellproduct.service.vo.ProductVO;
import com.zhaowb.sellproduct.service.vo.ResultVO;
import com.zhaowb.sellapigateway.sellproductcommon.DecreaseStockInput;
import com.zhaowb.sellapigateway.sellproductcommon.ProductInfoOutput;
import com.zhaowb.sellproduct.service.entity.ProductInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/26 14:47
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 1. 查询所有在架的商品
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     *
     * @return ResultVO<ProductVO>
     */
    @RequestMapping("/list")
    public ResultVO<ProductVO> list() {

        //1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        // 2. 获取类目type列表 应该使用set去重存储不应该使用
        // ①历史版本 list List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList())
        Set<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toSet());
        //3. 从数据库查询类目
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //4. 构造数据
        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }

    /**
     * 获取商品列表(给订单服务用的)
     * 调用示例["157875196366160022","164103465734242707"]
     * @param productIdList 商品ID列表
     * @return List<ProductInfoOutput>
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList) {
        return productInfoService.findList(productIdList);
    }

    /**
     * 减库存
     * 前端调用例子
     *[{
     *         "productId":"157875196366160022",
     *                 "productQuantity":3
     *
     *     },
     *     {
     *         "productId":"164103465734242707",
     *             "productQuantity":3
     *     }]
     * @param decreaseStockInputList 商品待减库存列表
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        productInfoService.decreaseStock(decreaseStockInputList);
    }
}
