package com.example.Foreign.Affairs.Ministry.API.Modell;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
@Setter
@Getter
public class BaseEntity {
    @UpdateTimestamp
    private Date startDate;


    private String endDate;

    private Boolean isActive;

}