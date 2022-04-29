package com.luo.service.impl;

import com.luo.dao.DeptMapper;
import com.luo.entity.Dept;
import com.luo.service.DeptService;
import com.luo.vo.DeptPieVO;
import com.luo.vo.DeptVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    //通过分页查询部门所有信息
    public List<Dept> findDeptListByPage(DeptVo deptVo) {
        return deptMapper.findDeptListByPage(deptVo);
    }

    //添加部门
    public int addDept(Dept dept) {
        dept.setCreateDate(new Date());
        return deptMapper.addDept(dept);
    }

    //修改部门
    public int updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }

    //通过部门编号（id）删除部门
    public int deleteById(Integer id) {
        return deptMapper.deleteById(id);
    }

    //查询所有部门
    public List<Dept> findDeptList() {
        return deptMapper.findDeptList();
    }

    @Override
    public List<DeptPieVO> getDeptPie() {
        return deptMapper.getDeptPie();
    }

}
