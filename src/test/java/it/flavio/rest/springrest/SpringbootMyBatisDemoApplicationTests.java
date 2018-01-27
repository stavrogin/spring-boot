package it.flavio.rest.springrest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import it.flavio.springrest.database.table.DataSource;
import it.flavio.springrest.mybatis.mapper.DataSourceMapper;

public class SpringbootMyBatisDemoApplicationTests {

	@Autowired
    private DataSourceMapper dataSourceMapper;

    @Test
    public void findAllUsers() {
        List<DataSource> users = dataSourceMapper.findAllDataSources();
        Assert.assertNotNull(users);
        Assert.assertTrue(!users.isEmpty());
    }

    @Test
    public void createDataSource() {
        DataSource ds = new DataSource();
        ds.setName("RASPY");
        dataSourceMapper.insertDataSource(ds);
    }
    
}
