package com.du.car.dto;

import lombok.Data;

/**
 * @program: carsys
 * @description:
 * @author: You毒
 * @create: 2019-12-10 22:48
 **/
@Data
public class MemberQueryDto {
    private int page;
    private int size;
    private String name;
    private int sex;
}
