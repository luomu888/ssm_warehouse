package com.luo.service.impl;

import com.luo.dao.RoleMapper;
import com.luo.entity.Role;
import com.luo.service.RoleService;
import com.luo.vo.RoleVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    //通过分页查询部门所有的信息
    public List<Role> findRoleList(RoleVo roleVo) {
        return roleMapper.findRoleList(roleVo);
    }

    //添加角色
    public int addRole(Role role) {
        return roleMapper.addRole(role);
    }

    //修改角色
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    //通过角色编号（id）删除角色
    public int deleteById(Integer id) {
        return roleMapper.deleteById(id);
    }

    //保存角色菜单关系
    public Integer saveRoleMenu(String ids, Integer roleId) {
        try {
            //先删除原有的菜单信息
            roleMapper.deleteRoleMenu(roleId);
            //将ids分成数组，循环调用
            String idsStr[]=ids.split(",");
            for (int i = 0; i < idsStr.length; i++) {
                //添加角色菜单关系数据
                roleMapper.addRoleMenu(idsStr[i],roleId);
            }
            return 1;//成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;//失败
    }

    //查询所有角色列表
    public List<Map<String, Object>> findRoleListByMap() {
        return roleMapper.findRoleListByMap();
    }

    public List<Integer> findEmployeeRoleByEmployeeId(Integer eid) {
        return roleMapper.findEmployeeRoleByEmployeeId(eid);
    }
}
