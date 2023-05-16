package com.example.Foreign.Affairs.Ministry.API.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class PolicyRequestForUpdate {
    private Integer id;
    private String countryName;

    private String regionName;
    private String titleOfPolicy;

    private String detailsOfPolicy;

    private String EndDate;
    private Boolean isActive;
}
