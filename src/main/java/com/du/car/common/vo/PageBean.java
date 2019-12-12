package com.du.car.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @program: carsys
 * @description:
 * @author: You毒
 * @create: 2019-12-10 22:46
 **/
@Data
public class PageBean<T> {
    private int page;
    private int total;
    private int size;
    private long totalPage;
    private List<T> data;
}
