package com.calligraphy.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitutionAchievement extends CalligraphyBaseEntity {
    private Integer institutionId;

    private Integer achievementYear;

    private String achievementImage;

    private String achievementContent;
}
