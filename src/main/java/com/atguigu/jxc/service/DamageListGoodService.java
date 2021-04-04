package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.DamageList;
import com.atguigu.jxc.entity.DamageListGoods;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface DamageListGoodService {
    void save(String damageNumber, HttpSession session, DamageList damageList, List<DamageListGoods> damageListGoods);

    Map<String, Object> queryListByTIme(String sTime, String eTime);

    Map<String, Object> queryGoodsList(Integer damageListId);
}
