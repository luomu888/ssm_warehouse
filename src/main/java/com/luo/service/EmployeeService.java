package com.luo.service;

import com.luo.entity.Dept;
import com.luo.entity.Employee;
import com.luo.vo.DeptVo;
import com.luo.vo.EmployeeVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeService {

    /**
     * 登录
     * @param loginName
     * @param loginPwd
     * @return
     */
    Employee login(String loginName,String loginPwd);

    /**
     * 通过部门id查询部门是否有员工
     * @param deptId
     * @return
     */
    int getEmployeeCountByDeptId(Integer deptId);

    /**
     * 通过角色id查询部门是否有员工
     * @param roleId
     * @return
     */
    int getEnployeeCountByRoleId(Integer roleId);

    /**
     * 通过分页查询员工所有的信息
     * @param employeeVo
     * @return
     */
    List<Employee> findEmployeeList(EmployeeVo employeeVo);

    /**
     * 添加员工
     * @param employee
     * @return
     */
    int addEmployee(Employee employee);

    /**
     * 修改员工
     * @param employee
     * @return
     */
    int updateEmployee(Employee employee);

    /**
     * 删除员工
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 重置密码
     * @param id
     * @return
     */
    int resetPwd(Integer id);

    /**
     * 保存员工角色关系
     * @param roleIds
     * @param empId
     * @return
     */
    int saveEmployeeRole(String roleIds,Integer empId);
}
