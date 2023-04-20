package com.wit.why.musicrecommend.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer id;
    private Integer adminId;
    private String password;
}
