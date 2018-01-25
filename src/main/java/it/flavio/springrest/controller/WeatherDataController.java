package it.flavio.springrest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.flavio.springrest.database.model.WeatherData;
import it.flavio.springrest.model.WeatherDataBody;
import it.flavio.springrest.mybatis.mapper.WeatherDataMapper;

@RestController
public class WeatherDataController {
	
	@Autowired
    private WeatherDataMapper weatherDataMapper;

	@RequestMapping(value="/weatherdata", method=RequestMethod.GET)
	public WeatherDataBody getWeatherData(@RequestParam(value = "back", defaultValue = "30") String name) {
		List<WeatherData> weatherDataList = weatherDataMapper.findAllWeatherData();
		weatherDataList.forEach(d -> System.out.println(d.getTemperature()));
		return null;
	}
	
	@RequestMapping(value="/weatherdata", method=RequestMethod.POST)
	public String saveWeatherData(@RequestBody WeatherDataBody body) {
		WeatherData weatherData = new WeatherData();
		weatherData.setTs(new Date());
		weatherData.setTemperature(body.getTemperature());
		weatherData.setDatasourceId(body.getDatasourceId());
		weatherDataMapper.insertWeatherData(weatherData);
		return "ok";
	}
	
}
