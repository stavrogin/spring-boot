package it.flavio.springrest.manager;

import java.util.List;

import it.flavio.springrest.model.WeatherDataModel;

/**
 * Manage and transform data coming from the data source
 * @author flavio
 */
public interface WeatherDataManager {

	/**
	 * Finds all the weather data
	 * @return the list of the weather data to be sent as output
	 */
	List<WeatherDataModel> findAllWeatherData();
	
	/**
	 * Inserts a weather data point
	 * @param weatherDataModel the weather data to insert
	 * @return the inserted id
	 */
	WeatherDataModel insertWeatherData(WeatherDataModel weatherDataModel);
	
	/**
	 * Deletes a weather data
	 * @param weahterdataId the weather data id
	 * @return true if the weather data has been deleted
	 */
	boolean deleteWeatherData(Long weatherdataId);
	
}
