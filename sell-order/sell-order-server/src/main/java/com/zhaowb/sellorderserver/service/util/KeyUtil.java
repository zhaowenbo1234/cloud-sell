package com.zhaowb.sellorderserver.service.util;

import java.util.Random;

/**
 * Created with IDEA
 *
 * @author zhaowb
 * @date 2018/11/29 20:23
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
