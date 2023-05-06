package com.wit.why.musicrecommend.controller;

import com.wit.why.musicrecommend.mapper.ReadMapper;
import com.wit.why.musicrecommend.service.IReadService;
import com.wit.why.musicrecommend.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hot")
public class getHotController {
    @Autowired
    ReadMapper readMapper;

    @GetMapping
    public Response getHot(){
        List<Integer> hotList = readMapper.hot();
        hotList = hotList.subList(0,10);
        return new Response(true, hotList);
    }
}
