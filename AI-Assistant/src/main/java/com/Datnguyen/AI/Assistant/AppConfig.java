package com.Datnguyen.AI.Assistant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Value("${external.api.key}")
    private String apiKey;
    @Value("${external.api.weatherinfo}")
    private String WeatherInfoURL;

    public String getApiKey() {
        return apiKey;
    }

    public String getWeatherInfoURL() {
        return WeatherInfoURL;
    }
}
