package com.du.car.user.dao;

import com.du.car.common.vo.R;
import com.du.car.user.entity.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberMapper {

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByMsg(String msg);

    List<Member> selectPage(@Param("page") int page,@Param("size") int size);

    long selectCount();

}