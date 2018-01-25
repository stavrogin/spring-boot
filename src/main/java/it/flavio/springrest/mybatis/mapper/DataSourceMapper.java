package it.flavio.springrest.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import it.flavio.springrest.database.model.DataSource;

public interface DataSourceMapper {
	
	@Insert("insert into data_source(name) values(#{name})")
    @SelectKey(statement="call identity()", keyProperty="datasourceId", before=false, resultType=Short.class)
	void insertDataSource(DataSource dataSource);
	
	@Results({
        @Result(property = "datasourceId", column = "datasource_id"),
        @Result(property = "name", column = "name")
      })
	@Select("select datasource_id, name from data_source")
    List<DataSource> findAllDataSources();
	
}
