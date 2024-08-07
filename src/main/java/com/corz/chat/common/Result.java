package com.corz.chat.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Result<T> implements Serializable {
    /** 状态码 */
    private Integer code;
    /** 响应数据 */
    private T data;
    /** 消息 */
    private String msg;

    public Result() {
    }

    public Result(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> Result<T> restResult(Integer code, T data, String msg) {
        return Result.<T>builder()
                .code(code)
                .data(data)
                .msg(msg)
                .build();
    }

    public static <T> Result<T> success(){
        return restResult(200, null, "操作成功");
    }

    public static <T> Result<T> success(T data){
        return restResult(200, data, "操作成功");
    }

    public static <T> Result<T> success(T data, String msg){
        return restResult(200, data, msg);
    }

    public static <T> Result<T> success(Integer code, T data, String msg){
        return restResult(code, data, msg);
    }
}
