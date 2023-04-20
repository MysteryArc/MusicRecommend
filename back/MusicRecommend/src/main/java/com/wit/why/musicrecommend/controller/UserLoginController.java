package com.wit.why.musicrecommend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wit.why.musicrecommend.domain.User;
import com.wit.why.musicrecommend.domain.parm.LoginForm;
import com.wit.why.musicrecommend.service.IUserService;
import com.wit.why.musicrecommend.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/api/login")
public class UserLoginController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/user")
    public Response login(@RequestBody @Valid LoginForm loginForm, BindingResult bindingResult) {
        boolean flag = false;
        String message = "密码错误";

        if(bindingResult.hasErrors()) {
            message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return new Response(false, message);
        }

        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("user_id", loginForm.getLoginId());
        User user = iUserService.getOne(qw);
        String password = user.getPassword();
        if(Objects.equals(password, loginForm.getPassword())) {
            flag = true;
            message = "登录成功";
        }
        return new Response(flag, message);
    }
}
