package com.example.Foreign.Affairs.Ministry.API.Controller;

import com.example.Foreign.Affairs.Ministry.API.Mailling.EmailDetails;
import com.example.Foreign.Affairs.Ministry.API.Mailling.EmailService;
import com.example.Foreign.Affairs.Ministry.API.Modell.News;
import com.example.Foreign.Affairs.Ministry.API.Modell.Policy;
import com.example.Foreign.Affairs.Ministry.API.RequestObject.CreatePolicyRequest;
import com.example.Foreign.Affairs.Ministry.API.RequestObject.CreatenNewsRequest;
import com.example.Foreign.Affairs.Ministry.API.RequestObject.NewsRequestForUpdate;
import com.example.Foreign.Affairs.Ministry.API.ScheduleJobs.Schedule;
import com.example.Foreign.Affairs.Ministry.API.Services.NewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@RestController
@RequestMapping(value = "NewsManagement")
public class NewsManagement {

    @Autowired
    NewsServices newsServices;

    @Autowired
    EmailService emailService;

    @Autowired
    Schedule scheduleDetails;
    @RequestMapping(value = "/createNews", method = RequestMethod.POST)
    public String createCustomer(@RequestBody CreatenNewsRequest createnNewsRequest)throws ParseException {
        try {
            newsServices.CreateNewNews(createnNewsRequest);

            return " new News add Successfully ";
        } catch (Exception e) {

            return "News filed  to add";
        }

    }

    @RequestMapping(value = "/updateNews", method = RequestMethod.POST)
    public String updateCustomer(@RequestBody NewsRequestForUpdate newsRequestForUpdate)throws ParseException  {
        try {
            newsServices.updateNewNews(newsRequestForUpdate);
            return " News Information updated Successfully ";
        } catch (Exception e) {
            return "update News Information  failed";
        }

    }

    @RequestMapping(value = "/deleteNews", method = RequestMethod.GET)
    public String deletePolicy(Integer id) {
        try {
            newsServices.deleteNews(id);
            return " News deleted Successfully ";
        } catch (Exception e) {
            return "News delete failed";
        }

    }

    @GetMapping
    public ResponseEntity<List<News>> searchNews(
            @RequestParam(value = "countryName", required = false) String countryName,
            @RequestParam(value = "regionName", required = false) String regionName,
            @RequestParam(value = "topicOfNews", required = false) String topicOfNews
    ) {
        List<News> policies = newsServices.searchNews(countryName, regionName, topicOfNews);
        return ResponseEntity.ok(policies);
    }
    @GetMapping(value="/EmailMessage")
    public void message(@RequestBody EmailDetails details) {
        emailService.sendSimpleMail(details);
        scheduleDetails.updateNewsAndPolicies();
    }
}
