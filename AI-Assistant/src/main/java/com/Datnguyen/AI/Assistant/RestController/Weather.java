package com.Datnguyen.AI.Assistant.RestController;

import com.Datnguyen.AI.Assistant.Entity.WeatherEntity;
import com.Datnguyen.AI.Assistant.Repository.CurrentWeatherJDBCRepo;
import com.Datnguyen.AI.Assistant.Service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class Weather {
    private WeatherService weatherService;
    private CurrentWeatherJDBCRepo currentWeatherJDBCRepo;

    public Weather(WeatherService weatherService, CurrentWeatherJDBCRepo currentWeatherJDBCRepo){
        this.weatherService = weatherService;
        this.currentWeatherJDBCRepo = currentWeatherJDBCRepo;
    }

    @PostMapping(value = "/currentweather")
    public ResponseEntity<?> getCurrentWeather(@RequestParam String city){
        WeatherEntity weatherEntity = weatherService.getCurrentWeather(city);
        currentWeatherJDBCRepo.save(weatherEntity);
        return new ResponseEntity<>(weatherEntity, HttpStatus.OK);
    }
}
