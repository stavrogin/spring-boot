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
	 * Get all stored weather data starting from the passed-in days back
	 * @param daysBack the days back to start geathering weather data
	 * @return the stored weather data
	 */
	List<WeatherDataDTO> findWeatherData(long daysBack);
	
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
