package com.luo.service.impl;

import com.luo.dao.FloorMapper;
import com.luo.entity.Floor;
import com.luo.service.FloorService;
import com.luo.vo.FloorVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class FloorServiceImpl implements FloorService {

    @Resource
    private FloorMapper floorMapper;

    //查询楼层列表
    public List<Floor> findFloorList(FloorVo floorVo) {
        return floorMapper.findFloorList(floorVo);
    }

    public int addFloor(Floor floor) {
        return floorMapper.addFloor(floor);
    }

    //修改楼层
    public int updateFloor(Floor floor) {
        return floorMapper.updateFloor(floor);
    }
}
