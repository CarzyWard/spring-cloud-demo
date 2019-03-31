package com.zzwy.common;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 返回信息封装
 *
 * @author zzwy
 * @date 2019/03/29
 */
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    /**
     * 成功的时候调用
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    /**
     * 失败的时候调用
     */
    public static <T> Result<T> error(CodeMsg cm) {
        return new Result<T>(cm);
    }

    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    private Result(CodeMsg cm) {
        if (cm == null) {
            return;
        }
        this.code = cm.getCode();
        this.msg = cm.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

}
