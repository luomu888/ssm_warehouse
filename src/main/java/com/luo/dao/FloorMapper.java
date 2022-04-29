package com.luo.dao;

import com.luo.entity.Floor;
import com.luo.vo.FloorVo;

import java.util.List;

public interface FloorMapper {

    //查询楼层列表
    List<Floor> findFloorList(FloorVo floorVo);

    //添加楼层
    int addFloor(Floor floor);

    //修改楼层
    int updateFloor(Floor floor);
}
