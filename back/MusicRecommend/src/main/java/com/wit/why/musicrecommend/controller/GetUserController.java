package com.wit.why.musicrecommend.controller;

import com.wit.why.musicrecommend.service.IUserService;
import com.wit.why.musicrecommend.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class GetUserController {

    @Autowired
    IUserService iUserService;

    @GetMapping
    public Response getUser(){
        return new Response(true, iUserService.list());
    }
}
