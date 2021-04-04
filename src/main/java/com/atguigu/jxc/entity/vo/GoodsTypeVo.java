package com.atguigu.jxc.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class GoodsTypeVo {
    private Integer id;

    private String text; //类别

    private String state; //状态

    private String iconCls = "goods-type";//图标

    private Attributes attributes;

    //二级类别集合
    List<GoodsTypeVo> children;

}
