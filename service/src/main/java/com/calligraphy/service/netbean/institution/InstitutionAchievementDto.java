package com.calligraphy.service.netbean.institution;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "InstitutionAchievementDto", description = "机构历年成绩信息")
public class InstitutionAchievementDto {
    @ApiModelProperty(value = "机构成绩id")
    private Integer institutionAchievementId;

    @ApiModelProperty(value = "成绩年份")
    private Integer achievementYear;

    @ApiModelProperty(value = "成绩图片")
    private String achievementImage;

    @ApiModelProperty(value = "成绩内容（富文本）")
    private String achievementContent;
}
