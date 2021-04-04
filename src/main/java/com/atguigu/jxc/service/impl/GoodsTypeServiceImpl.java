package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsTypeDao;
import com.atguigu.jxc.entity.GoodsType;
import com.atguigu.jxc.entity.vo.GoodsTypeVo;
import com.atguigu.jxc.service.GoodsTypeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeDao goodsTypeDao;

    /**
     * 删除分类
     * @param goodsTypeId
     */
    @Override
    public void deleteGoodsType(Integer goodsTypeId) {
        goodsTypeDao.deleteGoodsType(goodsTypeId);
    }

    /**
     * 新增分类
     * @param goodsTypeName
     * @param pId
     */
    @Override
    public void saveGoodType(String goodsTypeName, Integer pId) {
        goodsTypeDao.save(goodsTypeName,pId);
    }

    /**
     * 查询商品所有分类
     *
     * @return
     */
    @Override
    public String queryGoodsTypes() {

        List<GoodsTypeVo> goodsTypeList = goodsTypeDao.queryGoodsTypes();
        System.out.println("goodsTypeList = " + goodsTypeList);
        Gson gson = new Gson();
        return gson.toJson(goodsTypeList);
    }
}
