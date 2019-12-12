package com.du.car.filter;

import com.alibaba.fastjson.JSON;
import com.du.car.common.vo.R;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: carsys
 * @description:
 * @author: You毒
 * @create: 2019-12-11 21:14
 **/
public class SmsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //实现短信发送的频率校验
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        //1、校验当前请求的是不是发送短信
        if(request.getRequestURI().endsWith("/sms/sendcode.do")){
            //2、频率校验
            boolean r=false;//不允许发送短信
            //1分钟1条
            //            //	小时5条
            //            //	1天10条
            //放行
            if(r) {
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                HttpServletResponse response=(HttpServletResponse) servletResponse;
                response.getWriter().println(JSON.toJSONString(R.fail("已达上限")));
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
