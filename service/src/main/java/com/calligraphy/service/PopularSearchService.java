package com.calligraphy.service;


import com.calligraphy.common.netbean.PagingParam;
import org.springframework.http.ResponseEntity;

public interface PopularSearchService {

    ResponseEntity selectPopularSearch(PagingParam pagingParam);
}
