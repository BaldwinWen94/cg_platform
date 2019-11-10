package com.calligraphy.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CopyBookDetail extends CalligraphyBaseEntity {
    private Integer copyBookId;

    private Integer sequenceNo;

    private String highResolutionImage;

    private String lowResolutionImage;

    private String thumbnail;
}
