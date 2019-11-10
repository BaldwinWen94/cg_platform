package com.calligraphy.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitutionEnvironment extends CalligraphyBaseEntity {
    private Integer institutionId;

    private String environmentImage;
}
