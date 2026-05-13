package com.tripnext.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    @Value("${gemini.api.key}")
    private String apiKey;

    @PostMapping(
        value="/chat",
        produces=MediaType.TEXT_PLAIN_VALUE
    )

    public String chat(
            @RequestBody Map<String,String> body
    ){

        String message = body.get("message");

        String url =
        		"https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash-lite:generateContent?key="
        		+ apiKey;

        Map<String,Object> requestBody = Map.of(

            "contents",

            List.of(

                Map.of(

                    "parts",

                    List.of(

                        Map.of(
                            "text",
                            message
                        )

                    )
                )
            )
        );

        WebClient webClient =
        WebClient.create();

        try{

            Map response =

            webClient.post()
            .uri(url)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .retrieve()
            .bodyToMono(Map.class)
            .block();

            List candidates =
            (List) response.get("candidates");

            Map candidate =
            (Map) candidates.get(0);

            Map content =
            (Map) candidate.get("content");

            List parts =
            (List) content.get("parts");

            Map part =
            (Map) parts.get(0);

            return part.get("text").toString();

        }catch(Exception e){

            return "TripNext AI is currently busy. Please try again later.";
        }
    }
}