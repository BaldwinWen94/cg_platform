package com.calligraphy.service.converter;


import com.calligraphy.domain.entity.PopularSearch;
import com.calligraphy.service.netbean.popular_search.PopularSearchDto;

public class PopularSearchConverter {
    public static PopularSearchDto toDto(PopularSearch popularSearch) {
        PopularSearchDto dto = new PopularSearchDto();
        dto.setPopularSearchId(popularSearch.getId());
        dto.setPopularSearchName(popularSearch.getPopularSearchName());
        return dto;
    }

    public static PopularSearch toEntity(PopularSearchDto popularSearchDto) {
        PopularSearch popularSearch = new PopularSearch();
        popularSearch.setPopularSearchName(popularSearchDto.getPopularSearchName());
        return popularSearch;
    }
}
