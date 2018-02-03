package it.flavio.rest.springrest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import it.flavio.springrest.Application;
import it.flavio.springrest.database.table.WeatherData;
import it.flavio.springrest.mybatis.mapper.WeatherDataMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=Application.class)
public class SpringbootMyBatisDemoApplicationTests {

	@Autowired
    private WeatherDataMapper weatherDataMapper;
	
	@Before
	public void setUp() {
		WeatherData weatherData = new WeatherData();
		weatherData.setAltitude(200D);
		weatherData.setPressure(1020D);
		weatherData.setTemperature(25D);
		weatherData.setDatasourceId((short) 1);
		weatherData.setTs(new Date());
		
		weatherDataMapper.insertWeatherData(weatherData);
	}
	
    @Test
    public void findAllWeatherData() {
    	List<WeatherData> weatherDataList = weatherDataMapper.findAllWeatherData();
    	assertNotNull(weatherDataList);
    	assertEquals(weatherDataList.size(), 1);
    	assertEquals((Double) weatherDataList.get(0).getAltitude(), (Double) 200D);
    }

}
