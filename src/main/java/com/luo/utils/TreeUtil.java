package com.luo.utils;

import java.util.ArrayList;
import java.util.List;

public class TreeUtil {

    /**
     * 构建菜单层级关系
     * @param treeList      菜单列表
     * @param pid           父级菜单编号，0表示父级菜单 (一级菜单)
     * @return
     */
    public static List<MenuNode> toTree(List<MenuNode> treeList, Integer pid) {
        List<MenuNode> retList = new ArrayList<MenuNode>();
        for (MenuNode parent : treeList) {
            //如果当前父级菜单编号与循环的菜单列表中的父级菜单编号一致
            if (pid .equals(parent.getPid()) ) {
                retList.add(findChildren(parent, treeList));
            }
        }
        return retList;
    }


    private static MenuNode findChildren(MenuNode parent, List<MenuNode> treeList) {
        for (MenuNode child : treeList) {
            if (parent.getId() .equals(child.getPid())) {
                // 创建集合
                if (parent.getChild() == null) {
                    parent.setChild(new ArrayList<MenuNode>());
                }
                // 添加到集合
                parent.getChild().add(findChildren(child, treeList));
            }
        }
        return parent;
    }
}
