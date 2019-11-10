package com.calligraphy.service.netbean.institution;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "InstitutionDto", description = "机构详细信息")
public class InstitutionDto {
    @ApiModelProperty(value = "机构id")
    private Integer institutionId;

    @ApiModelProperty(value = "机构名称")
    private String institutionName;

    @ApiModelProperty(value = "机构位置")
    private String institutionLocation;

    @ApiModelProperty(value = "机构图标")
    private String institutionIcon;

    @ApiModelProperty(value = "机构描述")
    private String institutionDescription;

    @ApiModelProperty(value = "机构图片")
    private String institutionImage;

    @ApiModelProperty(value = "机构关注人数")
    private Integer followCount;

    @ApiModelProperty(value = "机构历年成绩列表")
    private List<InstitutionAchievementDto> achievementDtoList;

    @ApiModelProperty(value = "机构环境列表")
    private List<InstitutionEnvironmentDto> environmentDtoList;

    @ApiModelProperty(value = "机构教师列表")
    private List<InstitutionTeacherDto> teacherDtoList;

    @ApiModelProperty(value = "机构校长寄语")
    private InstitutionPrincipalQuoteDto principalQuoteDto;

    @ApiModelProperty(value = "机构课程列表")
    private List<InstitutionCourseDto> courseDtoList;

    @ApiModelProperty(value = "机构活动列表")
    private List<InstitutionActivityDto> activityDtoList;
}
