package com.wit.why.musicrecommend.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_artists")
public class Read {
    private Integer userId;
    private Integer artistsId;
    private Integer weight;
    private Long timestamp;
}
