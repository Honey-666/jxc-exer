package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.entity.Unit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description 商品信息
 */
public interface GoodsDao {


    String getMaxCode();


    List<Goods> queryGoodsPage(@Param("page") Integer page, @Param("rows")Integer rows, @Param("codeOrName")String codeOrName, @Param("goodsTypeId")Integer goodsTypeId);

    List<Unit> queryUnit();

    void save(Goods goods);

    void edit(Goods goods);

    Goods queryGoodsById(Integer goodsId);

    void deleteGoodsById(Integer goodsId);

    Integer getNoInventoryQuantityCount();

    List<Goods> getNoInventoryQuantity(@Param("page") Integer page, @Param("rows")Integer rows, @Param("nameOrCode")String nameOrCode);

    Integer getHasInventoryQuantityCount();

    List<Goods> getHasInventoryQuantity(@Param("page") Integer page, @Param("rows")Integer rows, @Param("nameOrCode")String nameOrCode);


    void saveStockAndEditStock(@Param("goodsId")Integer goodsId,@Param("inventoryQuantity") Integer inventoryQuantity,@Param("purchasingPrice") double purchasingPrice);


    List<Goods> listAlarm();

    int getCountGoods();
}
