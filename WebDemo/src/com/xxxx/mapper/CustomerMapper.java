package com.xxxx.mapper;

import com.xxxx.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {


    List<Customer> getCustomer(@Param("userId") Integer userId);

    int insertAll(@Param("userId") Integer userId, @Param("customer_name") String customer_name, @Param("customer_address") String customer_address);
}
