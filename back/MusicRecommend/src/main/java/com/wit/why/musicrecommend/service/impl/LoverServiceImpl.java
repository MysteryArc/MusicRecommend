package com.wit.why.musicrecommend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wit.why.musicrecommend.domain.Love;
import com.wit.why.musicrecommend.mapper.LoveMapper;
import com.wit.why.musicrecommend.service.ILoveService;
import org.springframework.stereotype.Service;

@Service
public class LoverServiceImpl extends ServiceImpl<LoveMapper, Love> implements ILoveService {
}
