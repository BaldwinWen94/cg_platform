package com.calligraphy.common.netbean;

import lombok.Data;

import java.util.List;

@Data
public class PagingData<T> {
    private Integer totalCount;

    private List<T> data;
}
