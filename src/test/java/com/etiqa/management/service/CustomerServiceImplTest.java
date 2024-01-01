package com.etiqa.management.service;

import com.etiqa.management.dto.CustomerRequest;
import com.etiqa.management.dto.CustomerResponse;
import com.etiqa.management.entity.Customer;
import com.etiqa.management.repo.CustomerRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @InjectMocks
    CustomerServiceImpl customerServiceMock;

    @Mock
    CustomerRepo customerRepoMock;

    @Mock
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void ini(){
        ReflectionTestUtils.setField(customerServiceMock,"objectMapper", objectMapper);
    }

    @Test
    void checkObjectMapper() {
        assertNotNull(objectMapper);
    }

    @Test
    public void testGetAllCustomers(){
        List<Customer> customerList = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(Long.valueOf(1));
        customerList.add(customer);

        List<CustomerResponse> responseList = new ArrayList<>();
        CustomerResponse response = new CustomerResponse();
        response.setId(Long.valueOf(1));
        responseList.add(response);

        lenient().doReturn(responseList).when(objectMapper).convertValue(any(),(TypeReference<? extends Object>) any());
        when(customerRepoMock.findAll()).thenReturn(customerList);
        assertDoesNotThrow(() -> customerServiceMock.getAllCustomers());
    }

    @Test
    void testCreateCustomer(){
        CustomerRequest request = new CustomerRequest();
        request.setFirstName("Name");
        request.setLastName("Last Name");
        request.setPrivateEmail("myemail@mail.com");
        request.setHomeAddress("On earth");

        Customer customer = new Customer();
        customer.setFirstName("Name");
        customer.setLastName("Last Name");
        customer.setPrivateEmail("myemail@mail.com");
        customer.setHomeAddress("On earth");

        lenient().doReturn(customer).when(objectMapper).convertValue(any(),(TypeReference<? extends Object>) any());
        when(customerRepoMock.save(any())).thenReturn(customer);
        assertDoesNotThrow(()->customerServiceMock.saveCustomer(request));


    }
}
