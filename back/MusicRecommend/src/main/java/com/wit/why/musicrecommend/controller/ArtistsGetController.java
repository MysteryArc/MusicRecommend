package com.wit.why.musicrecommend.controller;

import com.wit.why.musicrecommend.domain.Artists;
import com.wit.why.musicrecommend.service.IArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artists/id")
public class ArtistsGetController {
    @Autowired
    IArtistsService iArtistsService;

    @GetMapping("{id}")
    public Artists getById(@PathVariable Integer id){
        return iArtistsService.getById(id);

    }
}
