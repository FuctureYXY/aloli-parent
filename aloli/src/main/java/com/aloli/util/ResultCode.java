package com.aloli.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public enum ResultCode {


  SUCCESS(1,"成功");
  private Integer code;
  private String message;
  ResultCode(Integer code, String message){
    this.code = code;
    this.message = message;
  }
  public Integer code(){
      return this.code;
  }

  public String message(){
      return this.message;
  }


}
