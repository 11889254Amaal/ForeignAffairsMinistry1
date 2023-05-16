package com.example.Foreign.Affairs.Ministry.API.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class NewsRequestForUpdate {
    private Integer id;
    private String countryName;

    private String regionName;
    private String topicOfNews;

    private String detailsOfNews;

    private String endDate;

    private Boolean isActive;
}
