package com.example.Foreign.Affairs.Ministry.API.Modell;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Getter
@Setter
@Entity
public class Policy extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String countryName;

    private String regionName;
    private String titleOfPolicy;

    private String detailsOfPolicy;
}
