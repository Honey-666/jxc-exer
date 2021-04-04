package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.Supplier;

import java.util.Map;

public interface SupplierService {
    Map<String, Object> querySuppliers(Integer page, Integer rows, String supplierName);

    void saveAndUpdate(Supplier supplier, Integer supplierId);

    void delete(String ids);
}
