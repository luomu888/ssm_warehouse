package com.luo.vo;

import com.luo.entity.Floor;

public class FloorVo extends Floor {
    //当前的页码
    private Integer page;
    //每页数据的数量
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
