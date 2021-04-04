package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDao {
    List<Customer> queryCustomersPage(@Param("page") Integer page, @Param("rows") Integer rows, @Param("customerName") String customerName);

    void save(Customer customer);

    void update(Customer customer);

    void delete(String ids);

    Integer getCount();
}
