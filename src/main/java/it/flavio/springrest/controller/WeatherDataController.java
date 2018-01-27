package it.flavio.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.flavio.springrest.manager.WeatherDataManager;
import it.flavio.springrest.model.WeatherDataModel;

@RestController
public class WeatherDataController {
	
	@Autowired
    private WeatherDataManager weatherDataManager;

	@RequestMapping(value="/weatherdata", method=RequestMethod.GET)
	public ResponseEntity<List<WeatherDataModel>> getWeatherData(@RequestParam(value = "back", defaultValue = "30") String name) {
		List<WeatherDataModel> weatherDataList = weatherDataManager.findAllWeatherData();
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Access-Control-Allow-Origin", "*");
	    return new ResponseEntity<List<WeatherDataModel>>(weatherDataList, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value="/weatherdata", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public WeatherDataModel saveWeatherData(@RequestBody WeatherDataModel weatherDataModel) {
		WeatherDataModel response = weatherDataManager.insertWeatherData(weatherDataModel);
		return response;
	}
	
}
