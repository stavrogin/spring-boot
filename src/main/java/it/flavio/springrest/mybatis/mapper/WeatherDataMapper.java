package it.flavio.springrest.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import it.flavio.springrest.database.table.WeatherData;

public interface WeatherDataMapper {
	
	@Insert("insert into "
			+ "weather_data(ts, pressure, temperature, altitude, description, datasource_id) "
			+ "values(#{ts}, #{pressure}, #{temperature}, #{altitude}, #{description}, #{datasourceId})"
	)
    @SelectKey(statement="call scope_identity()", keyProperty="weatherdataId", keyColumn="weatherdata_id", before=false, resultType=Long.class)
	void insertWeatherData(WeatherData weatherData);
	
	@Results({
        @Result(property = "weatherdataId", column = "weatherdata_id"),
        @Result(property = "datasourceId", column = "datasource_id")
      })
	@Select("select weatherdata_id, ts, pressure, temperature, altitude, description, datasource_id "
			+ "from weather_data")
    List<WeatherData> findAllWeatherData();
	
	@Results({
        @Result(property = "weatherdataId", column = "weatherdata_id"),
        @Result(property = "datasourceId", column = "datasource_id")
      })
	@Select("select weatherdata_id, ts, pressure, temperature, altitude, description, datasource_id "
			+ "from weather_data "
			+ "where ts > #{dateFrom}")
    List<WeatherData> findAllWeatherDataFromDate(@Param("dateFrom") String dateFrom);
	
	@Delete("delete from weather_data where weatherdata_id = #{weatherdataId}")
	void deleteWeatherData(Long weatherdataId);
	
	@Delete("truncate table weather_data")
	void truncateWeatherData();
	
}
