package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.OverflowList;
import com.atguigu.jxc.entity.OverflowListGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OverflowListGoodsDao {
    void saveOverflowList(@Param("overflowNumber") String overflowNumber,@Param("overflowList") OverflowList overflowList);

    void saveOverflowListGoods(@Param("overflowListId") Integer overflowListId,@Param("overflowListGoods") List<OverflowListGoods> overflowListGoods);

    List<OverflowList> queryListByTime(@Param("sTime") String sTime,@Param("eTime") String eTime);

    List<OverflowListGoods> queryGoodsList(Integer overflowListId);
}
