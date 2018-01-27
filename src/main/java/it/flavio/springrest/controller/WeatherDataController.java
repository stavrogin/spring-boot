package it.flavio.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.flavio.springrest.manager.WeatherDataManager;
import it.flavio.springrest.model.WeatherDataModel;

@RestController
public class WeatherDataController {
	
	@Autowired
    private WeatherDataManager weatherDataManager;

	@RequestMapping(value="/weatherdata", method=RequestMethod.GET)
	public List<WeatherDataModel> getWeatherData(@RequestParam(value = "back", defaultValue = "30") String name) {
		List<WeatherDataModel> weatherDataList = weatherDataManager.findAllWeatherData();
		return weatherDataList;
	}
	
	@RequestMapping(value="/weatherdata", method=RequestMethod.POST)
	public String saveWeatherData(@RequestBody WeatherDataModel body) {
		/*
		WeatherData weatherData = new WeatherData();
		weatherData.setTs(new Date());
		weatherData.setTemperature(body.getTemperature());
		weatherData.setDatasourceId(body.getDatasourceId());
		weatherDataMapper.insertWeatherData(weatherData);
		*/
		return "ok";
	}
	
}
