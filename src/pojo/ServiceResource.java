package pojo;

import dal.annotations.Column;
import dal.annotations.Storeable;

@Storeable(tableName = "Services")
public class ServiceResource extends Resource {
	
	@Column(pk = true, autoGenerated = true, columnName = "id")
	public int id;
	
	@Column(columnName = "name")
	public String name;
	
	@Column(columnName = "description")
	public String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
