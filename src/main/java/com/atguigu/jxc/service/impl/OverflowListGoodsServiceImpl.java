package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.OverflowListGoodsDao;
import com.atguigu.jxc.entity.OverflowList;
import com.atguigu.jxc.entity.OverflowListGoods;
import com.atguigu.jxc.entity.User;
import com.atguigu.jxc.service.OverflowListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OverflowListGoodsServiceImpl implements OverflowListGoodsService {
    @Autowired
    private OverflowListGoodsDao overflowListGoodsDao;

    /**
     * 报溢单商品信息
     * @param overflowListId
     * @return
     */
    @Override
    public Map<String, Object> queryGoodsList(Integer overflowListId) {
        Map<String, Object> map = new HashMap<>();

        List<OverflowListGoods> overflowListGoods = overflowListGoodsDao.queryGoodsList(overflowListId);

        map.put("rows",overflowListGoods);
        return map;
    }

    /**
     * 报溢单查询
     * @param sTime
     * @param eTime
     * @return
     */
    @Override
    public Map<String, Object> queryListByTime(String sTime, String eTime) {
        Map<String, Object> map = new HashMap<>();
        List<OverflowList> overflowLists = overflowListGoodsDao.queryListByTime(sTime, eTime);

        map.put("rows", overflowLists);
        return map;
    }

    /**
     * @param session
     * @param overflowNumber
     * @param overflowList
     * @param overflowListGoods
     */
    @Override
    public void save(HttpSession session, String overflowNumber, OverflowList overflowList, List<OverflowListGoods> overflowListGoods) {
        //从缓存中获取用户信息
        User user = (User) session.getAttribute("currentUser");
        Integer userId = user.getUserId();
        overflowList.setUserId(userId);
        //先插入报溢单表，返回主键
        overflowListGoodsDao.saveOverflowList(overflowNumber, overflowList);
        //在批量插入报溢单对应的商品信息

        overflowListGoodsDao.saveOverflowListGoods(overflowList.getOverflowListId(), overflowListGoods);
    }
}
