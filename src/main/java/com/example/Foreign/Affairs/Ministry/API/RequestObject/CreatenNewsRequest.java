package com.example.Foreign.Affairs.Ministry.API.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class CreatenNewsRequest {

    private String countryName;

    private String regionName;
    private String topicOfNews;

    private String detailsOfNews;

    private String endDate;

    private Boolean isActive;
}
