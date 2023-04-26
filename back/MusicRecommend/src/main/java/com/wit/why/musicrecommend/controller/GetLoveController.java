package com.wit.why.musicrecommend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wit.why.musicrecommend.domain.Love;
import com.wit.why.musicrecommend.service.ILoveService;
import com.wit.why.musicrecommend.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/love")
public class GetLoveController {
    @Autowired
    ILoveService iLoveService;

    @GetMapping("{userid}")
    public Response getRecently(@PathVariable Integer userid){
        QueryWrapper<Love> qw = new QueryWrapper<>();
        qw.eq("user_id", userid);
        qw.orderByDesc("timestamp");
        List<Love> loveList = iLoveService.list(qw);
        return new Response(true, loveList);
    }
}
