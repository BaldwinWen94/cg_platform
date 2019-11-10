package com.calligraphy.domain.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public abstract class CalligraphyBaseEntity {
    private Integer id;

    private Timestamp createTime;

    private Timestamp modifyTime;
}
