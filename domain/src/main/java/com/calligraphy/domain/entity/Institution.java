package com.calligraphy.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Institution extends CalligraphyBaseEntity {
    private String institutionName;

    private String institutionLocation;

    private String institutionIcon;

    private String institutionDescription;

    private String institutionImage;

    private Integer followCount;
}
