package com.calligraphy.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CopyBookTag extends CalligraphyBaseEntity {

    private String copyBookTagName;

    private Integer copyBookId;

    private Integer searchTimes;
}
