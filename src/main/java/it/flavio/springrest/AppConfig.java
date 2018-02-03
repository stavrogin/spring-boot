package it.flavio.springrest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
	
	@Bean
    public WebMvcConfigurerAdapter forwardToIndex() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // forward requests to /admin and /user to their index.html
                registry.addViewController("/charts")
                		.setViewName("forward:chart.html");
            }
        };
    }
	
}
