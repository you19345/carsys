package com.du.car.sms.service;

import com.du.car.common.vo.R;
import com.du.car.dto.PhoneCodeDto;

/**
 * @program: carsys
 * @description:
 * @author: You毒
 * @create: 2019-12-11 17:43
 **/
public interface SmsService {
    R sendSmsCode(String phone);
    R checkSmsCode(PhoneCodeDto codeDto);
}
