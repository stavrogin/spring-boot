package it.flavio.springtest.dto;

import java.util.Date;

/**
 * DTO model class representing WEATHER_DATA table
 * @author flavio
 */
public class WeatherDataDTO {
	
	private Long weatherdataId;
	private Date ts;
	private Double pressure;
	private Double temperature;
	private Double altitude;
	private String description;
	private Short datasourceId;
	
	public WeatherDataDTO(WeatherDataDTOBuilder builder) {
		weatherdataId = builder.weatherdataId;
		ts = builder.ts;
		pressure = builder.pressure;
		temperature = builder.temperature;
		altitude = builder.altitude;
		description = builder.description;
		datasourceId = builder.datasourceId;
	}
	
	public Long getWeatherdataId() {
		return weatherdataId;
	}
	public Date getTs() {
		return ts;
	}
	public Double getPressure() {
		return pressure;
	}
	public Double getTemperature() {
		return temperature;
	}
	public Double getAltitude() {
		return altitude;
	}
	public String getDescription() {
		return description;
	}
	public Short getDatasourceId() {
		return datasourceId;
	}

	public static class WeatherDataDTOBuilder {
		
		private Long weatherdataId;
		private Date ts;
		private Double pressure;
		private Double temperature;
		private Double altitude;
		private String description;
		private Short datasourceId;

		public WeatherDataDTOBuilder weatherdataId(Long weatherdataId) {
			this.weatherdataId = weatherdataId;
			return this;
		}
		
		public WeatherDataDTOBuilder ts(Date ts) {
			this.ts = ts;
			return this;
		}
		
		public WeatherDataDTOBuilder pressure(Double pressure) {
			this.pressure = pressure;
			return this;
		}
		
		public WeatherDataDTOBuilder temperature(Double temperature) {
			this.temperature = temperature;
			return this;
		}
		
		public WeatherDataDTOBuilder altitude(Double altitude) {
			this.altitude = altitude;
			return this;
		}
		
		public WeatherDataDTOBuilder description(String description) {
			this.description = description;
			return this;
		}
		
		public WeatherDataDTO build() {
			return new WeatherDataDTO(this);
		}
		
	}

}
