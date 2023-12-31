package com.etiqa.management.service;

import com.etiqa.management.dto.CustomerRequest;
import com.etiqa.management.dto.CustomerResponse;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<CustomerResponse> getAllCustomers();
    CustomerResponse getCustomerById(Long id) throws Exception;
    CustomerResponse saveCustomer(CustomerRequest request) throws Exception;
    CustomerResponse updateCustomer(CustomerRequest request) throws Exception;

    void deleteCustomer(CustomerRequest request) throws Exception;
}
