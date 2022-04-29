package com.luo.controller.admin;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luo.entity.Dept;
import com.luo.entity.Good;
import com.luo.service.GoodService;
import com.luo.utils.DataGridViewResult;
import com.luo.utils.SystemConstant;
import com.luo.vo.GoodBarVO;
import com.luo.vo.GoodVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/good")
public class GoodController {

    @Resource
    private GoodService goodService;

    // 返回库存bar图数据
    @RequestMapping("/getGoodBarVO")
    public GoodBarVO getGoodBarVO() {
        return goodService.getGoodBarVO();
    }

    //通过分页查询库存所有的信息
    @RequestMapping("/list")
    public DataGridViewResult list(GoodVo goodVo){
        //先知道怎么分页
        PageHelper.startPage(goodVo.getPage(),goodVo.getLimit());
        //拿到数据
        List<Good> goodList = goodService.findGoodListByPage(goodVo);
        //创建分页对象
        PageInfo<Good> pageInfo=new PageInfo<Good>(goodList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());
    }

    //添加商品
    @RequestMapping("/addGood")
    public String addGood(Good good){
        Map<String,Object> map=new HashMap<String, Object>();
        int addGood = goodService.addGood(good);
        if (addGood>0){
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

    //修改商品
    @RequestMapping("/updateGood")
    public String updateGood(Good good){
        Map<String,Object> map=new HashMap<String, Object>();
        int updateGood = goodService.updateGood(good);
        if (updateGood>0){
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
     * 通过商品编号（id）删除商品
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        Map<String,Object> map=new HashMap<String, Object>();
        int deleteById = goodService.deleteById(id);
        if (deleteById>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"删除成功");
        }else {
            map.put(SystemConstant.EXIST,false);
            map.put(SystemConstant.MESSAGE,"删除失败");
        }
        return JSON.toJSONString(map);
    }
    //查询所有商品
    @RequestMapping("/findAll")
    public String findAll(){
        return JSON.toJSONString(goodService.findGoodListByPage(null));
    }

}
