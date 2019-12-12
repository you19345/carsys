package com.du.car.user.dao;

import com.du.car.user.entity.MemberPoint;
import java.util.List;

public interface MemberPointMapper {
    int insert(MemberPoint record);

    int insertSelective(MemberPoint record);

}