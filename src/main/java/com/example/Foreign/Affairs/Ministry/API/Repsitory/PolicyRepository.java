package com.example.Foreign.Affairs.Ministry.API.Repsitory;

import com.example.Foreign.Affairs.Ministry.API.Modell.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface PolicyRepository extends JpaRepository<Policy,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Policy c SET c.isActive=0  WHERE c.id = :id")
    void deletePolicy(@Param("id") Integer id);


    List<Policy> findByCountryName(String countryName);


    List<Policy> findByRegionName(String regionName);


    List<Policy> findByTitleOfPolicy(String titleOfPolicy);
}





