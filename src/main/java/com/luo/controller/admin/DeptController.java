package com.luo.controller.admin;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luo.entity.Dept;
import com.luo.service.DeptService;
import com.luo.service.EmployeeService;
import com.luo.utils.DataGridViewResult;
import com.luo.utils.SystemConstant;
import com.luo.vo.DeptPieVO;
import com.luo.vo.DeptVo;
import com.luo.vo.GoodBarVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    @Resource
    private EmployeeService employeeService;

    //通过分页查询部门所有信息
    @RequestMapping("/list")
    public DataGridViewResult list(DeptVo deptVo){
        //先知道怎么分页
        PageHelper.startPage(deptVo.getPage(),deptVo.getLimit());
        //拿到数据
        List<Dept> deptList = deptService.findDeptListByPage(deptVo);
        //创建分页对象
        PageInfo<Dept> pageInfo=new PageInfo<Dept>(deptList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());
    }

    //添加部门
    @RequestMapping("/addDept")
    public String addDept(Dept dept){
        Map<String,Object> map=new HashMap<String, Object>();
        int addDept = deptService.addDept(dept);
        if (addDept>0){
            //添加成功
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"添加成功");
        }else {
            //添加失败
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"添加失败");
        }
        return JSON.toJSONString(map);
    }

    //修改部门
    @RequestMapping("/updateDept")
    public String updateDept(Dept dept){
        Map<String,Object> map=new HashMap<String, Object>();
        int updateDept = deptService.updateDept(dept);
        if (updateDept>0){
            //修改成功
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"修改成功");
        }else {
            //修改失败
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"修改失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 通过部门id查看部门下是否有员工
     * @param id
     * @return
     */
    @RequestMapping("/checkDeptHasEmployee")
    public String checkDeptHasEmployee(Integer id){
        Map<String,Object> map=new HashMap<String, Object>();
        int getEmployeeCountByDeptId = employeeService.getEmployeeCountByDeptId(id);
        if (getEmployeeCountByDeptId>0){
            map.put(SystemConstant.EXIST,true);//存在
            map.put(SystemConstant.MESSAGE,"部门里有员工，亲，不能删除哦！！！");
        }else {
            map.put(SystemConstant.EXIST,false);//不存在
        }
        return JSON.toJSONString(map);
    }

    /**
     * 通过部门编号（id）删除部门
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        Map<String,Object> map=new HashMap<String, Object>();
        int deleteById = deptService.deleteById(id);
        if (deleteById>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"删除成功");
        }else {
            map.put(SystemConstant.EXIST,false);
            map.put(SystemConstant.MESSAGE,"删除失败");
        }
        return JSON.toJSONString(map);
    }

    //查询所有部门
    @RequestMapping("/deptList")
    public String deptList(){
        return JSON.toJSONString(deptService.findDeptList());
    }

    // 返回部门pie图数据
    @RequestMapping("/getDeptPie")
    public List<DeptPieVO> getDeptPie() {
        return deptService.getDeptPie();
    }
}
