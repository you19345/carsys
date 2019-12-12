package com.du.car.user.service.impl;

import com.du.car.common.result.ResultCode;
import com.du.car.common.vo.PageBean;
import com.du.car.common.vo.R;
import com.du.car.config.RedisKeyConfig;
import com.du.car.dto.MemberQueryDto;
import com.du.car.user.dao.MemberMapper;
import com.du.car.user.entity.Member;
import com.du.car.user.service.MemberService;
import com.du.car.util.JedisUtil;
import com.du.car.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: carsys
 * @description:
 * @author: You毒
 * @create: 2019-12-10 17:38
 **/
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private JedisUtil jedisUtil;

    //验证是否重名
    @Override
    public R queryByMsg(String msg) {
        Member member = memberMapper.selectByMsg(msg);
        if (member == null) {
//            名称不存在，可以注册
            return R.OK();
        } else {
            return R.fail("用户名已存在！！！");
        }

    }

    //注册
    @Override
    public R register(Member member) {
//        再次进行验证，防止确定期间已被抢先注册
//        1、校验是否存在
        if (queryByMsg(member.getUsername()).getCode() == ResultCode.OK.getVal()) {
//            2、不存在 再新增
            int c = memberMapper.insert(member);
            if (c > 0) {
                return R.OK();
            } else {
                return R.fail();
            }
        } else {
            return R.fail("用户名已存在！！！");
        }
    }

    //登录
    @Override
    public R login(Member member) {
//        1、根据用户名查询用户信息
        Member m = memberMapper.selectByMsg(member.getUsername());
//        2、校验用户是否存在
        if (m != null) {
//            3、校验密码是否正确
            if (m.getPassword().equals(member.getPassword())) {
//                4、成功 生成令牌 存储为当前会员的id信息
                String token = JwtUtil.createJWT(m.getId()+"");
//                令牌Token 有效期  Redis 有效期
                jedisUtil.addStr(RedisKeyConfig.TOKEN_KEY+member.getUsername(),token,
                        +RedisKeyConfig.TOEKN_TIME);
                return R.OK(m.getId());
            }
        }
        return R.fail("用户名或密码错误！！！");
    }

    @Override
    public R search(MemberQueryDto memberQueryDto) {
        List<Member> membersList = memberMapper.selectPage(memberQueryDto.getPage(), memberQueryDto.getSize());
//       实例化分页类
        PageBean<Member> pageBean = new PageBean<Member>();
        pageBean.setData(membersList);
        pageBean.setPage(memberQueryDto.getPage());
        pageBean.setSize(memberQueryDto.getSize());
        pageBean.setTotalPage(memberMapper.selectCount());
//        计算总页数
        pageBean.setTotalPage(pageBean.getTotal() % memberQueryDto.getSize() == 0 ? pageBean.getTotal() / pageBean.getSize() :
                pageBean.getTotal() / pageBean.getSize() + 1);
        return R.OK(pageBean);
    }
}
