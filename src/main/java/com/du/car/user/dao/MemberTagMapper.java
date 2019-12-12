package com.du.car.user.dao;

import com.du.car.user.entity.MemberTag;

import java.util.List;

public interface MemberTagMapper {
    int insert(MemberTag record);

    int insertSelective(MemberTag record);

}