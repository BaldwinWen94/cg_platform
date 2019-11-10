package com.calligraphy.service.netbean.institution;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(value = "InstitutionCourseOverviewDto", description = "机构课程概要信息")
public class InstitutionCourseOverviewDto {
    @ApiModelProperty(value = "机构课程id")
    private Integer institutionCourseId;

    @ApiModelProperty(value = "机构课程名称")
    private String courseName;

    @ApiModelProperty(value = "机构课程目标")
    private String coursePurpose;

    @ApiModelProperty(value = "机构课程费用")
    private BigDecimal courseFee;
}
