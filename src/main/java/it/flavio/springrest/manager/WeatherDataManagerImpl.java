package it.flavio.springrest.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.flavio.springrest.model.WeatherDataModel;
import it.flavio.springtest.dao.WeatherDataDAO;
import it.flavio.springtest.dto.WeatherDataDTO;

public class WeatherDataManagerImpl implements WeatherDataManager {

	@Autowired
    private WeatherDataDAO weatherDataDAO;
	
	@Override
	public List<WeatherDataModel> findAllWeatherData() {
		List<WeatherDataDTO> dtoList = weatherDataDAO.findAllWeatherData();
		List<WeatherDataModel> modelList = new ArrayList<>(dtoList.size()); 
		dtoList.forEach(dto -> modelList.add(buildWeatherDataModel(dto)));
		return modelList;
	}
	
	/**
	 * Builds the jackson weather data model from dto
	 * @param dto the dto
	 * @return the jackson weather data model from dto
	 */
	private WeatherDataModel buildWeatherDataModel(WeatherDataDTO dto) {
		WeatherDataModel model = new WeatherDataModel();
		model.setTimestamp(dto.getTs());
		model.setDatasourceId(dto.getDatasourceId());
		model.setPressure(dto.getPressure());
		model.setTemperature(dto.getTemperature());
		model.setAltitude(dto.getAltitude());
		return model;
	}

}
