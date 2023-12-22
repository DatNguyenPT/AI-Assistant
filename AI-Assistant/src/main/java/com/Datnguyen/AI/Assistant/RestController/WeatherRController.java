package com.Datnguyen.AI.Assistant.RestController;

import com.Datnguyen.AI.Assistant.Entity.WeatherEntity;
import com.Datnguyen.AI.Assistant.Repository.CurrentWeatherJDBCRepo;
import com.Datnguyen.AI.Assistant.Service.GetCurrentWeatherService;
import com.Datnguyen.AI.Assistant.Service.WeatherForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class WeatherRController {
    private GetCurrentWeatherService getCurrentWeatherService;
    private WeatherForecast weatherForecast;
    private CurrentWeatherJDBCRepo currentWeatherJDBCRepo;

    @Autowired
    public WeatherRController(GetCurrentWeatherService getCurrentWeatherService, WeatherForecast weatherForecast, CurrentWeatherJDBCRepo currentWeatherJDBCRepo){
        this.getCurrentWeatherService = getCurrentWeatherService;
        this.currentWeatherJDBCRepo = currentWeatherJDBCRepo;
        this.weatherForecast = weatherForecast;
    }

    @PostMapping(value = "/currentweather")
    public ResponseEntity<?> getCurrentWeather(@RequestParam String city){
        WeatherEntity weatherEntity = getCurrentWeatherService.getCurrentWeather(city);
        currentWeatherJDBCRepo.save(weatherEntity);
        return new ResponseEntity<>(weatherEntity, HttpStatus.OK);
    }

    @GetMapping(value = "/getweatherbydate")
    public ResponseEntity<?>getWeatherByDate(@RequestParam LocalDate day){
        List<WeatherEntity>list = currentWeatherJDBCRepo.getWeatherByDate(day);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/forecast") // not finished
    public ResponseEntity<?>weatherForecast(@RequestParam String city){
        String weatherEntity = weatherForecast.weatherForecast(city);
        return new ResponseEntity<>(weatherEntity, HttpStatus.OK);
    }

}
