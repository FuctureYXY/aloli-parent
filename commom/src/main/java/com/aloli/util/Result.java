package com.aloli.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {
    /**
     * status状态值  代表本次请求的response的状态结果
     */
    private Integer status;
    /**
     * response描述  对本次状态码的描述
     */
    private String desc;
    /**
     * 枚举返回的类型
     */
    private Enum resultCode;
    /**
     * data 数据 本次返回的数据
     */
    private T data;

    /**
     * 成功  创建ResResult  没data数据
     * @return
     */
    public  static Result suc(){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    /**
     * 成功 创建ResResult 有data数据
     * @param data
     * @return
     */
    public static Result suc(Object  data){

        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 失败 指定 status  desc
     */
    public static Result fail(Integer status ,String desc ){
        Result result =  new Result();
        result.setStatus(status);
        result.setDesc(desc);
        return result;
    }

    /**
     * 失败 指定ResultCode 枚举
     */
    public static Result fail(ResultCode resultCode){
        Result result = new Result();
        result.setResultCode(resultCode);
        return  result;
    }







}
