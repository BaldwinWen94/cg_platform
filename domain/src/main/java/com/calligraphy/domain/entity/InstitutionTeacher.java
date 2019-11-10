package com.calligraphy.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitutionTeacher extends CalligraphyBaseEntity {
    private Integer institutionId;

    private String teacherName;

    private String teacherImage;

    private String teacherDescription;
}
