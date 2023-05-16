package com.example.Foreign.Affairs.Ministry.API.Mailling;

import org.springframework.stereotype.Component;

// Importing required classes


// Interface
public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
