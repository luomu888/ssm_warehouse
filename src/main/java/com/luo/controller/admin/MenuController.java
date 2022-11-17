package com.luo.controller.admin;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luo.entity.Dept;
import com.luo.entity.Employee;
import com.luo.entity.Menu;
import com.luo.entity.Role;
import com.luo.service.MenuService;
import com.luo.utils.*;
import com.luo.vo.EmployeeVo;
import com.luo.vo.MenuVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/admin/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    //加载后台管理页面
    @RequestMapping("/loadMenuList")
    public String loadMenuList(HttpSession session) {
        //将所有的菜单信息放到这个map
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        //homeInfo信息放到这
        Map<String, Object> homeInfo = new LinkedHashMap<String, Object>();
        //logoInfo信息放到这
        Map<String, Object> logoInfo = new LinkedHashMap<String, Object>();

        //拿到数据(根据当前登录员工的角色查询菜单列表)
        Employee employee = (Employee) session.getAttribute(SystemConstant.LOGINUSER);
        List<Menu> menuList = menuService.findMenuListByEmployeeId(employee.getId());
        //创建集合，保存菜单关系
        List<MenuNode> menuInfo = new ArrayList<MenuNode>();
        //遍历数据放到MenuNode
        for (Menu m : menuList) {
            //创建菜单节点
            MenuNode menuNode = new MenuNode();
            menuNode.setId(m.getId());
            menuNode.setPid(m.getPid());
            menuNode.setTitle(m.getTitle());
            menuNode.setHref(m.getHref());
            menuNode.setSpread(m.getSpread());
            menuNode.setTarget(m.getTarget());
            menuNode.setIcon(m.getIcon());

            menuInfo.add(menuNode);
        }

        //放数据
        homeInfo.put("title", "首页");
        homeInfo.put("href", "/admin/desktop.html");

        logoInfo.put("title", "管理平台");
        logoInfo.put("image", "/statics/layui/images/logo.png");
        logoInfo.put("href", "/admin/home.html");

        map.put("homeInfo", homeInfo);
        map.put("logoInfo", logoInfo);
        map.put("menuInfo", TreeUtil.toTree(menuInfo, 0));

        System.err.println(JSON.toJSONString(map));

        return JSON.toJSONString(map);
    }

    //加载菜单管理页面的左侧导航树
    @RequestMapping("/loadMenuTree")
    public DataGridViewResult loadMenuTree() {
        //查询所有菜单
        List<Menu> menuList = menuService.findMenuList();
        //创建TreeNode保存信息
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        for (Menu menu : menuList) {
            //判断是否展开  0不展开  1展开
            boolean spread = (menu.getSpread() == null || menu.getSpread() == 1) ? true : false;
            treeNodes.add(new TreeNode(menu.getId(), menu.getPid(), menu.getTitle(),spread));
        }
        return new DataGridViewResult(treeNodes);
    }

    //分页查询菜单列表
    @RequestMapping("/list")
    public DataGridViewResult list(MenuVo menuVo) {
        //先知道怎么分页
        PageHelper.startPage(menuVo.getPage(), menuVo.getLimit());
        //拿到数据
        List<Menu> menuList = menuService.findMenuListByPage(menuVo);
        //创建分页对象
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(menuList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
    }

    //添加菜单
    @RequestMapping("/addMenu")
    public String addMenu(Menu menu){
        Map<String,Object> map=new HashMap<String, Object>();
        int addMenu = menuService.addMenu(menu);
        if (addMenu>0){
            //添加成功
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"添加成功");
        }else {
            //添加失败
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"添加失败");
        }
        return JSON.toJSONString(map);
    }

    //修改菜单
    @RequestMapping("/updateMenu")
    public String updateMenu(Menu menu){
        Map<String,Object> map=new HashMap<String, Object>();
        int updateMenu = menuService.updateMenu(menu);
        if (updateMenu>0){
            //修改成功
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"修改成功");
        }else {
            //修改失败
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"修改失败");
        }
        return JSON.toJSONString(map);
    }

    //根据菜单ID查询该菜单是否有子菜单
    @RequestMapping("/checkMenuHasChild")
    public String checkMenuHasChild(Integer id){
        Map<String,Object> map = new HashMap<String,Object>();
        //调用查询菜单的方法
        if(menuService.getMenuCountByMenuId(id)>0){
            map.put(SystemConstant.EXIST,true);
            map.put(SystemConstant.MESSAGE,"该菜单下有子菜单，无法删除");
        }else{
            map.put(SystemConstant.EXIST,false);
        }
        return JSON.toJSONString(map);
    }

    //根据菜单ID删除菜单
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        Map<String,Object> map=new HashMap<String, Object>();
        int deleteById = menuService.deleteById(id);
        if (deleteById>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"删除成功");
        }else {
            map.put(SystemConstant.EXIST,false);
            map.put(SystemConstant.MESSAGE,"删除失败");
        }
        return JSON.toJSONString(map);
    }
}
