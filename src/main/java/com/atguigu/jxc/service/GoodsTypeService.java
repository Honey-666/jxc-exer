package com.atguigu.jxc.service;

public interface GoodsTypeService {
    String queryGoodsTypes();

    void saveGoodType(String goodsTypeName, Integer pId);

    void deleteGoodsType(Integer goodsTypeId);
}
