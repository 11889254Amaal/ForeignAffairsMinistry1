package com.example.Foreign.Affairs.Ministry.API.ScheduleJobs;

import com.example.Foreign.Affairs.Ministry.API.Modell.News;
import com.example.Foreign.Affairs.Ministry.API.Modell.Policy;
import com.example.Foreign.Affairs.Ministry.API.Repsitory.NewsRepository;
import com.example.Foreign.Affairs.Ministry.API.Repsitory.PolicyRepository;
import com.example.Foreign.Affairs.Ministry.API.RequestObject.CreatePolicyRequest;
import com.example.Foreign.Affairs.Ministry.API.RequestObject.CreatenNewsRequest;
import com.example.Foreign.Affairs.Ministry.API.RequestObject.NewsRequestForUpdate;
import com.example.Foreign.Affairs.Ministry.API.RequestObject.PolicyRequestForUpdate;
import com.example.Foreign.Affairs.Ministry.API.Response.Article;
import com.example.Foreign.Affairs.Ministry.API.Response.NewsResponse;
import com.example.Foreign.Affairs.Ministry.API.Services.NewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Component
public class Schedule {
    @Autowired
    PolicyRepository policyRepository;

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    NewsServices newsServices;



   // @Scheduled(cron = "0 0 0 * * *")
   @Scheduled(cron = "0  0/5 * * *")
    public void updateNewsAndPolicies() {

        NewsResponse newsResponse = newsServices.getOneLinerNews();
        List<Article> articalList=newsResponse.getArticles();
        News NewsDetails = new News();
        for (Article artical:articalList)
        {
            NewsDetails.setTopicOfNews(artical.getSources());
            NewsDetails.setDetailsOfNews(artical.getCategory());
            newsRepository.save(NewsDetails);
        }

    }


}
