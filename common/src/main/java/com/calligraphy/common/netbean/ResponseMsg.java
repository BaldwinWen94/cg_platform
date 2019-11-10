package com.calligraphy.common.netbean;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseMsg<T> {
    private Integer code;

    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ResponseMsg() {

    }

    public ResponseMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public ResponseMsg(T data) {
        this.code = 1;
        this.msg = "成功";
        this.data = data;
    }

    @Override
    public String toString() {
        if (data == null) {
            return "code: " + code + ",msg: " + msg;
        } else {
            return "code: " + code + ",msg: " + msg + ",data: " + data.toString();
        }
    }
}
