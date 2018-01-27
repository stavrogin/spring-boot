package it.flavio.springrest.manager;

import java.util.ArrayList;
import java.util.Date;
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
	
	@Override
	public WeatherDataModel insertWeatherData(WeatherDataModel weatherDataModel) {
		WeatherDataDTO dto = buildWeatherDataDTO(weatherDataModel);
		dto = weatherDataDAO.insertWeatherData(dto);
		WeatherDataModel model = buildWeatherDataModel(dto);
		return model;
	}
	
	@Override
	public boolean deleteWeatherData(Long weatherdataId) {
		boolean deleted = weatherDataDAO.deleteWeatherData(weatherdataId);
		return deleted;
	}
	
	/**
	 * Builds the jackson weather data model from dto
	 * @param dto the dto
	 * @return the jackson weather data model from dto
	 */
	private WeatherDataModel buildWeatherDataModel(WeatherDataDTO dto) {
		WeatherDataModel model = new WeatherDataModel();
		model.setWeatherdataId(dto.getWeatherdataId());
		model.setTs(dto.getTs());
		model.setDatasourceId(dto.getDatasourceId());
		model.setPressure(dto.getPressure());
		model.setTemperature(dto.getTemperature());
		model.setAltitude(dto.getAltitude());
		return model;
	}
	
	/**
	 * Builds DTO from weather data jackson model
	 * @param weatherDataModel the weather data model
	 * @return the weather data dto list
	 */
	private WeatherDataDTO buildWeatherDataDTO(WeatherDataModel weatherDataModel) {
		WeatherDataDTO dto = new WeatherDataDTO.WeatherDataDTOBuilder()
				.ts(new Date())
				.pressure(weatherDataModel.getPressure())
				.temperature(weatherDataModel.getTemperature())
				.altitude(weatherDataModel.getAltitude())
				.description(weatherDataModel.getDescription())
				.datasourceId(weatherDataModel.getDatasourceId())
				.build();
		return dto;
	}

}
