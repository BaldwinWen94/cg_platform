package com.calligraphy.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CopyBook extends CalligraphyBaseEntity {
    private String copyBookName;

    private String copyBookType;

    private String copyBookDynasty;

    private String copyBookAuthor;

    private String copyBookContent;

    private String copyBookSource;

    private String coverImageUrl;

    private String displayImageUrl;

    private Integer lowResolutionDownloadTimes;

    private Integer highResolutionDownloadTimes;

    private Integer readTimes;

    private Integer commendTimes;
}
