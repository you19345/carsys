package com.du.car.user.dao;


import com.du.car.user.entity.MemberCar;

import java.util.List;

public interface MemberCarMapper {
    int insert(MemberCar record);

    int insertSelective(MemberCar record);
}