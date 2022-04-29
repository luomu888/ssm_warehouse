package com.luo.dao;

import com.luo.entity.Menu;
import com.luo.entity.Role;
import com.luo.vo.MenuVo;

import java.util.List;

public interface MenuMapper {

    //查询所有的菜单信息
    List<Menu> findMenuList();

    //根据角色id查询菜单id
    List<Integer> findMenuIdListByRoleId(Integer roleId);

    //根据菜单id(List)查出对应的菜单
    List<Menu> findMenuByMenuId(List<Integer> currentRoleMenuIds);

    //查询菜单列表
    List<Menu> findMenuListByPage(MenuVo menuVo);

    //添加菜单
    int addMenu(Menu menu);

    //修改菜单
    int updateMenu(Menu menu);

    //根据菜单ID查询该菜单是否有子菜单
    int getMenuCountByMenuId(Integer id);

    //根据菜单ID删除菜单
    int deleteById(Integer id);

    //根据当前登录员工的角色查询菜单列表
    List<Menu> findMenuListByEmployeeId(Integer employeeid);
}
