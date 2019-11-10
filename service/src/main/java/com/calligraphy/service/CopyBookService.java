package com.calligraphy.service;

import com.calligraphy.common.netbean.PagingParam;
import org.springframework.http.ResponseEntity;

public interface CopyBookService {
    ResponseEntity selectCopyBookFuzzy(String condition, PagingParam pagingParam);

    ResponseEntity selectCopyBookByIdForUser(Integer copyBookId);

    ResponseEntity selectCopyBookDetail(Integer copyBookId, Integer sequenceNo);

    ResponseEntity incrementCountForCopyBookColumn(Integer copyBookId, String column);
}
