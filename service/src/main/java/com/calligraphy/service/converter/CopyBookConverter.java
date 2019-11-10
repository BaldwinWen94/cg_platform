package com.calligraphy.service.converter;

import com.calligraphy.domain.entity.CopyBook;
import com.calligraphy.domain.entity.CopyBookDetail;
import com.calligraphy.domain.entity.CopyBookTag;
import com.calligraphy.service.netbean.copybook.CopyBookDetailDto;
import com.calligraphy.service.netbean.copybook.CopyBookDto;
import com.calligraphy.service.netbean.copybook.CopyBookOverviewDto;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class CopyBookConverter {
    private static final String defaultCopyBookSource = "全民书法网";

    public static CopyBookOverviewDto toOverviewDto(CopyBook copyBook) {
        CopyBookOverviewDto overviewDto = new CopyBookOverviewDto();
        overviewDto.setCopyBookId(copyBook.getId());
        overviewDto.setCopyBookName(copyBook.getCopyBookName());
        overviewDto.setCopyBookAuthor(copyBook.getCopyBookAuthor());
        overviewDto.setCoverImageUrl(copyBook.getCoverImageUrl());
        return overviewDto;
    }

    public static CopyBookDto toDto(CopyBook copyBook, List<CopyBookTag> copyBookTagList, Integer detailCount,
                                    List<CopyBookDetail> copyBookDetails) {
        CopyBookDto dto = new CopyBookDto();
        dto.setCopyBookId(copyBook.getId());
        dto.setCopyBookName(copyBook.getCopyBookName());
        dto.setCopyBookType(copyBook.getCopyBookType());
        dto.setCopyBookDynasty(copyBook.getCopyBookDynasty());
        dto.setCopyBookAuthor(copyBook.getCopyBookAuthor());

        dto.setCopyBookContent(StringUtils.isEmpty(copyBook.getCopyBookContent()) ? ""
                : copyBook.getCopyBookContent());
        dto.setCopyBookSource(StringUtils.isEmpty(copyBook.getCopyBookSource()) ? ""
                : copyBook.getCopyBookSource());
        dto.setCoverImageUrl(StringUtils.isEmpty(copyBook.getCoverImageUrl()) ? ""
                : copyBook.getCoverImageUrl());
        dto.setDisplayImageUrl(StringUtils.isEmpty(copyBook.getDisplayImageUrl()) ? ""
                : copyBook.getDisplayImageUrl());

        dto.setLowResolutionDownloadTimes(copyBook.getLowResolutionDownloadTimes());
        dto.setHighResolutionDownloadTimes(copyBook.getHighResolutionDownloadTimes());
        dto.setReadTimes(copyBook.getReadTimes());
        dto.setCommendTimes(copyBook.getCommendTimes());
        dto.setCopyBookTagList(copyBookTagList.stream().map(CopyBookTag::getCopyBookTagName)
                .collect(Collectors.toList()));

        if (copyBookDetails != null) {
            dto.setCopyBookDetailList(copyBookDetails.stream().map(CopyBookConverter::toDetailDto)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static CopyBook toEntity(CopyBookDto copyBookDto) {
        CopyBook copyBook = new CopyBook();
        toEntity(copyBookDto, copyBook);
        return copyBook;
    }

    public static CopyBook toEntity(CopyBookDto copyBookDto, CopyBook copyBook) {
        copyBook.setCopyBookName(copyBookDto.getCopyBookName());
        copyBook.setCopyBookType(copyBookDto.getCopyBookType());
        copyBook.setCopyBookDynasty(copyBookDto.getCopyBookDynasty());
        copyBook.setCopyBookAuthor(copyBookDto.getCopyBookAuthor());

        copyBook.setCopyBookContent(copyBookDto.getCopyBookContent());
        copyBook.setCopyBookSource(StringUtils.isEmpty(copyBookDto.getCopyBookSource()) ?
                defaultCopyBookSource : copyBookDto.getCopyBookSource());

        copyBook.setCoverImageUrl(copyBookDto.getCoverImageUrl());
        copyBook.setDisplayImageUrl(copyBookDto.getDisplayImageUrl());

        copyBook.setLowResolutionDownloadTimes(copyBookDto.getLowResolutionDownloadTimes() != null ?
                copyBookDto.getLowResolutionDownloadTimes() : 0);

        copyBook.setHighResolutionDownloadTimes(copyBookDto.getHighResolutionDownloadTimes() != null ?
                copyBookDto.getHighResolutionDownloadTimes() : 0);

        copyBook.setReadTimes(copyBookDto.getReadTimes() != null ? copyBookDto.getReadTimes() : 0);
        copyBook.setCommendTimes(copyBookDto.getCommendTimes() != null ? copyBookDto.getCommendTimes() : 0);
        return copyBook;
    }

    public static CopyBookDetailDto toDetailDto(CopyBookDetail detail) {
        CopyBookDetailDto detailDto = new CopyBookDetailDto();
        detailDto.setSequenceNo(detail.getSequenceNo());
        detailDto.setHighResolutionImage(detail.getHighResolutionImage());
        detailDto.setLowResolutionImage(detail.getLowResolutionImage());
        detailDto.setThumbnail(detail.getThumbnail());
        return detailDto;
    }
}
