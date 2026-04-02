package com.springlearning.journalApp.service;

import com.springlearning.journalApp.cache.AppCache;
import com.springlearning.journalApp.constants.PlaceHolders;
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

    @Autowired
    private AppCache appCache;

    @Value("${weather.api.key}")
    private String API_KEY;

    @Autowired
    private RedisService redisService;
//
//    private static final String API = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";


    public WeatherResponse getWeather(String city) {
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city, WeatherResponse.class);
        if (weatherResponse !=null) {
            return weatherResponse;
        } else {
            String api = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(PlaceHolders.CITY, "Mumbai").replace(PlaceHolders.API_KEY, API_KEY);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(api, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if (body !=null){
                redisService.set("weather_of_" + city, body, 300L);
            }
            return body;
        }

    }
}
