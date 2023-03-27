package com.wit.why.musicrecommend.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Response {
    private Boolean flag;
    private Object value;

    public Response(){

    }

    public Response(Boolean flag, Object value){
        this.flag = flag;
        this.value = value;
    }
}
