package com.wit.why.musicrecommend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wit.why.musicrecommend.domain.Read;
import com.wit.why.musicrecommend.domain.parm.ReadForm;
import com.wit.why.musicrecommend.service.IReadService;
import com.wit.why.musicrecommend.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
@RequestMapping("/read")
public class ReadController {

    @Autowired
    IReadService iReadService;

    @PostMapping
    public Response read(@RequestBody ReadForm readForm) {
        long time = new Date().getTime();
        time = time / 1000;
        QueryWrapper<Read> qw = new QueryWrapper<>();
        qw.eq("artists_id",readForm.getArtistId());
        qw.eq("user_id", readForm.getUserId());
        if(iReadService.count(qw) == 0){
            Read read = new Read(readForm.getUserId(), readForm.getArtistId(), 1, time);
            iReadService.save(read);
        }
        else{
            Read read = iReadService.getOne(qw);
            int weight = read.getWeight();
            Read update = new Read();
            update.setWeight(weight + 1);
            update.setTimestamp(time);
            QueryWrapper<Read> qwUpdate = new QueryWrapper<>();
            qwUpdate.eq("artists_id", readForm.getArtistId());
            qwUpdate.eq("user_id", readForm.getUserId());
            iReadService.update(update, qwUpdate);
        }
        return new Response(true,"success");
    }
}
