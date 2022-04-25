package com.hz.boot01.utils;

import lombok.Data;

@Data
public class JsonMassage<T> {
    private Integer code;
    private  String msg;
    private Integer count;
    private  T data;

}
