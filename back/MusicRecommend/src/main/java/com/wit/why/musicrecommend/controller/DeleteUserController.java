package com.wit.why.musicrecommend.controller;

import com.wit.why.musicrecommend.service.IUserService;
import com.wit.why.musicrecommend.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/delete")
public class DeleteUserController {
    @Autowired
    IUserService iUserService;

    @GetMapping("{userId}")
    public Response deleteUser(@PathVariable Integer userId) {
        iUserService.removeById(userId);
        return new Response(true, "delete");
    }
}
