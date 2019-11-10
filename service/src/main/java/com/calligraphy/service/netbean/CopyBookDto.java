package com.calligraphy.service.netbean;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@ApiModel(value = "CopyBookDto", description = "字帖详细信息，用于创建、修改字帖及查询字帖详情")
@Data
public class CopyBookDto {
    @ApiModelProperty(value = "字帖id", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Integer copyBookId;

    @ApiModelProperty(value = "字帖名称", required = true)
    @NotNull(message = "字帖名称不能为空")
    @Size(max = 60, message = "字帖名称超长")
    private String copyBookName;

    @ApiModelProperty(value = "字帖类型", required = true)
    @NotNull(message = "字帖类型不能为空")
    @Size(max = 45, message = "字帖类型超长")
    private String copyBookType;

    @ApiModelProperty(value = "字帖朝代", required = true)
    @NotNull(message = "字帖朝代不能为空")
    @Size(max = 45, message = "字帖作者超长")
    private String copyBookDynasty;

    @ApiModelProperty(value = "字帖作者", required = true)
    @NotNull(message = "字帖作者不能为空")
    @Size(max = 45, message = "字帖作者超长")
    private String copyBookAuthor;

    @ApiModelProperty(value = "字帖内容，富文本")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String copyBookContent;

    @ApiModelProperty(value = "字帖来源")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Size(max = 60, message = "字帖来源超长")
    private String copyBookSource;

    @ApiModelProperty(value = "封面图片", required = true)
    @NotNull(message = "封面图片不能为空")
    @Size(max = 256, message = "封面图片路径超长")
    private String coverImageUrl;

    @ApiModelProperty(value = "详情页展示图片")
    @Size(max = 256, message = "详情页图片路径超长")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String displayImageUrl;

    @ApiModelProperty(value = "低分辨率图片下载次数")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer lowResolutionDownloadTimes;

    @ApiModelProperty(value = "高分辨率图片下载次数")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer highResolutionDownloadTimes;

    @ApiModelProperty(value = "阅读次数")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer readTimes;

    @ApiModelProperty(value = "推荐次数")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer commendTimes;

    @ApiModelProperty(value = "字帖标签列表")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> copyBookTagList;

    @ApiModelProperty(value = "字帖明细图片列表，用于后台查询，用户端不返回此字段")
    private List<CopyBookDetailDto> copyBookDetailList;
}
