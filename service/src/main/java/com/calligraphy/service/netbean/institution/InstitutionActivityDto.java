package com.calligraphy.service.netbean.institution;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "InstitutionActivityDto", description = "机构活动信息")
public class InstitutionActivityDto {
    @ApiModelProperty(value = "机构活动id")
    private Integer institutionActivityId;

    @ApiModelProperty(value = "机构活动名称")
    private String activityName;

    @ApiModelProperty(value = "机构活动地址")
    private String activityAddress;

    @ApiModelProperty(value = "机构活动封面图")
    private String activityImage;

    @ApiModelProperty(value = "机构活动描述")
    private String activityDescription;

    @ApiModelProperty(value = "机构活动开始时间")
    private Date activityStartTime;

    @ApiModelProperty(value = "机构活动结束时间")
    private Date activityEndTime;
}
