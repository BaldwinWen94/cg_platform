package com.calligraphy.service.netbean.essence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ApiModel(value = "EssenceDto", description = "书家必携信息")
public class EssenceDto {
    @ApiModelProperty(value = "书家必携id")
    private Integer essenceId;

    @ApiModelProperty(value = "书家必携内容", required = true)
    @NotNull(message = "内容不能为空")
    @Size(max = 500, message = "内容超长")
    private String essenceText;

    @ApiModelProperty(value = "书家必携类型一级分类，若1&2分类组合 在书家必携新建前不存在，则先新建分类，再新建必携", required = true)
    @NotNull(message = "一级分类不能为空")
    @Size(max = 45, message = "一级分类超长")
    private String essenceType1;

    @ApiModelProperty(value = "书家必携类型二级分类, 为空请传空字符串", required = true)
    @NotNull(message = "二级分类不能为空")
    @Size(max = 45, message = "二级分类超长")
    private String essenceType2;

    @ApiModelProperty(value = "书家必携朝代", required = true)
    @NotNull(message = "朝代不能为空")
    private Integer essenceDynasty;

    @ApiModelProperty(value = "书家必携来源（作者或书名或其他）", required = true)
    @NotNull(message = "来源不能为空")
    @Size(max = 60, message = "来源超长")
    private String essenceSource;

    @ApiModelProperty(value = "书家必携字数分类", required = true)
    @NotNull(message = "字数分类不能为空")
    private Integer wordCount;

    @ApiModelProperty(value = "书家必携其它描述")
    private String essenceDesc;
}
