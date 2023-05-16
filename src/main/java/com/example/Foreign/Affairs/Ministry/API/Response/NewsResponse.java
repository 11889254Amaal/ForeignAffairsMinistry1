package com.example.Foreign.Affairs.Ministry.API.Response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class NewsResponse {

    private List<Article> articles;

}


