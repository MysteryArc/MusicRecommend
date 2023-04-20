package com.wit.why.musicrecommend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wit.why.musicrecommend.domain.Admin;
import com.wit.why.musicrecommend.mapper.AdminMapper;
import com.wit.why.musicrecommend.service.IAdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
}
