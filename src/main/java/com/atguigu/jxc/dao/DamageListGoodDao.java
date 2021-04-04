package com.atguigu.jxc.dao;


import com.atguigu.jxc.entity.DamageList;
import com.atguigu.jxc.entity.DamageListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DamageListGoodDao {

    void saveDamageList(@Param("damageNumber") String damageNumber,@Param("damageList") DamageList damageList);

    void saveDamageListGoods(@Param("damageListId") Integer damageListId,@Param("damageListGoods") List<DamageListGoods> damageListGoods);

    List<DamageList> queryListByTIme(@Param("sTime") String sTime,@Param("eTime") String eTime);

    List<DamageListGoods> queryGoodsList(Integer damageListId);

}
