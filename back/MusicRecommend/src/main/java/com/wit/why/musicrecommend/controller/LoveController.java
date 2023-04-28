package com.wit.why.musicrecommend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wit.why.musicrecommend.domain.Love;
import com.wit.why.musicrecommend.domain.parm.LoveForm;
import com.wit.why.musicrecommend.service.ILoveService;
import com.wit.why.musicrecommend.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/love")
public class LoveController {

    @Autowired
    ILoveService iLoveService;

    @PostMapping
    public Response love(@RequestBody LoveForm loveForm) {
        long time = new Date().getTime();
        time = time / 1000;
        QueryWrapper<Love> qw = new QueryWrapper<>();
        qw.eq("artists_id",loveForm.getArtistId());
        qw.eq("user_id", loveForm.getUserId());
        Love love = new Love(loveForm.getUserId(), loveForm.getArtistId(), time);
        iLoveService.save(love);
        return new Response(true,"love success");
    }

    @GetMapping("{userId}/{artistsId}")
    public Response isLove(@PathVariable Integer userId, @PathVariable Integer artistsId) {
        QueryWrapper<Love> qw = new QueryWrapper<>();
        qw.eq("user_id",userId);
        qw.eq("artists_id", artistsId);
        Boolean flag = true;
        if(iLoveService.count(qw)==0){
            flag = false;
        }
        return new Response(flag,"");
    }

    @DeleteMapping("{userId}/{artistsId}")
    public Response notLove(@PathVariable Integer userId, @PathVariable Integer artistsId) {
        QueryWrapper<Love> qw = new QueryWrapper<>();
        qw.eq("user_id",userId);
        qw.eq("artists_id", artistsId);
        iLoveService.remove(qw);
        return new Response(true, "不再喜欢");
    }
}
