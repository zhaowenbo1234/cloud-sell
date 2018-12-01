package com.zhaowb.sellproduct.service.util;

import com.zhaowb.sellproduct.service.vo.ResultVO;

/**
 * Created with IDEA
 *  返回封装
 * @author zhaowb
 * @date 2018/11/26 14:34
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setData(object);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
