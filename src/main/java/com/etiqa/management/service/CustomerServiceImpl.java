package com.etiqa.management.service;

import com.etiqa.management.dto.CustomerRequest;
import com.etiqa.management.dto.CustomerResponse;
import com.etiqa.management.entity.Customer;
import com.etiqa.management.repo.CustomerRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService{

    private static final Logger log = LogManager.getLogger(CustomerServiceImpl.class);
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customerList = customerRepo.findAll();

        List<CustomerResponse> customerResponseList = objectMapper.convertValue(customerList,
                new TypeReference<List<CustomerResponse>>() {});

        log.info("All customers list : " + customerList.size());

        return customerResponseList;
    }

    @Override
    public CustomerResponse getCustomerById(Long id) throws Exception {
        if(id == null){
            log.error("getCustomerById - id is null.");
            throw new Exception("getCustomerId - id is null");
        }

        Optional<Customer> customer = customerRepo.findById(id);
        CustomerResponse customerResponse = objectMapper.convertValue(customer.get(), CustomerResponse.class);

        return  customerResponse;
    }

    @Override
    public CustomerResponse saveCustomer(CustomerRequest request) throws Exception {

        if(request == null){
            log.error("saveCustomer - Request body is null");
            throw new Exception("saveCustomer - Request body is null");
        }

        Customer customer = objectMapper.convertValue(request, Customer.class);
        customerRepo.save(customer);

        log.info("Successfully save/create customer : " + request.toString());

        CustomerResponse response = objectMapper.convertValue(customer, CustomerResponse.class);

        return response;
    }

    @Override
    public CustomerResponse updateCustomer(CustomerRequest request) throws Exception {

        if(request == null){
            log.error("updateCustomer - Request body is null");
            throw new Exception("updateCustomer - Request body is null");
        }

        if(request != null && request.getId() == null){
            log.error("updateCustomer - Request id is null");
            throw new Exception("updateCustomer - Request id is null");
        }

        Optional<Customer> customerOri = customerRepo.findById(request.getId());
        if(customerOri == null || customerOri.isEmpty()){
            throw new Exception("updateCUstomer - Cannot find customer by id : " + request.getId());
        }

        Customer customer = objectMapper.convertValue(request, Customer.class);
        updateMapping(customerOri.get(), customer);

        customerRepo.save(customer);

        log.info("Updated customer id : {}", request.getId());

        CustomerResponse response = objectMapper.convertValue(customer, CustomerResponse.class);

        return response;
    }

    @Override
    public void deleteCustomer(CustomerRequest request) throws Exception {

        if(request == null){
            log.error("deleteCustomer - Request body is null");
            throw new Exception("deleteCustomer - Request body is null");
        }

        if(request != null && request.getId() == null){
            log.error("deleteCustomer - Request id is null");
            throw new Exception("deleteCustomer - Request id is null");
        }

        Optional<Customer> customerOri = customerRepo.findById(request.getId());

        if(customerOri == null || customerOri.isEmpty()){
            throw new Exception("deleteCustomer - Cannot find customer by id : " + request.getId());
        }

        customerRepo.deleteById(request.getId());
        log.info("deleteCustomer - successfully delete customer {}", customerOri);

    }

    private void updateMapping(Customer ori, Customer req){
        if(req.getFirstName() == null){
            req.setFirstName(ori.getFirstName());
        }
        if(req.getLastName() == null){
            req.setLastName(ori.getLastName());
        }
        if(req.getCustomerType() == null){
            req.setCustomerType(ori.getCustomerType());
        }
        if(req.getContactAddress() == null){
            req.setContactAddress(ori.getContactAddress());
        }
        if(req.getHomeAddress() == null){
            req.setHomeAddress(ori.getHomeAddress());
        }
        if(req.getOfficeEmail() == null){
            req.setOfficeEmail(ori.getOfficeEmail());
        }
        if(req.getPrivateEmail() == null){
            req.setPrivateEmail(ori.getPrivateEmail());
        }
        if(req.getOfficeNo() == null){
            req.setOfficeNo(ori.getOfficeNo());
        }
        if(req.getMobileNo() == null){
            req.setMobileNo(ori.getMobileNo());
        }
        if(req.getRelationship() == null){
            req.setRelationship(ori.getRelationship());
        }
        if(req.getFamilyMembers() == null){
            req.setFamilyMembers(ori.getFamilyMembers());
        }
    }
}
