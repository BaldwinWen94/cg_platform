package com.calligraphy.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InstitutionActivity extends CalligraphyBaseEntity {
    private Integer institutionId;

    private String activityName;

    private String activityAddress;

    private String activityImage;

    private String activityDescription;

    private Date activityStartTime;

    private Date activityEndTime;
}
