package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.domain.ErrorCode;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.entity.Log;
import com.atguigu.jxc.entity.Unit;
import com.atguigu.jxc.service.CustomerReturnListGoodsService;
import com.atguigu.jxc.service.GoodsService;
import com.atguigu.jxc.service.LogService;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public ServiceVO getCode() {

        // 获取当前商品最大编码
        String code = goodsDao.getMaxCode();

        // 在现有编码上加1
        Integer intCode = Integer.parseInt(code) + 1;

        // 将编码重新格式化为4位数字符串形式
        String unitCode = intCode.toString();

        for (int i = 4; i > intCode.toString().length(); i--) {

            unitCode = "0" + unitCode;

        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS, unitCode);
    }

    /**
     * 查询所有 当前库存量 小于 库存下限的商品信息
     *
     * @return
     */
    @Override
    public Map<String, Object> listAlarm() {
        Map<String, Object> map = new HashMap<>();
        List<Goods> goodsList = goodsDao.listAlarm();
        map.put("rows", goodsList);
        return map;
    }

    /**
     * 添加商品期初库存或修改数量或成本价
     *
     * @param goodsId
     * @param inventoryQuantity
     * @param purchasingPrice
     */
    @Override
    public void saveStockAndEditStock(Integer goodsId, Integer inventoryQuantity, double purchasingPrice) {
        goodsDao.saveStockAndEditStock(goodsId, inventoryQuantity, purchasingPrice);
    }

    /**
     * 分页查询有库存商品信息
     *
     * @param page
     * @param rows
     * @param nameOrCode
     * @return
     */
    @Override
    public Map<String, Object> getHasInventoryQuantity(Integer page, Integer rows, String nameOrCode) {
        Map<String, Object> map = new HashMap<>();
        Integer total = goodsDao.getHasInventoryQuantityCount();

        List<Goods> goodsList = goodsDao.getHasInventoryQuantity(page - 1, rows, nameOrCode);
        map.put("total", total);
        map.put("rows", goodsList);
        return map;
    }

    /**
     * 分页查询无库存商品信息
     *
     * @param page
     * @param rows
     * @param nameOrCode
     * @return
     */
    @Override
    public Map<String, Object> getNoInventoryQuantity(Integer page, Integer rows, String nameOrCode) {
        Map<String, Object> map = new HashMap<>();
        Integer total = goodsDao.getNoInventoryQuantityCount();

        List<Goods> goodsList = goodsDao.getNoInventoryQuantity(page - 1, rows, nameOrCode);
        map.put("total", total);
        map.put("rows", goodsList);
        return map;
    }

    /**
     * 删除商品信息
     *
     * @param goodsId
     */
    @Override
    public void deleteGoodsById(Integer goodsId) {
        //首先先查询商品的状态，入库、有进货和销售单据的不能删除
        Goods goods = goodsDao.queryGoodsById(goodsId);
        if (goods.getState() != 0) {
            throw new RuntimeException("商品已入库或有进货和销售单据");
        }
        goodsDao.deleteGoodsById(goodsId);
    }

    /**
     * 添加或修改商品信息
     *
     * @param goods
     * @param goodsId
     */
    @Override
    public void saveAndEditGoods(Goods goods, Integer goodsId) {
        if (goodsId == null) {
            //添加
            goodsDao.save(goods);
        } else {
            //修改
            goodsDao.edit(goods);
        }
    }

    /**
     * 查询所有商品的单位
     *
     * @return
     */
    @Override
    public Map<String, Object> queryUnit() {
        Map<String, Object> map = new HashMap<>();
        List<Unit> unitList = goodsDao.queryUnit();
        System.out.println("unitList = " + unitList);
        map.put("rows", unitList);
        return map;
    }

    /**
     * 分页查询商品库存信息
     *
     * @return
     */
    @Override
    public Map<String, Object> queryGoodsPage(Integer page, Integer rows, String codeOrName, Integer goodsTypeId) {
        Map<String, Object> map = new HashMap<>();
        int total = goodsDao.getCountGoods();
        List<Goods> goods = goodsDao.queryGoodsPage(page - 1, rows, codeOrName, goodsTypeId);
        map.put("total", total);
        map.put("rows", goods);
        return map;
    }


}
