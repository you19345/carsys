package com.du.car.user.service;

import com.du.car.common.vo.R;
import com.du.car.dto.MemberQueryDto;
import com.du.car.user.entity.Member;

/**
 * @program: carsys
 * @description:
 * @author: You毒
 * @create: 2019-12-10 16:48
 **/
public interface MemberService {
    /**
     * 查询
     * @param msg
     * @return
     */
    R queryByMsg(String msg);
//    注册
    R register(Member member);
//    登录
    R login(Member member);
//    后台管理系统，搜索接扣 分页
    R search(MemberQueryDto memberQueryDto);
}
