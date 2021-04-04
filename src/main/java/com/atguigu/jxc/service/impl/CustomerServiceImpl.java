package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerDao;
import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 删除客户列表
     * @param ids
     */
    @Override
    public void delete(String ids) {
        customerDao.delete(ids);
    }

    /**
     * 添加或修改客户列表
     * @param customer
     * @param customerId
     */
    @Override
    public void saveAndUpdate(Customer customer, Integer customerId) {
        if (customerId == null){
            //添加
            customerDao.save(customer);
        }else {
            //修改
            customerDao.update(customer);
        }
    }

    /**
     * 客户列表分页查询
     *
     * @param page
     * @param rows
     * @param customerName
     * @return
     */
    @Override
    public Map<String, Object> queryCustomersPage(Integer page, Integer rows, String customerName) {
        Map<String, Object> map = new HashMap<>();
        Integer total = customerDao.getCount();
       List<Customer> customers =  customerDao.queryCustomersPage(page - 1, rows, customerName);

        map.put("total",total);
        map.put("rows",customers);
        return map;
    }
}
