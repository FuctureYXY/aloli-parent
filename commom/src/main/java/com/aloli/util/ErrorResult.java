package com.aloli.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResult<T> {
    /**
     * 异常状态码
     */
    private Integer status;
    /**
     * 用户看得见的异常 如用户名重复等
     */
    private String message;
    /**
     * 异常名字
     */
    private String exception;
    /**
     * 异常的堆栈信息
     */
    private String errors;

    /**
     *  失败返回值
     * @return
     */
    public  static ErrorResult fail(ResultCode resultCode, Throwable e ,String message){
        ErrorResult errorResult = ErrorResult.fail(resultCode,e);
        errorResult.setMessage(message);
        return errorResult;
    }

    /**
     * 失败放回值
     * @param resultCode
     * @param e
     * @return
     */
    public  static ErrorResult fail(ResultCode resultCode , Throwable e){

        ErrorResult errorResult = new ErrorResult();
        errorResult.setMessage(resultCode.message());

        errorResult.setException(e.getClass().getName());
        errorResult.setStatus(resultCode.code());
        return errorResult;
    }







}
