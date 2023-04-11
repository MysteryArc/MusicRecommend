package com.wit.why.musicrecommend.controller;

import com.wit.why.musicrecommend.service.IArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/artists/total")
public class ArtistCountController {
    @Autowired
    IArtistsService iArtistsService;

    @GetMapping
    public Long getTotal() {
        return iArtistsService.count();
    }
}
