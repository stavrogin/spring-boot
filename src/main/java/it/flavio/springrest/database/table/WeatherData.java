package it.flavio.springrest.database.table;

import java.util.Date;

/**
 * DB model class representing WEATHER_DATA table
 * @author flavio
 */
public class WeatherData {
	
	private Long weatherdataId;
	private Date ts;
	private Double pressure;
	private Double temperature;
	private Double altitude;
	private String description;
	private Short datasourceId;
	
	public Long getWeatherdataId() {
		return weatherdataId;
	}
	public void setWeatherdataId(Long weatherdataId) {
		this.weatherdataId = weatherdataId;
	}
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
	public Double getPressure() {
		return pressure;
	}
	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Double getAltitude() {
		return altitude;
	}
	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Short getDatasourceId() {
		return datasourceId;
	}
	public void setDatasourceId(Short datasourceId) {
		this.datasourceId = datasourceId;
	}

}
