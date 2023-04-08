package com.wit.why.musicrecommend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//用户类
public class User {
    private Integer id;
    private Integer userId;
    private String country;
    private Integer age;
    private String gender;
    private String password;
}
