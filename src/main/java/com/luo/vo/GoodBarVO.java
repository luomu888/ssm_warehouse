package com.luo.vo;

import java.util.List;

public class GoodBarVO {
    private List<String> names;
    private List<Integer> values;

    public GoodBarVO() {
    }

    public GoodBarVO(List<String> names, List<Integer> values) {
        this.names = names;
        this.values = values;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }
}
