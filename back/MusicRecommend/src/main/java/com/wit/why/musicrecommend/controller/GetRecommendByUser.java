package com.wit.why.musicrecommend.controller;

import com.wit.why.musicrecommend.domain.parm.RecommendRes;
import com.wit.why.musicrecommend.util.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recommend/user")
public class GetRecommendByUser {

    @GetMapping("{userid}")
    public Response getRecommend(@PathVariable Integer userid) throws IOException, InterruptedException {
        String cmds = String.format("python C:\\Users\\MysteryArc\\Desktop\\study\\MusicRecommendSystem\\recommend\\recommend.py %s", userid.toString());
        Process pcs = Runtime.getRuntime().exec(cmds);
        pcs.waitFor();

        BufferedReader in = new BufferedReader(new InputStreamReader(pcs.getInputStream()));
        List<RecommendRes> recommendResList = new ArrayList<>();

        String line = null;
        while((line = in.readLine()) != null){
            RecommendRes res = new RecommendRes();
            String[] s = line.split(",");
            res.setArtistId(Integer.parseInt(s[0]));
            res.setScore(Float.parseFloat(s[1]));
            recommendResList.add(res);
        }
        return new Response(true, recommendResList);
    }
}
