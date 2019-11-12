package com.calligraphy.domain.dao;


import com.calligraphy.domain.entity.CopyBook;
import com.calligraphy.domain.entity.CopyBookDetail;
import com.calligraphy.domain.entity.CopyBookTag;

import java.util.List;

public interface CopyBookDao {
    List<CopyBook> selectCopyBookByDefault(Integer offset,
                                           Integer size);

    List<CopyBook> selectCopyBookByNameFuzzy(String condition,
                                             Integer offset,
                                             Integer size);

    List<CopyBook> selectCopyBookByAuthorName(String authorName);

    Integer countCopyBookByDefault();

    Integer countCopyBookByNameFuzzy(String condition);

    CopyBook selectCopyBookById(Integer copyBookId);

    void createCopyBook(CopyBook copyBook);

    void updateCopyBook(CopyBook copyBook);

    void deleteCopyBook(Integer copyBookId);

    void incrementColumnOfCopyBook(String column,
                                   Integer copyBookId);

    List<CopyBookTag> selectTagOfCopyBook(Integer copyBookId);

    void createCopyBookTag(CopyBookTag copyBookTag);

    void incrementCopyBookTagSearchTimes(String tagName);

    void deleteTagOfCopyBook(Integer copyBookId);

    List<CopyBookDetail> selectDetailOfCopyBook(Integer copybookId);

    Integer countCopyBookDetail(Integer copyBookId);

    void createCopyBookDetail(CopyBookDetail copyBookDetail);

    void deleteDetailOfCopyBook(Integer copyBookId);
}
