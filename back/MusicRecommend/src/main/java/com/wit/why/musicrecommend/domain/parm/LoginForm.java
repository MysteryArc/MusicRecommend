package com.wit.why.musicrecommend.domain.parm;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginForm {
    @NotNull(message = "请输入账号")
    private String loginId;

    @NotNull(message = "请输入密码")
    @Size(max = 16, min = 6, message = "密码长度为6-16")
    private String password;
}
