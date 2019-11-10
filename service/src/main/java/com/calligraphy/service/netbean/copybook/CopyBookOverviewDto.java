package com.calligraphy.service.netbean.copybook;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "CopyBookOverviewDto", description = "字帖概要信息，用于查询字帖概要")
@Data
public class CopyBookOverviewDto {
    @ApiModelProperty(value = "字帖id", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Integer copyBookId;

    @ApiModelProperty(value = "字帖名称")
    private String copyBookName;

    @ApiModelProperty(value = "字帖作者")
    private String copyBookAuthor;

    @ApiModelProperty(value = "封面图片")
    private String coverImageUrl;
}
