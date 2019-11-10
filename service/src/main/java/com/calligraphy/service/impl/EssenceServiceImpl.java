package com.calligraphy.service.impl;


import com.calligraphy.common.netbean.PagingData;
import com.calligraphy.common.netbean.PagingParam;
import com.calligraphy.common.util.HttpUtil;
import com.calligraphy.domain.dao.EssenceDao;
import com.calligraphy.domain.entity.EssenceType;
import com.calligraphy.domain.result.EssenceResult;
import com.calligraphy.service.EssenceService;
import com.calligraphy.service.converter.EssenceConverter;
import com.calligraphy.service.netbean.essence.EssenceDto;
import com.calligraphy.service.netbean.essence.EssenceTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EssenceServiceImpl implements EssenceService {
    private final EssenceDao essenceDao;

    @Autowired
    public EssenceServiceImpl(EssenceDao essenceDao) {
        this.essenceDao = essenceDao;
    }

    public ResponseEntity selectAllEssenceType() {
        List<EssenceType> essenceTypeList = essenceDao.selectAllEssenceType();
        List<EssenceTypeDto> essenceTypeDtoList = essenceTypeList.stream().map(EssenceConverter::toTypeDto)
                .collect(Collectors.toList());

        return HttpUtil.successWithData(essenceTypeDtoList);
    }

    public ResponseEntity selectEssenceByCondition(String essenceType1, String essenceType2, String wordCount,
                                                   String dynasty, PagingParam pagingParam) {
        PagingData<EssenceDto> pagingData = new PagingData<>();
        pagingData.setTotalCount(essenceDao.countEssenceByCondition(essenceType1, essenceType2, wordCount, dynasty));

        List<EssenceResult> essenceList = essenceDao.selectEssenceByCondition(essenceType1, essenceType2, wordCount,
                dynasty, pagingParam.getOffset(), pagingParam.getSize());
        List<EssenceDto> essenceDtoList = essenceList.stream().map(EssenceConverter::toDto)
                .collect(Collectors.toList());

        return HttpUtil.successWithData(essenceDtoList);
    }
}
