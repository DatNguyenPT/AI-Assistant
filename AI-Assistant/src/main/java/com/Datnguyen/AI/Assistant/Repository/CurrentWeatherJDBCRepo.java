package com.Datnguyen.AI.Assistant.Repository;

import com.Datnguyen.AI.Assistant.Entity.WeatherEntity;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CurrentWeatherJDBCRepo extends CrudRepository<WeatherEntity, Long> {
    // Select All By Day
    @Query (value = "SELECT * FROM currentweather cw where cw.time = :time", nativeQuery = true)
    List<WeatherEntity> getWeatherByDate(@Param("time") LocalDate findTime);

}
