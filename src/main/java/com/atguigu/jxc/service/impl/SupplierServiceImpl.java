package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.SupplierDao;
import com.atguigu.jxc.entity.Supplier;
import com.atguigu.jxc.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao supplierDao;

    /**
     * 分页查询供应商
     * @param page 当前页
     * @param rows 每页显示的记录数
     * @param supplierName 供应商名称
     * @return
     */
    @Override
    public Map<String, Object> querySuppliers(Integer page, Integer rows, String supplierName) {
        Map<String,Object> map = new HashMap<>();
        Integer total = supplierDao.getCount();

       List<Supplier> suppliers =  supplierDao.querySuppliers(page-1,rows,supplierName);

        map.put("total",total);
        map.put("rows",suppliers);
        return map;
    }

    /**
     *删除供应商
     * @param ids
     */
    @Override
    public void delete(String ids) {
        supplierDao.delete(ids);
    }

    /**
     * 供应商的添加或者修改
     * @param
     * @param supplier
     * @param supplierId
     */
    @Override
    public void saveAndUpdate(Supplier supplier, Integer supplierId) {
        if (supplierId == null){
            //添加
            supplierDao.save(supplier);
        }else {
            //修改
            supplierDao.update(supplier);
        }
    }
}
