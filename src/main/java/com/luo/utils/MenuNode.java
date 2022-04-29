package com.luo.utils;

import java.util.List;

/**
 * 首页里的菜单栏下的子菜单
 */
public class MenuNode {
    private Integer id;//菜单编号
    private Integer pid;//父级菜单
    private String title;//菜单名称
    private String href;//链接
    private Integer spread;//是否展开（0否 1是）
    private String target;//打开方式
    private String icon;//菜单图标
    private List<MenuNode> child;//子菜单

    public List<MenuNode> getChild() {
        return child;
    }

    public void setChild(List<MenuNode> child) {
        this.child = child;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getSpread() {
        return spread;
    }

    public void setSpread(Integer spread) {
        this.spread = spread;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
