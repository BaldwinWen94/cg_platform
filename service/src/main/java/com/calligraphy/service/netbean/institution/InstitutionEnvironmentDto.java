package com.calligraphy.service.netbean.institution;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "InstitutionEnvironmentDto", description = "机构环境信息")
public class InstitutionEnvironmentDto {
    @ApiModelProperty(value = "机构环境id")
    private Integer institutionEnvironmentId;

    @ApiModelProperty(value = "环境图片")
    private String environmentImage;
}
