package com.wit.why.musicrecommend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wit.why.musicrecommend.domain.Artists;
import com.wit.why.musicrecommend.mapper.ArtistsMapper;
import com.wit.why.musicrecommend.service.IArtistsService;
import org.springframework.stereotype.Service;

@Service
public class ArtistsServiceImpl extends ServiceImpl<ArtistsMapper, Artists> implements IArtistsService {

}
