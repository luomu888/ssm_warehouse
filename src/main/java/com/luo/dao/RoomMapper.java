package com.luo.dao;

import com.luo.entity.Room;
import com.luo.vo.RoomVo;

import java.util.List;

public interface RoomMapper {

    /**
     * 通过分页查询库房所有的信息
     * @param roomVo
     * @return
     */
    List<Room> findRoomListByPage(RoomVo roomVo);

    /**
     * 添加库房
     * @param room
     * @return
     */
    int addRoom(Room room);

    /**
     * 修改库房
     * @param room
     * @return
     */
    int updateRoom(Room room);

}
