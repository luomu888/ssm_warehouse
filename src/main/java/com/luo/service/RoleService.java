package com.luo.service;

import com.luo.entity.Role;
import com.luo.vo.RoleVo;

import java.util.List;
import java.util.Map;

public interface RoleService {

    /**
     * 通过分页查询角色所有的信息
     * @param roleVo
     * @return
     */
    List<Role> findRoleList(RoleVo roleVo);

    /**
     * 添加角色
     * @param role
     * @return
     */
    int addRole(Role role);

    /**
     * 修改角色
     * @param role
     * @return
     */
    int updateRole(Role role);

    /**
     * 通过角色编号（id）删除角色
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 保存角色菜单关系
     * @param ids
     * @param roleId
     * @return
     */
    Integer saveRoleMenu(String ids, Integer roleId);

    /**
     * 查询所有角色列表
     * @return
     */
    List<Map<String,Object>> findRoleListByMap();

    /**
     * 根据员工ID查询该员工拥有的角色列表
     * @param eid
     * @return
     */
    List<Integer> findEmployeeRoleByEmployeeId(Integer eid);
}
