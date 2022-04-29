package com.luo.service.impl;

import com.luo.dao.RoomMapper;
import com.luo.entity.Room;
import com.luo.service.RoomService;
import com.luo.vo.RoomVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Resource
    private RoomMapper roomMapper;

    //通过分页查询库房所有的信息
    public List<Room> findRoomListByPage(RoomVo roomVo) {
        return roomMapper.findRoomListByPage(roomVo);
    }

    //添加库房
    public int addRoom(Room room) {
        //如果选择无商品，那么goodId为0
        if (room.getGoodId()==null){
            room.setGoodId(0);
        }
        return roomMapper.addRoom(room);
    }

    //修改库房
    public int updateRoom(Room room) {
        return roomMapper.updateRoom(room);
    }
}
