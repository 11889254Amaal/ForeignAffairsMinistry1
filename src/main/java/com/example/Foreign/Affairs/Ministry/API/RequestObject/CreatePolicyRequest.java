package com.example.Foreign.Affairs.Ministry.API.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Data
public class CreatePolicyRequest {
    private String countryName;

    private String regionName;
    private String titleOfPolicy;

    private String detailsOfPolicy;

    private String endDate;

    private Boolean isActive;
}
