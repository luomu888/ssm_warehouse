package com.luo.controller.admin;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luo.entity.Floor;
import com.luo.service.FloorService;
import com.luo.utils.DataGridViewResult;
import com.luo.utils.SystemConstant;
import com.luo.vo.FloorVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/floor")
public class FloorController {

    @Resource
    private FloorService floorService;

    @RequestMapping("/list")
    public DataGridViewResult list(FloorVo floorVo){
        /**
         * 1.知道怎么分页
         * 2、拿到数据
         * 3、创建分页对象（给谁分页）
         * 4、返回结果
         */
        //知道怎么分页
        PageHelper.startPage(floorVo.getPage(),floorVo.getLimit());
        //拿到数据
        List<Floor> floorList = floorService.findFloorList(floorVo);
        //创建分页对象（给谁分页）
        PageInfo<Floor> pageInfo=new PageInfo<Floor>(floorList);
        //返回结果
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());
    }

    //添加楼层
    @RequestMapping("/addFloor")
    public String addFloor(Floor floor){
        Map<String,Object> map=new HashMap<String, Object>();
        if (floorService.addFloor(floor)>0){
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

    //修改楼层
    @RequestMapping("/updateFloor")
    public String updateFloor(Floor floor){
        Map<String,Object> map=new HashMap<String, Object>();
        if (floorService.updateFloor(floor)>0){
            //添加成功
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"修改成功");
        }else {
            //添加失败
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"修改失败");
        }
        return JSON.toJSONString(map);
    }

    //查询所有楼层
    @RequestMapping("/findAll")
    public String findAll(){
        return JSON.toJSONString(floorService.findFloorList(null));
    }

}
