package com.wit.why.musicrecommend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wit.why.musicrecommend.domain.Read;
import com.wit.why.musicrecommend.mapper.ReadMapper;
import com.wit.why.musicrecommend.service.IReadService;
import org.springframework.stereotype.Service;

@Service
public class ReadServiceImpl extends ServiceImpl<ReadMapper, Read> implements IReadService{
}
