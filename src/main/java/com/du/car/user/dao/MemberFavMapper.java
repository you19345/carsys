package com.du.car.user.dao;

import com.du.car.user.entity.MemberFav;

import java.util.List;

public interface MemberFavMapper {
    int insert(MemberFav record);

    int insertSelective(MemberFav record);

}