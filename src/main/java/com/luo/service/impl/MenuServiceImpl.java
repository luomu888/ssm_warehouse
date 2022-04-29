package com.luo.service.impl;

import com.luo.dao.MenuMapper;
import com.luo.entity.Menu;
import com.luo.service.MenuService;
import com.luo.vo.MenuVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    //查询所有的菜单信息
    public List<Menu> findMenuList() {
        return menuMapper.findMenuList();
    }

    //根据角色id查询菜单id
    public List<Integer> findMenuIdListByRoleId(Integer roleId) {
        return menuMapper.findMenuIdListByRoleId(roleId);
    }

    //根据菜单id(List)查出对应的菜单
    public List<Menu> findMenuByMenuId(List<Integer> currentRoleMenuIds) {
        return menuMapper.findMenuByMenuId(currentRoleMenuIds);
    }

    public List<Menu> findMenuListByPage(MenuVo menuVo) {
        return menuMapper.findMenuListByPage(menuVo);
    }

    public int addMenu(Menu menu) {
        //如果没有选择父级菜单，默认设置父级菜单为0
        if(menu.getPid()==null){
            menu.setPid(0);
        }
        //如果没有选择图标，默认设置fa fa-star
        if (menu.getIcon()==null||menu.getIcon()==""){
            menu.setIcon("fa fa-star");
        }
        //设置打开方式，没有作用
        menu.setTarget("_self");
        return menuMapper.addMenu(menu);
    }

    //修改菜单
    public int updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    public int getMenuCountByMenuId(Integer id) {
        return menuMapper.getMenuCountByMenuId(id);
    }

    public int deleteById(Integer id) {
        return menuMapper.deleteById(id);
    }

    public List<Menu> findMenuListByEmployeeId(Integer employeeid) {
        return menuMapper.findMenuListByEmployeeId(employeeid);
    }
}
