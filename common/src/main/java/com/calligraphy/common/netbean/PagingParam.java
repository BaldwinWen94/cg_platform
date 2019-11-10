package com.calligraphy.common.netbean;

import lombok.Data;

@Data
public class PagingParam {
    private int offset;

    private int size;

    public PagingParam(Integer pageStart, Integer pageSize) {
        offset = pageStart == null || pageStart < 0 ? 0 : (pageStart - 1) * pageSize;
        size = pageSize == null || pageSize < 0 ? 10 : pageSize;
    }
}
