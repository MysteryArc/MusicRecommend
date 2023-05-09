package com.wit.why.musicrecommend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wit.why.musicrecommend.domain.Artists;
import com.wit.why.musicrecommend.service.IArtistsService;
import com.wit.why.musicrecommend.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/neighbors")
public class GetNeighbors {
    @Autowired
    IArtistsService iArtistsService;

    @GetMapping("{musicId}")
    public Response getNeighbors(@PathVariable Integer musicId){
        QueryWrapper<Artists> qw = new QueryWrapper<>();
        qw.eq("id", musicId);
        Artists artists = iArtistsService.getOne(qw);
        QueryWrapper<Artists> qw1 = new QueryWrapper<>();
        qw1.eq("singer", artists.getSinger());
        List<Artists> res = iArtistsService.list(qw1);
        for(int i = 0;i < res.size();i++){
            if(Objects.equals(res.get(i).getId(), musicId)){
                res.remove(i);
            }
        }
        return new Response(true, res);
    }
}
