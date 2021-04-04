package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierDao {
    List<Supplier> querySuppliers(@Param("page") Integer page,@Param("rows") Integer rows,@Param("supplierName") String supplierName);

    void save(Supplier supplier);

    void update(Supplier supplier);

    void delete(String ids);

    Integer getCount();
}
