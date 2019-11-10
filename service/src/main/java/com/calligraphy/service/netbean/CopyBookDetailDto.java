package com.calligraphy.service.netbean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "CopyBookDetailDto", description = "字帖详细信息")
@Data
public class CopyBookDetailDto {
    @ApiModelProperty(value = "字帖内图片编号")
    private Integer sequenceNo;

    @ApiModelProperty(value = "编号对应高清图")
    private String highResolutionImage;

    @ApiModelProperty(value = "编号对应低清图")
    private String lowResolutionImage;

    @ApiModelProperty(value = "编号对应缩略图")
    private String thumbnail;
}
