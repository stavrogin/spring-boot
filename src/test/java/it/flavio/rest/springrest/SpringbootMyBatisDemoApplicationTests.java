package it.flavio.rest.springrest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.junit.After;
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
		
		weatherData = new WeatherData();
		weatherData.setAltitude(200D);
		weatherData.setPressure(1020D);
		weatherData.setTemperature(25D);
		weatherData.setDatasourceId((short) 1);
		LocalDateTime now = LocalDateTime.now().minusDays(1).truncatedTo(ChronoUnit.DAYS);
		weatherData.setTs(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()));
		weatherDataMapper.insertWeatherData(weatherData);
		
		weatherData = new WeatherData();
		weatherData.setAltitude(200D);
		weatherData.setPressure(1020D);
		weatherData.setTemperature(25D);
		weatherData.setDatasourceId((short) 1);
		now = LocalDateTime.now().minusMonths(1).truncatedTo(ChronoUnit.DAYS);
		weatherData.setTs(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()));
		weatherDataMapper.insertWeatherData(weatherData);
	}
	
	@After
	public void tearDown() {
		weatherDataMapper.truncateWeatherData();
	}
	
    @Test
    public void findAllWeatherData() {
    	List<WeatherData> weatherDataList = weatherDataMapper.findAllWeatherData();
    	assertNotNull(weatherDataList);
    	assertEquals(weatherDataList.size(), 3);
    	assertEquals((Double) weatherDataList.get(0).getAltitude(), (Double) 200D);
    }
    
    @Test
    public void findWeatherDataDaysBack() {
    	LocalDateTime now = LocalDateTime.now().minusDays(3).truncatedTo(ChronoUnit.DAYS);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String dateString = now.format(formatter);
		
    	List<WeatherData> weatherDataList = weatherDataMapper.findAllWeatherDataFromDate(dateString);
    	assertNotNull(weatherDataList);
    	assertEquals(weatherDataList.size(), 2);
    }

}
