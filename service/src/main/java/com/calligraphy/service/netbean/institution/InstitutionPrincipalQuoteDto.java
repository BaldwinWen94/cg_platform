package com.calligraphy.service.netbean.institution;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "InstitutionPrincipalQuoteDto", description = "机构活动信息")
public class InstitutionPrincipalQuoteDto {
    @ApiModelProperty(value = "机构校长寄语id")
    private Integer institutionPrincipalQuoteId;

    @ApiModelProperty(value = "校长姓名")
    private String principalName;

    @ApiModelProperty(value = "校长寄语")
    private String principalQuote;

    @ApiModelProperty(value = "校长寄语背景图")
    private String quoteImage;

    @ApiModelProperty(value = "校长寄语描述")
    private String quoteDescription;
}
