package com.du.car.user.dao;

import com.du.car.user.entity.MemberProfile;
import java.util.List;

public interface MemberProfileMapper {
    int insert(MemberProfile record);

    int insertSelective(MemberProfile record);

}