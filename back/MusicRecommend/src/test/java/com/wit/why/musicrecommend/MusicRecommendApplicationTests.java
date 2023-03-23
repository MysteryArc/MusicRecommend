package com.wit.why.musicrecommend;

import com.wit.why.musicrecommend.mapper.ArtistsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MusicRecommendApplicationTests {

    @Autowired
    ArtistsMapper artistsMapper;

    @Test
    void contextLoads() {
        System.out.println(artistsMapper.selectById(2));
    }

}
