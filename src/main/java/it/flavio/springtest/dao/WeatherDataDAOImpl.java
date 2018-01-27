package it.flavio.springtest.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.flavio.springrest.database.table.WeatherData;
import it.flavio.springrest.mybatis.mapper.WeatherDataMapper;
import it.flavio.springtest.dto.WeatherDataDTO;

public class WeatherDataDAOImpl implements WeatherDataDAO {

	@Autowired
	private WeatherDataMapper weatherDataMapper;
	
	/**
	 * Get all stored weather data
	 * @return the all stored weather data
	 */
	@Override
	public List<WeatherDataDTO> findAllWeatherData() {
		List<WeatherData> weatherDataList = weatherDataMapper.findAllWeatherData();
		List<WeatherDataDTO> weatherDataDTOList = new ArrayList<>();
		weatherDataList.forEach(d -> weatherDataDTOList.add(buildWeatherDataDto(d)));
		return weatherDataDTOList;
	}
	
	/**
	 * Builds DTO from weather data model
	 * @param weatherData the weather data model
	 * @return the weather data dto list
	 */
	private WeatherDataDTO buildWeatherDataDto(WeatherData weatherData) {
		WeatherDataDTO dto = new WeatherDataDTO.WeatherDataDTOBuilder()
				.weatherdataId(weatherData.getWeatherdataId())
				.ts(weatherData.getTs())
				.pressure(weatherData.getPressure())
				.temperature(weatherData.getTemperature())
				.altitude(weatherData.getAltitude())
				.description(weatherData.getDescription())
				.build();
		return dto;
	}
}
