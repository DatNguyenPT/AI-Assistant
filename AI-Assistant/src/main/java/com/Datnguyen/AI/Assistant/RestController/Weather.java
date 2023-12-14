package com.Datnguyen.AI.Assistant.RestController;

import com.Datnguyen.AI.Assistant.Service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class Weather {
    private WeatherService weatherService;

    public Weather(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/currentweather")
    public ResponseEntity<?>getCurrentWeather(@RequestParam String city){
        return new ResponseEntity<>(weatherService.getCurrentWeather(city), HttpStatus.OK);
    }
}
