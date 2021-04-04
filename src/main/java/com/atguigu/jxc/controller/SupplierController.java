package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Supplier;
import com.atguigu.jxc.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 供应商接口
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    /**
     * 分页查询供应商
     * @param page 当前页
     * @param rows 每页显示的记录数
     * @param supplierName 供应商名称
     * @return
     */
    @PostMapping("list")
    public Map<String, Object> querySuppliers(Integer page, Integer rows,String supplierName) {

        return supplierService.querySuppliers(page,rows,supplierName);
    }

    /**
     * 供应商的添加或者修改
     * @param supplier
     * @param
     * @return
     */
    @PostMapping("save")
    public ServiceVO saveAndUpdate(Supplier supplier,@RequestParam(required = false) Integer supplierId){

        supplierService.saveAndUpdate(supplier,supplierId);
        return new ServiceVO(SuccessCode.SUCCESS_CODE,"请求成功",null);
    }

    /**
     * 删除供应商
     * @param ids
     * @return
     */
    @PostMapping("delete")
    public ServiceVO deleteSupplier(@RequestParam String ids){
        supplierService.delete(ids);
        return new ServiceVO(SuccessCode.SUCCESS_CODE,"请求成功",null);
    }



}
