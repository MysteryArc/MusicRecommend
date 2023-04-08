package com.wit.why.musicrecommend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wit.why.musicrecommend.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
