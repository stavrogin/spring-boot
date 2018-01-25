package it.flavio.springrest.database.model;

/**
 * DB model class representing DATA_SOURCE table
 * @author flavio
 */
public class DataSource {

	private Short datasourceId;
	private String name;
	
	public Short getDatasourceId() {
		return datasourceId;
	}
	public void setDatasourceId(Short datasourceId) {
		this.datasourceId = datasourceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
