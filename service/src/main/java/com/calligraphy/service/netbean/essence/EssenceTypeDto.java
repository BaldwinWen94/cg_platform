package com.calligraphy.service.netbean.essence;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "EssenceTypeDto", description = "书家必携类型信息")
public class EssenceTypeDto {
    @ApiModelProperty(value = "书家必携类型一级分类")
    private String essenceType1;

    @ApiModelProperty(value = "书家必携类型二级分类")
    private List<EssenceSubTypeDto> essenceType2;
}
