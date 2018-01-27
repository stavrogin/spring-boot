package it.flavio.springtest.dao;

import java.util.List;

import it.flavio.springtest.dto.WeatherDataDTO;

public interface WeatherDataDAO {

	/**
	 * Get all stored weather data
	 * @return the all stored weather data
	 */
	List<WeatherDataDTO> findAllWeatherData();
	
}
