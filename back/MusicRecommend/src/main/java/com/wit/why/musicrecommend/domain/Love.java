package com.wit.why.musicrecommend.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_like")
public class Love {
    private Integer userId;
    private Integer artistsId;
    private Long timestamp;
}
