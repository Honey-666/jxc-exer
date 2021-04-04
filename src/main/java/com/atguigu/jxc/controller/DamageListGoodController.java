package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.DamageList;
import com.atguigu.jxc.entity.DamageListGoods;
import com.atguigu.jxc.service.DamageListGoodService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RequestMapping("damageListGoods")
@RestController
public class DamageListGoodController {

    @Autowired
    private DamageListGoodService damageListGoodService;

    /**
     * 保存报损单
     * @param damageNumber
     * @param session
     * @param damageList
     * @param damageListGoodsStr 报销的商品集合
     * @return
     */
    @PostMapping("save")
    public ServiceVO save(String damageNumber,HttpSession session,DamageList damageList, String damageListGoodsStr){
        Gson gson = new Gson();
        //将报销商品转换为集合
        List<DamageListGoods> damageListGoods = gson.fromJson(damageListGoodsStr, List.class);
        //保存分两步，在service层完成
        damageListGoodService.save(damageNumber,session,damageList,damageListGoods);
        return new ServiceVO(SuccessCode.SUCCESS_CODE,"请求成功",null);
    }

    /**
     * 报损单查询
     * @param sTime 开始时间
     * @param eTime 结束时间
     * @return
     */
    @PostMapping("list")
    public Map<String,Object> queryList(String  sTime,String  eTime){

        return damageListGoodService.queryListByTIme(sTime,eTime);
    }

    /**
     * 查询报损单商品信息
     * @param damageListId
     * @return
     */
    @PostMapping("goodsList")
    public Map<String,Object> queryGoodsList(Integer damageListId){
        return damageListGoodService.queryGoodsList(damageListId);
    }

}
