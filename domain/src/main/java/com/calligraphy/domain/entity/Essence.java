package com.calligraphy.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Essence extends CalligraphyBaseEntity {

    private String essenceText;

    private Integer essenceTypeId;

    private Integer essenceDynasty;

    private String essenceSource;

    private Integer wordCount;

    private String essenceDesc;
}
