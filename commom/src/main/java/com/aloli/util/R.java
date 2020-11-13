package com.aloli.util;

import java.io.Serializable;

import com.aloli.constants.CommonConstants;

import lombok.*;
import lombok.experimental.Accessors;

@Builder
@ToString
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 返回码
     */
    @Getter
    @Setter
    private int code = CommonConstants.SUCCESS;

    /**
     * 返回消息
     */
    @Getter
    @Setter
    private String msg;

    /**
     * 返回数据
     */
    @Getter
    @Setter
    private T data;

    public R() {
        super();
    }

    public R(T data) {
        super();
        this.data = data;
    }

    public R(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public R(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = CommonConstants.FAIL;
    }

    /**
     * 失败code 设置
     *
     * @return this
     */
    public R fail() {
        this.code = CommonConstants.FAIL;
        this.msg = CommonConstants.FAIL_MSG;
        return this;
    }

    /**
     * 失败code 设置
     *
     * @return this
     */
    public R fail(String msg) {
        this.code = CommonConstants.FAIL;
        this.msg = msg;
        return this;
    }

    /**
     * 成功code 设置
     *
     * @return this
     */
    public R success(String msg) {
        this.msg = msg;
        return this;
    }
}
