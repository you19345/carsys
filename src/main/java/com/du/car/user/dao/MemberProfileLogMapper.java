package com.du.car.user.dao;

import com.du.car.user.entity.MemberProfileLog;
import java.util.List;

public interface MemberProfileLogMapper {
    int insert(MemberProfileLog record);

    int insertSelective(MemberProfileLog record);

}