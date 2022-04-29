package com.luo.service.impl;

import com.luo.dao.GoodMapper;
import com.luo.entity.Good;
import com.luo.service.GoodService;
import com.luo.vo.GoodBarVO;
import com.luo.vo.GoodVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GoodServiceImpl implements GoodService {

    @Resource
    private GoodMapper goodMapper;

    //通过分页查询商品所有的信息
    public List<Good> findGoodListByPage(GoodVo goodVo) {
        return goodMapper.findGoodListByPage(goodVo);
    }

    //添加商品
    public int addGood(Good good) {
        return goodMapper.addGood(good);
    }

    //修改商品
    public int updateGood(Good good) {
        return goodMapper.updateGood(good);
    }

    //删除商品
    public int deleteById(Integer id) {
        return goodMapper.deleteById(id);
    }

    @Override
    public GoodBarVO getGoodBarVO() {
        // 数据
        List<Good> allGood = goodMapper.findAllGood();
        // 数据封装到集合
        GoodBarVO goodBarVO = new GoodBarVO();
        List<String> names=new ArrayList<>();
        List<Integer> values=new ArrayList<>();
        for (Good good : allGood) {
            names.add(good.getGoodName());
            values.add(Integer.valueOf(good.getGoodNum()));
        }
        goodBarVO.setNames(names);
        goodBarVO.setValues(values);
        return goodBarVO;
    }
}
