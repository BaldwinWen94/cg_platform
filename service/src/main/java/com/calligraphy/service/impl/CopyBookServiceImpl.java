package com.calligraphy.service.impl;

import com.calligraphy.common.netbean.PagingData;
import com.calligraphy.common.netbean.PagingParam;
import com.calligraphy.common.util.HttpUtil;
import com.calligraphy.domain.dao.CopyBookDao;
import com.calligraphy.domain.entity.CopyBook;
import com.calligraphy.domain.entity.CopyBookDetail;
import com.calligraphy.domain.entity.CopyBookTag;
import com.calligraphy.service.CopyBookService;
import com.calligraphy.service.converter.CopyBookConverter;
import com.calligraphy.service.netbean.copybook.CopyBookDto;
import com.calligraphy.service.netbean.copybook.CopyBookOverviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CopyBookServiceImpl implements CopyBookService {

    private final CopyBookDao copyBookDao;

    @Autowired
    public CopyBookServiceImpl(CopyBookDao copyBookDao) {
        this.copyBookDao = copyBookDao;
    }

    public ResponseEntity selectCopyBookFuzzy(String condition, PagingParam pagingParam) {
        PagingData<CopyBookOverviewDto> pagingData = new PagingData<>();

        condition = condition == null ? "" : condition;
        pagingData.setTotalCount(copyBookDao.countCopyBookByNameFuzzy(condition));

        List<CopyBook> copyBookList = copyBookDao.selectCopyBookByNameFuzzy(condition, pagingParam.getOffset(),
                pagingParam.getSize());
        List<CopyBookOverviewDto> overviewDtoList = copyBookList.stream().map(CopyBookConverter::toOverviewDto)
                .collect(Collectors.toList());
        pagingData.setData(overviewDtoList);

        copyBookDao.incrementCopyBookTagSearchTimes(condition);
        return HttpUtil.successWithData(pagingData);
    }

    @Override
    public ResponseEntity selectCopyBookByAuthorName(String authorName) {
        List<CopyBook> copyBookList = copyBookDao.selectCopyBookByAuthorName(authorName);
        List<CopyBookOverviewDto> overviewDtoList = copyBookList.stream().map(CopyBookConverter::toOverviewDto)
                .collect(Collectors.toList());
        return HttpUtil.successWithData(overviewDtoList);
    }

    public ResponseEntity selectCopyBookById(Integer copyBookId) {
        CopyBook copyBook = copyBookDao.selectCopyBookById(copyBookId);
        if (copyBook == null) {
            return HttpUtil.resourceNotFound();
        }

        List<CopyBookTag> tagList = copyBookDao.selectTagOfCopyBook(copyBookId);
        List<CopyBookDetail> detailList = copyBookDao.selectDetailOfCopyBook(copyBookId);
        CopyBookDto detailDto = CopyBookConverter.toDto(copyBook, tagList, detailList);

        return HttpUtil.successWithData(detailDto);
    }

    @Override
    public ResponseEntity incrementCountForCopyBookColumn(Integer copyBookId, String column) {
        CopyBook copyBook = copyBookDao.selectCopyBookById(copyBookId);
        if (copyBook == null) {
            return HttpUtil.resourceNotFound();
        }

        copyBookDao.incrementColumnOfCopyBook(column, copyBookId);
        return HttpUtil.successWithNoData();
    }
}
