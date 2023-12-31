package com.etiqa.management.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CustomerResponse extends PersonResponse{

    private Long id;
    private String officeEmail;
    private String contactAddress;
    private String officeNo;
    private String customerType;
    private String relationship;
    private List<CustomerRequest> familyMembers;
}
