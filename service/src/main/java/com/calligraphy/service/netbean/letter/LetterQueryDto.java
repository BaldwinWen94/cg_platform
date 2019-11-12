package com.calligraphy.service.netbean.letter;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "LetterQueryDto", description = "书法字典查询信息")
public class LetterQueryDto {
    private String letterName;

    private List<LetterSampleDto> sampleDtoList;
}
