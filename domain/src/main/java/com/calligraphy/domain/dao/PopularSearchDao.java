package com.calligraphy.domain.dao;


import com.calligraphy.domain.entity.PopularSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PopularSearchDao {
    List<PopularSearch> selectPopularSearchByPage(Integer offset,
                                                  Integer size);

    PopularSearch selectPopularSearchById(Integer popularSearchId);

    PopularSearch selectPopularSearchByName(String name);

    void createPopularSearch(PopularSearch popularSearch);

    void updatePopularSearch(PopularSearch popularSearch);

    void deletePopularSearch(Integer popularSearchId);
}
