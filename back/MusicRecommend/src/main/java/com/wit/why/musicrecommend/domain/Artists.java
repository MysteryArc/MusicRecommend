package com.wit.why.musicrecommend.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("artists")
@AllArgsConstructor
@NoArgsConstructor

//音乐类
public class Artists {
    private Integer cloudId;
    private String name;
    private String singer;
    private String picUrl;
    private String album;
    private String playUrl;
    private Integer id;
}
