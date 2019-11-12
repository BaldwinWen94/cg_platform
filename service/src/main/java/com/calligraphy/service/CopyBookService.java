package com.calligraphy.service;

import com.calligraphy.common.netbean.PagingParam;
import org.springframework.http.ResponseEntity;

public interface CopyBookService {
    ResponseEntity selectCopyBookFuzzy(String condition, PagingParam pagingParam);

    ResponseEntity selectCopyBookByAuthorName(String authorName);

    ResponseEntity selectCopyBookById(Integer copyBookId);

    ResponseEntity incrementCountForCopyBookColumn(Integer copyBookId, String column);
}
