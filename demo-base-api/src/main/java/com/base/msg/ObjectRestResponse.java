package com.base.msg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by gjf on 2019/4/1.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectRestResponse<T> {
    int code;
    String msg;
    T result;


    public ObjectRestResponse code(int code) {
        this.setCode(code);
        return this;
    }

    public ObjectRestResponse msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    public ObjectRestResponse result(T result) {
        this.setResult(result);
        return this;
    }
}
