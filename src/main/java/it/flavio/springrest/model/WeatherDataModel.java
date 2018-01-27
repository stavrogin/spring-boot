package it.flavio.springrest.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class WeatherDataModel {
	
	private Long weatherdataId;
	//http://www.baeldung.com/jackson-serialize-dates
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date ts;
	private Double temperature;
	private Double pressure;
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
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Double getPressure() {
		return pressure;
	}
	public void setPressure(Double pressure) {
		this.pressure = pressure;
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
