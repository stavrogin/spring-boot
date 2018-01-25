package it.flavio.springrest.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import it.flavio.springrest.database.model.WeatherData;

public interface WeatherDataMapper {
	
	@Insert("insert into weather_data(ts, pressure, temperature, altitude, description, datasource_id) values(#{ts}, #{pressure}, #{temperature}, #{altitude}, #{description}, #{datasourceId})")
    @SelectKey(statement="call identity()", keyProperty="weatherdataId", before=false, resultType=Long.class)
	void insertWeatherData(WeatherData weatherData);
	
	@Results({
        @Result(property = "weatherdataId", column = "weatherdata_id"),
      })
	@Select("select id, ts, pressure, temperature, altitude, description from weather_data")
    List<WeatherData> findAllWeatherData();
	
}
