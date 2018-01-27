package it.flavio.springrest;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * extends SpringBootServletInitializer and configure method: necesary to deploy on tomcat
 * @author flavio
 */
@SpringBootApplication
@MapperScan("it.flavio.springrest.mybatis.mapper")
public class Application extends SpringBootServletInitializer {
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
