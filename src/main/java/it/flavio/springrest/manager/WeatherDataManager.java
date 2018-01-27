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
	
}
