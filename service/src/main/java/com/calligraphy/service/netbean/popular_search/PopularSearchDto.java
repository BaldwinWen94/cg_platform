package com.calligraphy.service.netbean.popular_search;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "PopularSearchDto", description = "热门搜索信息")
@Data
public class PopularSearchDto {
    @ApiModelProperty(value = "id, 仅返回时需要")
    private Integer popularSearchId;

    @ApiModelProperty(value = "热门搜索名称", required = true)
    @NotNull(message = "热门搜索名称不能为空")
    @Size(max = 60, message = "热门搜索名称超长")
    private String popularSearchName;
}
