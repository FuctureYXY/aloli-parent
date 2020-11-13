package com.aloli.config.res;

import com.aloli.util.ResultCode;

//自定义异常   集成进入统一放回
public class BussinessException  extends RuntimeException{

    protected  Integer code ;
    protected  String message;
    public BussinessException(ResultCode resultCode){
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

}
