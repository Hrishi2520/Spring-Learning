package com.springlearning.journalApp.service;

import com.springlearning.journalApp.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String API_KEY;
    private static final String API = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";


    public WeatherResponse getWeather(String city) {
        String api = API.replace("CITY", "Mumbai").replace("API_KEY", API_KEY);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(api, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }
}
