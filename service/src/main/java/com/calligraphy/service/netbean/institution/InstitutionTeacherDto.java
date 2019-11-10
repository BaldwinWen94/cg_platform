package com.calligraphy.service.netbean.institution;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "InstitutionTeacherDto", description = "机构教师信息")
public class InstitutionTeacherDto {
    @ApiModelProperty(value = "机构教师id")
    private Integer institutionTeacherId;

    @ApiModelProperty(value = "教师名称")
    private String teacherName;

    @ApiModelProperty(value = "教师图像")
    private String teacherImage;

    @ApiModelProperty(value = "教师描述")
    private String teacherDescription;
}
