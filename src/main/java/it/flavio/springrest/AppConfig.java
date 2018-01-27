package it.flavio.springrest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.flavio.springrest.manager.WeatherDataManager;
import it.flavio.springrest.manager.WeatherDataManagerImpl;
import it.flavio.springtest.dao.WeatherDataDAO;
import it.flavio.springtest.dao.WeatherDataDAOImpl;

@Configuration
public class AppConfig {

	@Bean
    public WeatherDataDAO weatherDataDAO() {
        return new WeatherDataDAOImpl();
    }
	
	@Bean
    public WeatherDataManager weatherDataManager() {
        return new WeatherDataManagerImpl();
    }
	
}
