package com.du.car.user.web;

import com.du.car.common.vo.R;
import com.du.car.dto.MemberQueryDto;
import com.du.car.user.entity.Member;
import com.du.car.user.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: carsys
 * @description:
 * @author: You毒
 * @create: 2019-12-10 17:51
 **/
@Api(value = "实现会员的相关操作", tags = "实现会员的相关操作")
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "校验会员的注册名称是否重复", notes = "校验会员的注册名称是否重复")
    @GetMapping("/api/user/member/checkName.do")
    public R checkMsg(String msg) {
        return memberService.queryByMsg(msg);
    }

    @ApiOperation(value = "实现会员的注册",notes = "实现会员的注册")
    @PostMapping("/api/user/member/register.do")
    public R register(@RequestBody Member member) {
        return memberService.register(member);
    }

    @ApiOperation(value = "实现用户的登录",notes = "实现用户的登录")
    @PostMapping("/api/user/member/login.do")
    public R login(Member member) {
        return memberService.login(member);
    }

    @ApiOperation(value = "查询也面的内容分页",notes = "查询也面的内容分页")
    @PostMapping("/api/user/member/page.do")
    public R page(@RequestBody MemberQueryDto queryDto) {
        return memberService.search(queryDto);
    }
}
