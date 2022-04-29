package com.luo.dao;

import com.luo.entity.Role;
import com.luo.vo.RoleVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleMapper {

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
     * 删除原有的关系
     * @param roleId
     */
    @Delete("delete from sys_role_menu where rid=#{roleId}")
    void deleteRoleMenu(Integer roleId);

    /**
     *添加角色菜单关系数据
     * @param menuId
     * @param roleId
     */
    @Insert("insert into sys_role_menu(mid,rid) values(#{menuId},#{roleId})")
    void addRoleMenu(@Param("menuId") String menuId, @Param("roleId") Integer roleId);

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
