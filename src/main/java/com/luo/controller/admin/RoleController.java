package com.luo.controller.admin;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luo.entity.Menu;
import com.luo.entity.Role;
import com.luo.service.EmployeeService;
import com.luo.service.MenuService;
import com.luo.service.RoleService;
import com.luo.utils.DataGridViewResult;
import com.luo.utils.SystemConstant;
import com.luo.utils.TreeNode;
import com.luo.vo.RoleVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @Resource
    private EmployeeService employeeService;

    @Resource
    private MenuService menuService;

    //通过分页查询角色所有的信息
    @RequestMapping("/list")
    public DataGridViewResult list(RoleVo roleVo) {

        //先知道是如何分页的
        PageHelper.startPage(roleVo.getPage(), roleVo.getLimit());
        //拿到数据
        List<Role> roleList = roleService.findRoleList(roleVo);
        //创建分页Role对象
        PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
    }

    //添加角色
    @RequestMapping("/addRole")
    public String addRole(Role role) {
        Map<String, Object> map = new HashMap<String, Object>();
        int addRole = roleService.addRole(role);
        if (addRole > 0) {
            //添加成功
            map.put(SystemConstant.SUCCESS, true);
            map.put(SystemConstant.MESSAGE, "添加成功");
        } else {
            //添加失败
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE, "添加失败");
        }
        return JSON.toJSONString(map);
    }

    //修改角色
    @RequestMapping("/updateRole")
    public String updateRole(Role role) {
        Map<String, Object> map = new HashMap<String, Object>();
        int updateRole = roleService.updateRole(role);
        if (updateRole > 0) {
            //修改成功
            map.put(SystemConstant.SUCCESS, true);
            map.put(SystemConstant.MESSAGE, "修改成功");
        } else {
            //修改失败
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE, "修改失败");
        }
        return JSON.toJSONString(map);
    }

    //通过角色id查询角色是否有员工
    @RequestMapping("/checkRoleHasEmployee")
    public String checkRoleHasEmployee(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        int enployeeCountByRoleId = employeeService.getEnployeeCountByRoleId(id);
        if (enployeeCountByRoleId > 0) {
            map.put(SystemConstant.EXIST, true);//存在
            map.put(SystemConstant.MESSAGE, "角色里有员工，亲，不能删除哦！！！");
        } else {
            map.put(SystemConstant.EXIST, false);//不存在
        }
        return JSON.toJSONString(map);
    }

    //通过角色编号（id）删除角色
    @RequestMapping("/deleteById")
    public String deleteById(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        int deleteById = roleService.deleteById(id);
        if (deleteById > 0) {
            map.put(SystemConstant.SUCCESS, true);
            map.put(SystemConstant.MESSAGE, "删除成功");
        } else {
            map.put(SystemConstant.EXIST, false);
            map.put(SystemConstant.MESSAGE, "删除失败");
        }
        return JSON.toJSONString(map);
    }

    //根据角色id查询菜单信息
    @RequestMapping("/initMenuTree")
    public DataGridViewResult initMenuTree(Integer roleId) {
        /**
         * 1.你先知道全部菜单
         * 2.知道当前角色拥有的菜单信息
         * 3.遍历两个菜单，找到相等的菜单（id相等，选中1 不选中0）
         */
        //全部菜单
        List<Menu> menuList = menuService.findMenuList();
        //根据角色id查询菜单id
        List<Integer> currentRoleMenuIds = menuService.findMenuIdListByRoleId(roleId);
        //定义保存当前菜单的list集合
        List<Menu> currentMenus = new ArrayList<Menu>();
        //判断查到的id是否有值，有就根据菜单id(List)查出对应的菜单
        if (currentRoleMenuIds != null && currentRoleMenuIds.size() > 0) {
            //根据菜单id查出对应的菜单
            currentMenus = menuService.findMenuByMenuId(currentRoleMenuIds);
        }
        //创建集合保存树节点信息
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        //遍历所有的菜单
        for (Menu menu : menuList) {
            //定义遍历checkArr,知道是否被选中
            String checkArr = "0";
            for (Menu currentMenu : currentMenus) {
                if (menu.getId().equals(currentMenu.getId())) {
                    checkArr = "1";
                    break;
                }
            }
            //是否展开
            Boolean spread = (menu.getSpread() == null || menu.getSpread() == 1) ? true : false;
            treeNodes.add(new TreeNode(menu.getId(), menu.getPid(), menu.getTitle(), spread, checkArr));
        }
        //将数据返回给页面
        return new DataGridViewResult(treeNodes);
    }

    //保存角色菜单关系
    @RequestMapping("/saveRoleMenu")
    public String saveRoleMenu(String ids, Integer roleId) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (roleService.saveRoleMenu(ids, roleId) > 0) {
            map.put(SystemConstant.MESSAGE, "分配成功");
        } else {
            map.put(SystemConstant.MESSAGE, "分配失败");
        }
        return JSON.toJSONString(map);
    }

    //根据员工ID查询该员工拥有的角色列表
    @RequestMapping("/initRoleListByEmpId")
    public DataGridViewResult initRoleListByEmpId(int id) {
        //所有的角色
        List<Map<String, Object>> roleList = roleService.findRoleListByMap();
        //员工拥有的角色
        List<Integer> roleIds = roleService.findEmployeeRoleByEmployeeId(id);
        //循环遍历
        for (Map<String, Object> map : roleList) {
            //判断复选框是否选中
            boolean flag = false;//不选中
            //角色id
            Integer rid = (Integer) map.get("id");
            //比较
            for (Integer roleId : roleIds) {
                if (rid.equals(roleId)) {
                    flag = true;//选中该角色
                    break;
                }
            }
            //将比较完后的状态保存到map中
            map.put("LAY_CHECKED", flag);
        }
        return new DataGridViewResult(Long.valueOf(roleList.size()), roleList);
    }
}
