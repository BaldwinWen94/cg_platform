package com.calligraphy.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitutionPrincipalQuote extends CalligraphyBaseEntity {
    private Integer institutionId;

    private String principalName;

    private String principalQuote;

    private String quoteImage;

    private String quoteDescription;
}
