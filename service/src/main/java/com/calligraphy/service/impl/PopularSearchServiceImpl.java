package com.calligraphy.service.impl;


import com.calligraphy.common.netbean.PagingParam;
import com.calligraphy.common.util.HttpUtil;
import com.calligraphy.domain.dao.PopularSearchDao;
import com.calligraphy.domain.entity.PopularSearch;
import com.calligraphy.service.PopularSearchService;
import com.calligraphy.service.converter.PopularSearchConverter;
import com.calligraphy.service.netbean.popular_search.PopularSearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PopularSearchServiceImpl implements PopularSearchService {

    private final PopularSearchDao popularSearchDao;

    @Autowired
    public PopularSearchServiceImpl(PopularSearchDao popularSearchDao) {
        this.popularSearchDao = popularSearchDao;
    }

    public ResponseEntity selectPopularSearch(PagingParam pagingParam) {
        List<PopularSearch> popularSearchList = popularSearchDao.selectPopularSearchByPage(pagingParam.getOffset(), pagingParam.getSize());

        List<PopularSearchDto> popularSearchDtoList = popularSearchList.stream()
                .map(PopularSearchConverter::toDto).collect(Collectors.toList());
        return HttpUtil.successWithData(popularSearchDtoList);
    }

}
