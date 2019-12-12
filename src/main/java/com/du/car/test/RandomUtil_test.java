package com.du.car.test;

import com.du.car.util.RandomUtil;
import org.junit.Test;

/**
 * @program: carsys
 * @description:
 * @author: You毒
 * @create: 2019-12-11 20:16
 **/
public class RandomUtil_test {
    @Test
    public void random_test1() {
        System.out.println(RandomUtil.createCode(4));
        System.out.println(RandomUtil.createCode2(4));
    }
}
