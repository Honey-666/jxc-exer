package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.Customer;

import java.util.Map;

public interface CustomerService {
    Map<String, Object> queryCustomersPage(Integer page, Integer rows, String customerName);

    void saveAndUpdate(Customer customer, Integer customerId);

    void delete(String ids);
}
