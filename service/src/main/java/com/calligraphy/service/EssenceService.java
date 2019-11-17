package com.calligraphy.service;

import com.calligraphy.common.netbean.PagingParam;
import org.springframework.http.ResponseEntity;

public interface EssenceService {

    ResponseEntity selectAllEssenceType();

    ResponseEntity selectEssenceByCondition(String essenceType1, String essenceType2, Integer wordCount,
                                            Integer dynasty, PagingParam pagingParam);
}
