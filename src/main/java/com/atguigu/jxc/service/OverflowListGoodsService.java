package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.OverflowList;
import com.atguigu.jxc.entity.OverflowListGoods;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface OverflowListGoodsService {
    void save(HttpSession session, String overflowNumber, OverflowList overflowList, List<OverflowListGoods> overflowListGoods);

    Map<String, Object> queryListByTime(String sTime, String eTime);

    Map<String, Object> queryGoodsList(Integer overflowListId);
}
