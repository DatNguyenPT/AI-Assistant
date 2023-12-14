package com.Datnguyen.AI.Assistant.Service;

import com.Datnguyen.AI.Assistant.AppConfig;
import com.Datnguyen.AI.Assistant.Repository.CurrentWeatherJDBCRepo;
import com.Datnguyen.AI.Assistant.Entity.WeatherEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

@org.springframework.stereotype.Service
public class WeatherService {
    private RestTemplate restTemplate;
    private AppConfig appConfig;
    private CurrentWeatherJDBCRepo currentWeatherJDBCRepo;
    private HashMap<String, String>map;

    WeatherService(RestTemplate restTemplate, AppConfig appConfig, CurrentWeatherJDBCRepo currentWeatherJDBCRepo){
        this.restTemplate = restTemplate;
        this.appConfig = appConfig;
        this.currentWeatherJDBCRepo = currentWeatherJDBCRepo;
        map = new HashMap<>();
    }

    public WeatherEntity getCurrentWeather(String city) {
        String url = appConfig.getWeatherInfoURL() + "/current.json?key=" + appConfig.getApiKey() + "&q=" + city;
        String resultJson = restTemplate.getForObject(url, String.class); // full data
        WeatherEntity weatherEntity = new WeatherEntity();
        try {
            // Parse JSON to WeatherEntity object
            weatherEntity = parseJsonToWeatherEntity(resultJson, city); // requested data
            StringTokenizer tokenizer = new StringTokenizer(resultJson, " ");

            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                String[] keyValue = token.split(":");
                if (keyValue.length >= 2) {
                    map.put(keyValue[0], keyValue[1]);
                } else {
                    // Handle the case where the split didn't produce the expected result
                    // You might want to log a warning or handle it appropriately for your use case
                    System.err.println("Unexpected token format: " + token);
                }
            }
            // Save WeatherEntity to the database
            currentWeatherJDBCRepo.save(weatherEntity);
        } catch (Exception e) {
            // Handle exception (e.g., log or throw a custom exception)
            e.printStackTrace();
        }
        return weatherEntity;
    }
    private WeatherEntity parseJsonToWeatherEntity(String json, String city) {
        // Parse JSON to a map for easier access
        Map<String, Object> jsonMap = parseJsonToMap(json);

        String country = (String) jsonMap.get("country");

        Map<String, Object> current = (Map<String, Object>) jsonMap.get("current");
        double windSpeed = parseDoubleFromMap(current, "wind_kph");
        double humidity = parseDoubleFromMap(current, "humidity");
        double cloud = parseDoubleFromMap(current, "cloud");

        // Create a new WeatherEntity
        WeatherEntity weatherEntity = new WeatherEntity(city, country, LocalDateTime.now(), windSpeed, humidity, cloud);

        return weatherEntity;
    }

    private Map<String, Object> parseJsonToMap(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

    private double parseDoubleFromMap(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        } else {
            return 0.0; // Provide a default value or throw a custom exception
        }
    }
}
