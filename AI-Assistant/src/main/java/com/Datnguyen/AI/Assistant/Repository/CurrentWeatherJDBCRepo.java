package com.Datnguyen.AI.Assistant.Repository;

import com.Datnguyen.AI.Assistant.Entity.WeatherEntity;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentWeatherJDBCRepo extends CrudRepository<WeatherEntity, Long> {
}
