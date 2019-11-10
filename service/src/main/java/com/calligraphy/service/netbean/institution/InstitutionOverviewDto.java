package com.calligraphy.service.netbean.institution;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "InstitutionOverviewDto", description = "机构概要信息")
public class InstitutionOverviewDto {
    @ApiModelProperty(value = "机构id")
    private Integer institutionId;

    @ApiModelProperty(value = "机构名称")
    private String institutionName;

    @ApiModelProperty(value = "机构图标")
    private String institutionIcon;

    @ApiModelProperty(value = "机构位置")
    private String institutionLocation;

    @ApiModelProperty(value = "机构描述")
    private String institutionDescription;

    @ApiModelProperty(value = "机构环境图片（前三张）")
    private List<String> institutionEnvironmentBriefList;
}
