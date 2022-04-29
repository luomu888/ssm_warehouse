package com.luo.dao;

import com.luo.entity.Good;
import com.luo.vo.GoodVo;

import java.util.List;

public interface GoodMapper {
    /**
     * 查询所有库存
     * @return
     */
    List<Good> findAllGood();
    /**
     * 通过分页查询库存所有的信息
     * @param goodVo
     * @return
     */
    List<Good> findGoodListByPage(GoodVo goodVo);

    /**
     * 添加商品
     * @return
     */
    int addGood(Good good);

    /**
     * 修改商品
     * @return
     */
    int updateGood(Good good);

    /**
     * 删除商品
     * @param id
     * @return
     */
    int deleteById(Integer id);


}
