package com.calligraphy.service.netbean.essence;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "EssenceSubTypeDto", description = "书家必携次级类型信息")
public class EssenceSubTypeDto {
    private Integer essenceTypeId;

    private String essenceType2;
}
