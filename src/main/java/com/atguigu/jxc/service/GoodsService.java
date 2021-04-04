package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {


    ServiceVO getCode();

    Map<String, Object> queryGoodsPage(Integer page, Integer rows, String codeOrName, Integer goodsTypeId);

    Map<String, Object> queryUnit();

    void saveAndEditGoods(Goods goods, Integer goodsId);

    void deleteGoodsById(Integer goodsId);

    Map<String, Object> getNoInventoryQuantity(Integer page, Integer rows, String nameOrCode);

    Map<String, Object> getHasInventoryQuantity(Integer page, Integer rows, String nameOrCode);

    void saveStockAndEditStock(Integer goodsId, Integer inventoryQuantity, double purchasingPrice);

    Map<String, Object> listAlarm();
}
