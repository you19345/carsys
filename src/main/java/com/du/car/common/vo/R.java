package com.du.car.common.vo;

import com.du.car.common.result.ResultCode;
import lombok.Data;

/**
 * @program: carsys
 * @description:
 * @author: You毒
 * @create: 2019-12-10 16:42
 **/
@Data
public class R {
    private int code; // 结果码
    private String msg; //提示
    private Object data; // 携带数据

    public static R setR(int code,String msg,Object data) {
        R r = new R();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }

    public static R OK(Object data) {
        return setR(ResultCode.OK.getVal(),"OK",data);
    }

    public static R OK() {
        return setR(ResultCode.OK.getVal(),"OK",null);
    }

    public static R fail() {
        return setR(ResultCode.ERROR.getVal(),"Error",null);
    }

    public static R fail(String msg) {
        return setR(ResultCode.ERROR.getVal(),msg,null);
    }
}
