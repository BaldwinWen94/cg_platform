package com.calligraphy.service.impl;

import com.calligraphy.common.enumeration.FontType;
import com.calligraphy.common.util.HttpUtil;
import com.calligraphy.domain.dao.LetterDao;
import com.calligraphy.domain.entity.Letter;
import com.calligraphy.service.LetterService;
import com.calligraphy.service.converter.LetterConverter;
import com.calligraphy.service.netbean.letter.LetterQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LetterServiceImpl implements LetterService {

    private final LetterDao letterDao;

    @Autowired
    public LetterServiceImpl(LetterDao letterDao) {
        this.letterDao = letterDao;
    }

    @Override
    public ResponseEntity selectLetterSampleByFontType(String letter, Integer fontType) {
        if (StringUtils.isEmpty(letter)) {
            return HttpUtil.parameterError("查询不能为空");
        }

        letter = letter.trim();
        if (letter.length() > 5) {
            return HttpUtil.parameterError("查询不能超过5个字");
        }

        if (!FontType.checkFontType(fontType)) {
            return HttpUtil.parameterError("字体类型不正确");
        }

        List<LetterQueryDto> queryDtoList = new ArrayList<>();
        for (int i = 0; i < letter.length(); i++) {
            String tmpLetter = letter.substring(i, 1);

            List<Letter> sampleList = letterDao.selectLetterSampleByFontType(tmpLetter, fontType);
            if (!CollectionUtils.isEmpty(sampleList)) {
                LetterQueryDto queryDto = new LetterQueryDto();
                queryDto.setLetterName(tmpLetter);
                queryDto.setSampleDtoList(sampleList.stream().map(LetterConverter::convertToSampleDto)
                        .collect(Collectors.toList()));
                queryDtoList.add(queryDto);
            }
        }
        return HttpUtil.successWithData(queryDtoList);
    }
}
