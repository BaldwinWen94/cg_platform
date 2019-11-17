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
import com.calligraphy.service.netbean.essence.EssenceSubTypeDto;
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

        List<String> type1List = essenceTypeList.stream().map(EssenceType::getEssenceType1)
                .distinct().collect(Collectors.toList());

        List<EssenceTypeDto> typeDtoList = type1List.stream().map(key -> {
            EssenceTypeDto typeDto = new EssenceTypeDto();
            typeDto.setEssenceType1(key);
            typeDto.setEssenceType2(essenceTypeList.stream()
                    .filter(essenceType -> essenceType.getEssenceType1().equals(key))
                    .map(essenceType -> {
                        EssenceSubTypeDto subTypeDto = new EssenceSubTypeDto();
                        subTypeDto.setEssenceTypeId(essenceType.getId());
                        subTypeDto.setEssenceType2(essenceType.getEssenceType2());
                        return subTypeDto;
                    }).collect(Collectors.toList()));
            return typeDto;
        }).collect(Collectors.toList());

        return HttpUtil.successWithData(typeDtoList);
    }

    public ResponseEntity selectEssenceByCondition(String essenceType1, String essenceType2, Integer wordCount,
                                                   Integer dynasty, PagingParam pagingParam) {
        if (!essenceType2.equals("全部") && essenceDao.selectEssenceTypeByCondition(essenceType1, essenceType2) == null) {
            return HttpUtil.parameterError("书家必携类型有误");
        }

        //"全部"查询的条件在sql中体现
        PagingData<EssenceDto> pagingData = new PagingData<>();
        pagingData.setTotalCount(essenceDao.countEssenceByCondition(essenceType1, essenceType2, wordCount, dynasty));

        List<EssenceResult> essenceList = essenceDao.selectEssenceByCondition(essenceType1, essenceType2, wordCount,
                dynasty, pagingParam.getOffset(), pagingParam.getSize());
        List<EssenceDto> essenceDtoList = essenceList.stream().map(EssenceConverter::toDto)
                .collect(Collectors.toList());

        return HttpUtil.successWithData(essenceDtoList);
    }
}
