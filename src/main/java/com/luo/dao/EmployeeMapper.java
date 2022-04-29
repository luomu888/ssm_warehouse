package com.luo.dao;

import com.luo.entity.Employee;
import com.luo.vo.EmployeeVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 通过登录账号来查员工的信息
     * @param loginName
     * @return
     */
    Employee findEmployeeByLoginName(String loginName);

    /**
     * 通过部门id查询部门是否有员工
     * @param deptId
     * @return
     */
    int getEmployeeCountByDeptId(Integer deptId);

    /**
     * 通过角色id查询角色是否有员工
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
     * 删除员工角色关系数据
     * @param id
     */
    void deleteEmployeeAndRole(Integer id);

    @Insert("insert into sys_role_employee(rid,eid) values(#{rid},#{eid})")
    void addEmployeeRole(@Param("rid") String roleId,@Param("eid") Integer empId);
}
