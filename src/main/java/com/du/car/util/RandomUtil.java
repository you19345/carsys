package com.du.car.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * @program: carsys
 * @description:
 * @author: You毒
 * @create: 2019-12-09 16:51
 */
public class RandomUtil {

    public static String createCode(int len) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        String string = "0123456789qwertyuiopasdfghjklzxcvbnm";
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < len; i++) {
            Random random = new Random();
            int index = random.nextInt(nums.length);
            int c = nums[index];
            code.append(c);
        }

        return code.toString();
    }

    public static String createCode2(int len) {
        String string = "0123456789qwertyuiopasdfghjklzxcvbnmASDFGHJKLZXCVBNMQWERTYUIOP";
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < len; i++) {
            Random random = new Random();
            int index = random.nextInt(string.length());
            char ch = string.charAt(index);
            code.append(ch);
        }
        return code.toString();
    }

    /**
     * @param groupcount 每组的人数
     * @param total      总人数
     * @return Map集合 每组对应的人的序号
     */
    public static Map<Integer, ArrayList<Integer>> createGroup(int groupcount, int total) {
        //1、保证添加顺序
        LinkedHashMap<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
        int[] arr = new int[total];//记录已经分配的人的序号
        Random random = new Random();
        int len = total / groupcount;
        int lg = 0;
        //循环每一组
        for (int i = 1; i <= len; i++) {
            map.put(i, new ArrayList<>());
            for (int j = 1; j <= groupcount; j++) {
                int c = random.nextInt(total) + 1;
                while (indexOf(arr, c) > -1) {
                    //已分配 重新生成
                    c = random.nextInt(total) + 1;
                }

                arr[lg] = c;
                map.get(i).add(c);
                lg++;
            }
        }
        return map;
    }

    private static int indexOf(int[] arr, int c) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == c) {
                return i;
            }
        }
        return -1;
    }

}
