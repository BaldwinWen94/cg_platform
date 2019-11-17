package com.calligraphy.service.netbean.letter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "LetterSampleDto", description = "书法字典样例信息")
public class LetterSampleDto {
    @ApiModelProperty(value = "字典样例图片的路径", required = true)
    private String letterSampleImage;

    @ApiModelProperty(value = "字典样例图片朝代", required = true)
    private Integer letterSampleDynasty;

    @ApiModelProperty(value = "字典样例图片作者", required = true)
    private String letterSampleAuthor;
}
