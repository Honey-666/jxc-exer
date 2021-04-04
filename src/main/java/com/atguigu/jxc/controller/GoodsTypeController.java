package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goodsType")
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    /**
     * 查询商品所有分类
     *
     * @return
     */
    @PostMapping("/loadGoodsType")
    public String queryGoodsTypes() {

        String goodsTypeStr = goodsTypeService.queryGoodsTypes();
        return goodsTypeStr;
    }

    /**
     * 新增分类
     *
     * @param goodsTypeName
     * @param pId
     * @return
     */
    @PostMapping("save")
    public ServiceVO saveGoodType(String goodsTypeName, Integer pId) {
        goodsTypeService.saveGoodType(goodsTypeName, pId);

        return new ServiceVO(SuccessCode.SUCCESS_CODE, "请求成功", null);
    }

    /**
     * 删除分类
     *
     * @param goodsTypeId
     * @return
     */
    @PostMapping("delete")
    public ServiceVO deleteGoodsType(Integer goodsTypeId) {
        goodsTypeService.deleteGoodsType(goodsTypeId);
        return new ServiceVO(SuccessCode.SUCCESS_CODE, "请求成功", null);
    }
}
