package com.Datnguyen.AI.Assistant.Entity;

import javax.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "currentweather")
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
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


    @Column(name = "time")
    private LocalDate time;

    public WeatherEntity() {}
    public WeatherEntity(String city, LocalDateTime searchTime, double wingSpeed, double humidity, double cloud, LocalDate time) {
        this.city = city;
        this.searchTime = searchTime;
        this.wingSpeed = wingSpeed;
        this.humidity = humidity;
        this.cloud = cloud;
        this.time = time;
    }

    public long getId(){return id;}

    public void setId(long id){this.id = id;}

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
    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }
}
