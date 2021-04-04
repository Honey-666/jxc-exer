package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.entity.GoodsType;
import com.atguigu.jxc.entity.vo.GoodsTypeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description 商品类别
 */
public interface GoodsTypeDao {



    Integer updateGoodsTypeState(GoodsType parentGoodsType);

    List<GoodsType> queryGoods(Integer goodsTypeState);


    List<GoodsTypeVo> queryGoodsTypes();

    void save(@Param("goodsTypeName") String goodsTypeName,@Param("pId") Integer pId);

    void deleteGoodsType(Integer goodsTypeId);
}
