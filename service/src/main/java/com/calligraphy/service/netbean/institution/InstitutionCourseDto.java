package com.calligraphy.service.netbean.institution;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(value = "InstitutionCourseDto", description = "机构课程信息")
public class InstitutionCourseDto {
    @ApiModelProperty(value = "机构课程id")
    private Integer institutionCourseId;

    @ApiModelProperty(value = "机构课程名称")
    private String courseName;

    @ApiModelProperty(value = "机构课程类型")
    private String courseType;

    @ApiModelProperty(value = "机构课程目标")
    private String coursePurpose;

    @ApiModelProperty(value = "机构课程内容")
    private String courseContent;

    @ApiModelProperty(value = "机构课程描述（报名须知）")
    private String courseDescription;

    @ApiModelProperty(value = "机构课程费用")
    private BigDecimal courseFee;
}
