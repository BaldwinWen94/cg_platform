package com.calligraphy.service.netbean.institution;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "InstitutionActivityOverviewDto", description = "机构活动概要信息")
public class InstitutionActivityOverviewDto {
    @ApiModelProperty(value = "机构活动id")
    private Integer institutionActivityId;

    @ApiModelProperty(value = "机构活动图片")
    private String activityImage;

    @ApiModelProperty(value = "活动状态，未开始/进行中/已结束")
    private ActivityStatus activityStatus;

    public enum ActivityStatus {
        NOT_STARTED, ONGOING, ENDED
    }
}
