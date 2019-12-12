package com.du.car.common.result;

public enum ResultCode {
    OK(200),ERROR(400),NOTFOUND(404);
    private ResultCode(int v) {
        val=v;
    }
    private int val;
    public int getVal() {
        return val;
    }
}
