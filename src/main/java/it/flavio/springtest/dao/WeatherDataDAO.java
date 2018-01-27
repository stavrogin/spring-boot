package it.flavio.springtest.dao;

import java.util.List;

import it.flavio.springtest.dto.WeatherDataDTO;

public interface WeatherDataDAO {

	/**
	 * Get all stored weather data
	 * @return the all stored weather data
	 */
	List<WeatherDataDTO> findAllWeatherData();
	
	/**
	 * Inserts a new weather data point
	 * @param weatherDataDTO the weather data dto
	 * @return true if the insert was successful
	 */
	WeatherDataDTO insertWeatherData(WeatherDataDTO weatherDataDTO);
	
	/**
	 * Deletes a weather data by id
	 * @param weatherdataId the weather data id
	 * @return true if the record was deleted
	 */
	boolean deleteWeatherData(Long weatherdataId);
}
