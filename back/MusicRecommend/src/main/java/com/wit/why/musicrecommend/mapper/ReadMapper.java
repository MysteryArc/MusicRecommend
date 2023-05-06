package com.wit.why.musicrecommend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wit.why.musicrecommend.domain.Read;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReadMapper extends BaseMapper<Read> {

    @Select("select artists_id from user_artists group by artists_id order by count(artists_id) desc;")
    public List<Integer> hot();
}
