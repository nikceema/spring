package com.etiqa.management.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerRequest extends PersonRequest {

    private Long id;
    private String officeEmail;
    private String contactAddress;
    private String officeNo;
    private String customerType;
    private String relationship;
    private List<CustomerRequest> familyMembers;

}
