package com.example.Foreign.Affairs.Ministry.API.Repsitory;

import com.example.Foreign.Affairs.Ministry.API.Modell.News;
import com.example.Foreign.Affairs.Ministry.API.Modell.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface NewsRepository  extends JpaRepository<News,Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE News c SET c.isActive=1  WHERE c.id = :id")
    void deleteNews(@Param("id") Integer id);

    List<News> findByCountryName(String countryName);


    List<News> findByRegionName(String regionName);


    List<News> findByTopicOfNews(String topicOfNews);
}
