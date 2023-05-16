package com.example.Foreign.Affairs.Ministry.API.Controller;


import com.example.Foreign.Affairs.Ministry.API.Mailling.EmailDetails;
import com.example.Foreign.Affairs.Ministry.API.Mailling.EmailService;

import com.example.Foreign.Affairs.Ministry.API.Modell.Policy;
import com.example.Foreign.Affairs.Ministry.API.RequestObject.CreatePolicyRequest;
import com.example.Foreign.Affairs.Ministry.API.RequestObject.PolicyRequestForUpdate;
import com.example.Foreign.Affairs.Ministry.API.ScheduleJobs.Schedule;
import com.example.Foreign.Affairs.Ministry.API.Services.PolicyServices;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "PolicyManagement")
public class PolicyManagementController {
    @Autowired
    PolicyServices policyServices;

//    @Autowired
//    EmailService emailService;
//
//    @Autowired
//    Schedule scheduleDetails;
    @RequestMapping(value = "/createPolicy", method = RequestMethod.POST)
    public String createCustomer(@RequestBody CreatePolicyRequest createPolicyRequest) throws ParseException {
        try {
            policyServices.CreateNewPolicy(createPolicyRequest);

            return " new Polic add Successfully ";
        } catch (Exception e) {

            return "Polic filed  to add";
        }

    }

    @RequestMapping(value = "/updatePolicy", method = RequestMethod.POST)
    public String updateCustomer(@RequestBody PolicyRequestForUpdate policyRequestForUpdate) throws ParseException {
        try {
            policyServices.updateNewPolicy(policyRequestForUpdate);
            return " Policy Information updated Successfully ";
        } catch (Exception e) {
            return "update Policy Information  failed";
        }

    }

    @RequestMapping(value = "/deletePolicy", method = RequestMethod.GET)
    public String deletePolicy(Integer id) {
        try {
            policyServices.deletePolicy(id);
            return " Policy deleted Successfully ";
        } catch (Exception e) {
            return "Policy delete failed";
        }

    }

    @GetMapping
    public ResponseEntity<List<Policy>> searchPolicies(
            @RequestParam(value = "countryName", required = false) String countryName,
            @RequestParam(value = "regionName", required = false) String regionName,
            @RequestParam(value = "titleOfPolicy", required = false) String topicOfNews
    ) {
        List<Policy> policies = policyServices.searchPolicies(countryName, regionName, topicOfNews);
        return ResponseEntity.ok(policies);
    }


}
