package com.Datnguyen.AI.Assistant.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "currentweather")
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String city;
    private String country;
    private LocalDateTime searchTime;
    private double wingSpeed;
    private double humidity;
    private double cloud;

    public WeatherEntity() {}
    public WeatherEntity(String city, String country, LocalDateTime searchTime, double wingSpeed, double humidity, double cloud) {
        this.city = city;
        this.country = country;
        this.searchTime = searchTime;
        this.wingSpeed = wingSpeed;
        this.humidity = humidity;
        this.cloud = cloud;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(LocalDateTime searchTime) {
        this.searchTime = searchTime;
    }

    public double getWingSpeed() {
        return wingSpeed;
    }

    public void setWingSpeed(double wingSpeed) {
        this.wingSpeed = wingSpeed;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidnity) {
        this.humidity = humidnity;
    }

    public double getCloud() {
        return cloud;
    }

    public void setCloud(double cloud) {
        this.cloud = cloud;
    }
}
