package com.luo.controller.admin;

import com.luo.utils.SystemConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * （实现跳转页面）
 */
@Controller
@RequestMapping("/admin")
public class SystemController {

    /**
     * 跳转到登录
     *
     * @return
     */
    @RequestMapping("/login.html")
    public String login() {
        return "admin/login";
    }

    /**
     * 跳转到初始化页面
     *
     * @return
     */
    @RequestMapping("/desktop.html")
    public String desktop() {
        return "admin/desktop";
    }

    /**
     * 跳转到首页
     */
    @RequestMapping("/home.html")
    public String home() {
        return "admin/home";
    }

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //删除登录的session
        session.removeAttribute(SystemConstant.LOGINUSER);
        session.invalidate();
        //重定向到登录界面
        return "redirect:/admin/login.html";
    }

    /**
     * 跳转到部门管理
     */
    @RequestMapping("/toDeptManager")
    public String toDeptManager(){
        return "admin/dept/deptManager";
    }

    /**
     * 跳转到部门分析
     */
    @RequestMapping("/toDeptPie")
    public String toDeptPie(){
        return "admin/dept/deptPieManager";
    }

    /**
     * 跳转到角色管理
     * @return
     */
    @RequestMapping("/toRoleManager")
    public String toRoleManager(){
        return "admin/role/roleManager";
    }

    /**
     * 跳转到员工管理
     * @return
     */
    @RequestMapping("/toEmployeeManager")
    public String toEmployeeManager(){
        return "admin/employee/employeeManager";
    }

    /**
     * 跳转到菜单管理
     * @return
     */
    @RequestMapping("/toMenuManager")
    public String toMenuManager(){
        return "admin/menu/menuManager";
    }

    @RequestMapping("/toPieManager")
    public String toPieManager(){
        return "admin/pie/pieManager";
    }

    /**
     * 跳转到楼层管理
     * @return
     */
    @RequestMapping("/toFloorManager")
    public String toFloorManager(){
        return "admin/floor/floorManager";
    }

    /**
     * 跳转到库存管理
     * @return
     */
    @RequestMapping("/toGoodManager")
    public String toRoomTypeManager(){
        return "admin/good/goodManager";
    }

    /**
     * 跳转到库房管理
     * @return
     */
    @RequestMapping("/toRoomManager")
    public String toRoomManager(){
        return "admin/room/roomManager";
    }

}
