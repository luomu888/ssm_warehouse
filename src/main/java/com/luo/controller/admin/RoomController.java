package com.luo.controller.admin;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luo.entity.Room;
import com.luo.service.RoomService;
import com.luo.utils.DataGridViewResult;
import com.luo.utils.SystemConstant;
import com.luo.vo.RoomVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/room")
public class RoomController {

    @Resource
    private RoomService roomService;

    //查询库房列表
    @RequestMapping("/list")
    public DataGridViewResult list(RoomVo roomVo){
        //先知道是如何分页的
        PageHelper.startPage(roomVo.getPage(),roomVo.getLimit());
        //拿到数据
        List<Room> roomList = roomService.findRoomListByPage(roomVo);
        //创建分页Role对象
        PageInfo<Room> pageInfo=new PageInfo<Room>(roomList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());
    }

    //添加库房
    @RequestMapping("/addRoom")
    public String addRoom(Room room){
        Map<String,Object> map = new HashMap<String,Object>();
        if(roomService.addRoom(room)>0){
            map.put(SystemConstant.SUCCESS,true);//成功
            map.put(SystemConstant.MESSAGE,"添加成功");
        }else{
            map.put(SystemConstant.SUCCESS,false);//失败
            map.put(SystemConstant.MESSAGE,"添加失败");
        }
        return JSON.toJSONString(map);
    }

    //修改库房
    @RequestMapping("/updateRoom")
    public String updateRoom(Room room){
        Map<String,Object> map = new HashMap<String,Object>();
        if(roomService.updateRoom(room)>0){
            map.put(SystemConstant.SUCCESS,true);//成功
            map.put(SystemConstant.MESSAGE,"修改成功");
        }else{
            map.put(SystemConstant.SUCCESS,false);//失败
            map.put(SystemConstant.MESSAGE,"修改失败");
        }
        return JSON.toJSONString(map);
    }

}
