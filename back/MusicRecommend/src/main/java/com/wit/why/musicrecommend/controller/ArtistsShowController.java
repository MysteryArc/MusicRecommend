package com.wit.why.musicrecommend.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wit.why.musicrecommend.domain.Artists;
import com.wit.why.musicrecommend.service.IArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/discover/song")
public class ArtistsShowController {

    @Autowired
    IArtistsService iArtistsService;

    @GetMapping
    public List<Artists> getAll() {
        Page<Artists> page = iArtistsService.page(new Page<>(1, 10));
        return page.getRecords();
    }

    @GetMapping("{id}")
    public Artists getById(@PathVariable Integer id) {
        return iArtistsService.getById(id);
    }

}
