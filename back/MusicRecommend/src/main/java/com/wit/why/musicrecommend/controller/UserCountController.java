package com.wit.why.musicrecommend.controller;

import com.wit.why.musicrecommend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/count")
public class UserCountController {
    @Autowired
    IUserService iUserService;

    @GetMapping
    public Long getCount(){
        return iUserService.count();
    }
}
