package com.luo.service;

import com.luo.entity.Dept;
import com.luo.vo.DeptPieVO;
import com.luo.vo.DeptVo;

import java.util.List;

public interface DeptService {

    /**
     * 通过分页查询部门所有的信息
     * @param deptVo
     * @return
     */
    List<Dept> findDeptListByPage(DeptVo deptVo);

    /**
     * 添加部门
     * @param dept
     * @return
     */
    int addDept(Dept dept);

    /**
     * 修改部门
     * @param dept
     * @return
     */
    int updateDept(Dept dept);

    /**
     * 通过部门编号（id）删除部门
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 查询所有部门
     * @return
     */
    List<Dept> findDeptList();

    List<DeptPieVO> getDeptPie();
}
