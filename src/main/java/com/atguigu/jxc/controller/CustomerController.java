package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.IntegerSyntax;
import java.util.Map;

/**
 * 客户列表
 */
@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 客户列表分页查询
     * @param page
     * @param rows
     * @param customerName
     * @return
     */
    @PostMapping("list")
    public Map<String, Object> queryCustomersPage(Integer page,Integer rows,String  customerName){
       return customerService.queryCustomersPage(page,rows,customerName);
    }

    /**
     * 添加或修改客户列表
     * @param customer
     * @param customerId
     * @return
     */
    @PostMapping("save")
    public ServiceVO saveAndUpdate(Customer customer, @RequestParam(required = false)Integer customerId){
        customerService.saveAndUpdate(customer,customerId);

        return new ServiceVO(SuccessCode.SUCCESS_CODE,"请求成功",null);
    }

    /**
     * 删除客户列表
     * @param ids
     * @return
     */
    @PostMapping("delete")
    public ServiceVO delete(@RequestParam String ids){
        customerService.delete(ids);
        return new ServiceVO(SuccessCode.SUCCESS_CODE,"请求成功",null);

    }
}
