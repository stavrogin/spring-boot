package it.flavio.springrest.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.flavio.springrest.database.model.DataSource;
import it.flavio.springrest.model.Greeting;
import it.flavio.springrest.mybatis.mapper.DataSourceMapper;

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
    private DataSourceMapper dataSourceMapper;

	@RequestMapping(value="/greeting",method=RequestMethod.GET)
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		List<DataSource> dataSources = dataSourceMapper.findAllDataSources();
		dataSources.forEach(d -> System.out.println(d.getDatasourceId() + " - " + d.getName()));
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
}
