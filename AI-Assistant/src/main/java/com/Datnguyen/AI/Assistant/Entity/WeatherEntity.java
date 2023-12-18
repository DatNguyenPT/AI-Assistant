package com.Datnguyen.AI.Assistant.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "currentweather")
public class WeatherEntity {
    @Id
    @Column(name = "city")
    private String city;
    @Column(name = "searchtime")
    private LocalDateTime searchTime;
    @Column(name = "wingspeed")
    private double wingSpeed;
    @Column(name = "humidity")
    private double humidity;
    @Column(name = "cloud")
    private double cloud;

    public WeatherEntity() {}
    public WeatherEntity(String city, LocalDateTime searchTime, double wingSpeed, double humidity, double cloud) {
        this.city = city;
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
