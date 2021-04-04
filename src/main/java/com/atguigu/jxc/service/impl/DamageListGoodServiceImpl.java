package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.DamageListGoodDao;
import com.atguigu.jxc.entity.DamageList;
import com.atguigu.jxc.entity.DamageListGoods;
import com.atguigu.jxc.entity.User;
import com.atguigu.jxc.service.DamageListGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DamageListGoodServiceImpl implements DamageListGoodService {

    @Autowired
    private DamageListGoodDao damageListGoodDao;

    /**
     * 查询报损单商品信息
     * @param damageListId
     * @return
     */
    @Override
    public Map<String, Object> queryGoodsList(Integer damageListId) {
        Map<String, Object> map = new HashMap<>();
       List<DamageListGoods> damageListGoodsList =  damageListGoodDao.queryGoodsList(damageListId);
        map.put("rows",damageListGoodsList);
        return map;
    }

    /**
     * 报损单查询
     * @param sTime
     * @param eTime
     * @return
     */
    @Override
    public Map<String, Object> queryListByTIme(String sTime, String eTime) {
        Map<String, Object> map = new HashMap<>();
        List<DamageList> damageListList = damageListGoodDao.queryListByTIme(sTime,eTime);
        map.put("rows",damageListList);
        return map;
    }

    /**
     * @param damageNumber
     * @param session
     * @param damageList
     * @param damageListGoods
     */
    @Override
    public void save(String damageNumber, HttpSession session, DamageList damageList, List<DamageListGoods> damageListGoods) {
        //从缓存中获取用户信息
        User user = (User) session.getAttribute("currentUser");
        Integer userId = user.getUserId();
        damageList.setUserId(userId);
        //先保存保险单，返回主键
        damageListGoodDao.saveDamageList(damageNumber, damageList);
        //批量插入报销商品集合
        damageListGoodDao.saveDamageListGoods(damageList.getDamageListId(), damageListGoods);
    }
}
