package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.OverflowList;
import com.atguigu.jxc.entity.OverflowListGoods;
import com.atguigu.jxc.service.OverflowListGoodsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("overflowListGoods")
public class OverflowListGoodsController {
    @Autowired
    private OverflowListGoodsService overflowListGoodsService;

    /**
     * 新增报溢单
     * @param overflowNumber
     * @param overflowList
     * @param overflowListGoodsStr
     * @return
     */
    @PostMapping("/save")
    public ServiceVO save(HttpSession session,String overflowNumber, OverflowList overflowList, String overflowListGoodsStr){

        Gson gson = new Gson();
        //反序列化成在service层进行批量保存
        List<OverflowListGoods> overflowListGoods = gson.fromJson(overflowListGoodsStr, List.class);

        overflowListGoodsService.save(session,overflowNumber,overflowList,overflowListGoods);
        return new ServiceVO(SuccessCode.SUCCESS_CODE,"请求成功",null);
    }

    /**
     * 报溢单查询
     * @param sTime 开始时间
     * @param eTime 结束时间
     * @return
     */
    @PostMapping("list")
    public Map<String,Object> queryListByTime(String  sTime, String  eTime){

        return overflowListGoodsService.queryListByTime(sTime,eTime);
    }

    /**
     * 报溢单商品信息
     * @param overflowListId
     * @return
     */
    @PostMapping("/goodsList")
    public Map<String,Object> queryGoodsList(Integer overflowListId){

        return overflowListGoodsService.queryGoodsList(overflowListId);
    }
}
