package com.du.car.sms.service.impl;

import com.du.car.common.vo.R;
import com.du.car.config.RedisKeyConfig;
import com.du.car.dto.PhoneCodeDto;
import com.du.car.sms.service.SmsService;
import com.du.car.util.AliSmsUtil;
import com.du.car.util.JedisUtil;
import com.du.car.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: carsys
 * @description:
 * @author: You毒
 * @create: 2019-12-11 17:43
 **/
public class SmsServiceImpl implements SmsService {
    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public R sendSmsCode(String phone) {
        String code = null;
//        1、校验之前的验证码是否失效
        if (jedisUtil.checkKey(RedisKeyConfig.SMS_CODE+phone)) {
//            验证码未失效
//            1、更改有效期 重新设置为10分钟
            code = jedisUtil.getStr(RedisKeyConfig.SMS_CODE+phone);
            jedisUtil.setExpire(RedisKeyConfig.SMS_CODE+phone,RedisKeyConfig.TOEKN_TIME);
//            2、检测有效期是否剩余超过一半，超过一半不改变直接返回 ，小于一把更新有效期

//            3、重新生成 把原来的覆盖
//            code = RandomUtil.createCode(4);

        } else {
//            生成验证码
            code = RandomUtil.createCode(4);
        }
//        2、发送短信
        AliSmsUtil.sendSmsCode(code);
//        3、保存验证码记录到reids
        jedisUtil.addStr(RedisKeyConfig.SMS_CODE+phone,code);
        return R.OK();
    }

    @Override
    /**
     * 校验验证码是否有效
     */
    public R checkSmsCode(PhoneCodeDto codeDto) {
//        1、校验验证码是否有效
        if (jedisUtil.checkKey(RedisKeyConfig.SMS_CODE+codeDto.getPhone())) {
//            2、校验是否正确
            if (codeDto.getCode().equals(RedisKeyConfig.SMS_CODE+codeDto.getPhone())) {
                return R.OK();
            }
        }
        return R.fail("校验失败");
    }
}
