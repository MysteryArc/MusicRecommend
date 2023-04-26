package com.wit.why.musicrecommend.domain.parm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoveForm {
    private Integer userId;
    private Integer artistId;
}
