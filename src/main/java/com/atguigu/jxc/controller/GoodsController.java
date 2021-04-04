package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.service.GoodsService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 商品信息Controller
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 分页查询商品库存信息
     *
     * @param page        当前页
     * @param rows        每页显示条数
     * @param codeOrName  商品编码或名称
     * @param goodsTypeId 商品类别ID
     * @return
     */
    @PostMapping("/goods/listInventory")
    public Map<String,Object> queryGoodsPage(Integer page, Integer rows, String codeOrName, Integer goodsTypeId) {

        return goodsService.queryGoodsPage(page,rows,codeOrName,goodsTypeId);

    }

    /**
     * 查询所有商品的单位
     * @return
     */
    @PostMapping("/unit/list")
    public Map<String,Object> queryUnit(){
        return goodsService.queryUnit();
    }



    /**
     * 分页查询商品信息
     * @param page 当前页
     * @param rows 每页显示条数
     * @param goodsName 商品名称
     * @param goodsTypeId 商品类别ID
     * @return
     */
    @PostMapping("/goods/list")
    public Map<String,Object> queryGoodsListPage(Integer page, Integer rows, String goodsName, Integer goodsTypeId) {

        return goodsService.queryGoodsPage(page,rows,goodsName,goodsTypeId);

    }


    /**
     * 生成商品编码
     *
     * @return
     */
    @RequestMapping("/getCode")
    @RequiresPermissions(value = "商品管理")
    public ServiceVO getCode() {
        return goodsService.getCode();
    }

    /**
     * 添加或修改商品信息
     * @param goods 商品信息实体
     * @return
     */
    @PostMapping("goods/save")
    public ServiceVO saveAndEditGoods(Goods goods,@RequestParam(required = false) Integer goodsId){
        goodsService.saveAndEditGoods(goods,goodsId);

        return new ServiceVO(SuccessCode.SUCCESS_CODE,"请求成功",null);
    }

    /**
     * 删除商品信息
     * @param goodsId 商品ID
     * @return
     */
    @PostMapping("goods/delete")
    public ServiceVO deleteGoodsById(@RequestParam Integer goodsId){
        goodsService.deleteGoodsById(goodsId);
        return new ServiceVO(SuccessCode.SUCCESS_CODE,"请求成功",null);
    }

    /**
     * 分页查询无库存商品信息
     * @param page 当前页
     * @param rows 每页显示条数
     * @param nameOrCode 商品名称或商品编码
     * @return
     */
    @PostMapping("goods/getNoInventoryQuantity")
    public Map<String,Object> getNoInventoryQuantity(Integer page,Integer rows,String nameOrCode){
      return   goodsService.getNoInventoryQuantity(page,rows,nameOrCode);
    }


    /**
     * 分页查询有库存商品信息
     * @param page 当前页
     * @param rows 每页显示条数
     * @param nameOrCode 商品名称或商品编码
     * @return
     */
    @PostMapping("goods/getHasInventoryQuantity")
    public Map<String,Object> getHasInventoryQuantity(Integer page,Integer rows,String nameOrCode){

        return goodsService.getHasInventoryQuantity(page,rows,nameOrCode);
    }

    /**
     * 添加商品期初库存或修改数量或成本价
     * @param goodsId 商品ID
     * @param inventoryQuantity 库存
     * @param purchasingPrice 成本价
     * @return
     */
    @PostMapping("goods/saveStock")
    public ServiceVO saveStockAndEditStock(Integer goodsId,Integer inventoryQuantity,double purchasingPrice){
        goodsService.saveStockAndEditStock(goodsId,inventoryQuantity,purchasingPrice);

        return new ServiceVO(SuccessCode.SUCCESS_CODE,"请求成功",null);
    }

    /**
     * 删除商品库存
     * @param goodsId 商品ID
     * @return
     */
    @PostMapping("goods/deleteStock")
    public ServiceVO deleteStock(Integer goodsId){
        goodsService.deleteGoodsById(goodsId);
        return new ServiceVO(SuccessCode.SUCCESS_CODE,"请求成功",null);
    }

    /**
     * 查询库存报警商品信息
     * @return
     */
    @PostMapping("/goods/listAlarm")
    public Map<String,Object> listAlarm(){

        return goodsService.listAlarm();
    }
}
