package com.luo.service.impl;

import com.luo.dao.EmployeeMapper;
import com.luo.entity.Employee;
import com.luo.service.EmployeeService;
import com.luo.utils.PasswordUtil;
import com.luo.utils.SystemConstant;
import com.luo.utils.UUIDUtils;
import com.luo.vo.EmployeeVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 员工登录
     *
     * @param loginName
     * @param loginPwd
     * @return
     */
    @Override
    public Employee login(String loginName, String loginPwd) {
        //根据登录账号获取员工信息
        Employee employee = employeeMapper.findEmployeeByLoginName(loginName);
        //员工信息不为空
        if (employee != null) {
            //将密码进行加密
            String newPassword = PasswordUtil.md5(loginPwd, employee.getSalt(), SystemConstant.PASSWORD_COUNT);
            if (newPassword.equals(employee.getLoginPwd())) {
                //登录成功
                return employee;
            }
        }
        //登录失败
        return null;
    }

    //通过部门id查询部门是否有员工
    @Override
    public int getEmployeeCountByDeptId(Integer deptId) {
        return employeeMapper.getEmployeeCountByDeptId(deptId);
    }

    //通过角色id查询角色是否有员工
    @Override
    public int getEnployeeCountByRoleId(Integer roleId) {
        return employeeMapper.getEnployeeCountByRoleId(roleId);
    }

    //通过分页查询员工所有的信息
    @Override
    public List<Employee> findEmployeeList(EmployeeVo employeeVo) {
        return employeeMapper.findEmployeeList(employeeVo);
    }

    //添加员工
    @Override
    public int addEmployee(Employee employee) {

        /**
         * 获得加密的盐值
         * 创建时间
         */
        employee.setSalt(UUIDUtils.randomUUID());
        employee.setCreateDate(new Date());
        employee.setLoginPwd(PasswordUtil.md5(SystemConstant.DEFAULT_LOGIN_PWD
                , employee.getSalt(), SystemConstant.PASSWORD_COUNT));
        return employeeMapper.addEmployee(employee);
    }

    //修改员工
    @Override
    public int updateEmployee(Employee employee) {
        employee.setModifyDate(new Date());
        return employeeMapper.updateEmployee(employee);
    }

    //删除员工
    @Override
    public int deleteById(Integer id) {
        //先删除员工和角色有关联的数据
        employeeMapper.deleteEmployeeAndRole(id);
        return employeeMapper.deleteById(id);
    }

    //重置密码
    @Override
    public int resetPwd(Integer id) {
        Employee employee = new Employee();
        employee.setSalt(UUIDUtils.randomUUID());
        employee.setLoginPwd(PasswordUtil.md5(SystemConstant.DEFAULT_LOGIN_PWD, employee.getSalt(), SystemConstant.PASSWORD_COUNT));
        employee.setId(id);
        return updateEmployee(employee);
    }

    //保存员工角色关系
    @Override
    public int saveEmployeeRole(String roleIds, Integer empId) {
        /**
         * 先删除原来的
         * 在遍历保存
         */
        try {
            employeeMapper.deleteEmployeeAndRole(empId);
            String[] idStr = roleIds.split(",");
            for (int i = 0; i < idStr.length; i++) {
                employeeMapper.addEmployeeRole(idStr[i], empId);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
