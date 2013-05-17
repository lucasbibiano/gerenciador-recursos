package pojo;

import dal.annotations.Storeable;
import dal.annotations.Column;

@Storeable(tableName = "Sector")
public class Sector extends AbstractModel {
	
	@Column(columnName = "name")
	private String name;
	
	@Column(columnName = "description")
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
