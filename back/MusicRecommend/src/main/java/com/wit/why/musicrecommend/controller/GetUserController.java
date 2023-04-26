package com.wit.why.musicrecommend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wit.why.musicrecommend.domain.User;
import com.wit.why.musicrecommend.service.IUserService;
import com.wit.why.musicrecommend.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{currentPage}/{pageSize}")
    public List<User> getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        Page<User> page = iUserService.page(new Page<>(currentPage, pageSize));
        return page.getRecords();
    }
}
