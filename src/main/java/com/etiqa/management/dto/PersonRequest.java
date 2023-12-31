package com.etiqa.management.dto;

import lombok.Data;

@Data
public class PersonRequest {

    private String firstName;
    private String lastName;
    private String homeAddress;
    private String mobileNo;
    private String privateEmail;
}
