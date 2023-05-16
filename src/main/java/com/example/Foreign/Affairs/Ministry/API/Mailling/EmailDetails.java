package com.example.Foreign.Affairs.Ministry.API.Mailling;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Class
public class EmailDetails {

    // Class data members
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}