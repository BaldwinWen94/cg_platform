package com.calligraphy.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Letter extends CalligraphyBaseEntity {
    private String letterName;

    private Integer fontType;

    private String letterSampleImage;

    private String letterSampleAuthor;
}
