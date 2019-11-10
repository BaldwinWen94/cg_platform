package com.calligraphy.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class InstitutionCourse extends CalligraphyBaseEntity {
    private Integer institutionId;

    private String courseName;

    private String courseType;

    private String coursePurpose;

    private String courseContent;

    private String courseDescription;

    private BigDecimal courseFee;
}
