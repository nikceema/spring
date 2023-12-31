package com.etiqa.management.dto;

import lombok.Data;

@Data
public class PersonResponse {

    private String firstName;
    private String lastName;
    private String homeAddress;
    private String mobileNo;
    private String privateEmail;
}
