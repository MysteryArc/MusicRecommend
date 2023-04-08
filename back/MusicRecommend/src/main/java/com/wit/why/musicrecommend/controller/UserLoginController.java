package com.wit.why.musicrecommend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wit.why.musicrecommend.domain.User;
import com.wit.why.musicrecommend.service.IUserService;
import com.wit.why.musicrecommend.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserLoginController {

    @Autowired
    IUserService iUserService;

    @GetMapping("{id}")
    public Response GetPass(@PathVariable Integer id){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("user_id", id);
        User user = iUserService.getOne(qw);
        String password = user.getPassword();
        return new Response(true, password);
    }
}
