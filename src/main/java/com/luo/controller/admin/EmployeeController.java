package com.luo.controller.admin;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luo.entity.Employee;
import com.luo.service.EmployeeService;
import com.luo.utils.DataGridViewResult;
import com.luo.utils.SystemConstant;
import com.luo.vo.EmployeeVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    /**
     * 员工登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        Employee employee = employeeService.login(username, password);
        if (employee != null) {
            // 保存用户登录的信息到Session域中
            session.setAttribute(SystemConstant.LOGINUSER, employee);
            map.put(SystemConstant.SUCCESS, true);
        } else {
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE, "登录失败，账号或密码错误！！！");
        }
        return JSON.toJSONString(map);
    }

    //通过分页查询员工所有信息
    @RequestMapping("/list")
    public DataGridViewResult list(EmployeeVo employeeVo) {
        //先知道怎么分页
        PageHelper.startPage(employeeVo.getPage(), employeeVo.getLimit());
        //拿到数据
        List<Employee> employeeList = employeeService.findEmployeeList(employeeVo);
        //创建分页对象
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(employeeList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
    }

    //添加员工
    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        /**
         * 获取登录用户
         * 编写创建人
         */
        Employee loginUser = (Employee) session.getAttribute(SystemConstant.LOGINUSER);
        employee.setCreateBy(loginUser.getId());
        int addEmployee = employeeService.addEmployee(employee);
        if (addEmployee > 0) {
            map.put(SystemConstant.SUCCESS, true);
            map.put(SystemConstant.MESSAGE, "添加成功");
        } else {
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE, "添加失败");
        }

        return JSON.toJSONString(map);
    }

    //修改员工
    @RequestMapping("/updateEmployee")
    public String updateEmployee(Employee employee, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        //获取当前登录用户
        Employee loginUser = (Employee) session.getAttribute(SystemConstant.LOGINUSER);
        //设置修改人
        employee.setModifyBy(loginUser.getId());
        //调用新增员工的方法
        if (employeeService.updateEmployee(employee) > 0) {
            map.put(SystemConstant.SUCCESS, true);
            map.put(SystemConstant.MESSAGE, "修改成功");
        } else {
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE, "修改失败");
        }
        return JSON.toJSONString(map);
    }

    //删除员工
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        Map<String,Object> map=new HashMap<String, Object>();
        int deleteById = employeeService.deleteById(id);
        if (deleteById>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"删除成功");
        }else {
            map.put(SystemConstant.EXIST,false);
            map.put(SystemConstant.MESSAGE,"删除失败");
        }
        return JSON.toJSONString(map);
    }

    //重置密码
    @RequestMapping("/resetPwd")
    public String resetPwd(Integer id){
        Map<String,Object> map=new HashMap<String, Object>();
        int resetPwd = employeeService.resetPwd(id);
        if (resetPwd>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"密码重置成功");
        }else {
            map.put(SystemConstant.EXIST,false);
            map.put(SystemConstant.MESSAGE,"密码重置失败");
        }
        return JSON.toJSONString(map);
    }

    //分配角色
    @RequestMapping("/saveEmployeeRole")
    public String saveEmployeeRole(String roleIds,Integer empId){
        Map<String,Object> map=new HashMap<String, Object>();
        int saveEmployeeRole = employeeService.saveEmployeeRole(roleIds, empId);
        if (saveEmployeeRole>0){
            map.put(SystemConstant.MESSAGE,"角色分配成功");
        }else {
            map.put(SystemConstant.MESSAGE,"角色分配失败");
        }
        return JSON.toJSONString(map);
    }
}
