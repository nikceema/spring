package com.etiqa.management.controller;

import com.etiqa.management.dto.CustomerRequest;
import com.etiqa.management.dto.CustomerResponse;
import com.etiqa.management.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Customer", description = "Customer API")
@RestController
@AllArgsConstructor
@RequestMapping("customer")
public class CustomerController {

    private static Logger log = LogManager.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @GetMapping("/findAllCustomers")
    public ResponseEntity<List<CustomerResponse>> getAllCustomer(){

        try{
            List<CustomerResponse> responseList = new ArrayList<>();
            responseList = customerService.getAllCustomers();
            log.info("Return all customers list");
            return new ResponseEntity<>(responseList, HttpStatus.OK);
        }
        catch (Exception ex){
            log.error(ex.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/findCustomerById/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("id") Long id){

        try{
            CustomerResponse response = new CustomerResponse();
            response = customerService.getCustomerById(id);
            log.info("Return all customers list");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception ex){
            log.error(ex.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/createCustomer")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest request){

        try{
            CustomerResponse response = customerService.saveCustomer(request);
            log.info("CustomerController - createCustomer {} : ", request.toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception ex){
            log.error(ex.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody CustomerRequest request){

        try{
            CustomerResponse response = customerService.updateCustomer(request);
            log.info("CustomerController - updateCustomer {} : ", request.toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception ex){
            log.error(ex.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<CustomerResponse> deleteCustomer(@RequestBody CustomerRequest request){

        try{
            customerService.deleteCustomer(request);
            log.info("Delete customer {} is succesfull", request.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            log.error(ex.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
