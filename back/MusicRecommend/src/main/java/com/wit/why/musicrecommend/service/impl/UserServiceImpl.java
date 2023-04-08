package com.wit.why.musicrecommend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wit.why.musicrecommend.domain.User;
import com.wit.why.musicrecommend.mapper.UserMapper;
import com.wit.why.musicrecommend.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
