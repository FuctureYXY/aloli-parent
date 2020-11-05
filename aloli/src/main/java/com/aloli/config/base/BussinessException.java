package com.aloli.config.base;

import com.aloli.util.ResultCode;

//自定义异常

public class BussinessException  extends RuntimeException{

    protected  Integer code ;
    protected  String message;
    public BussinessException(ResultCode resultCode){
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

}
