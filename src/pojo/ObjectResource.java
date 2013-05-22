package pojo;

import dal.annotations.Column;
import dal.annotations.ForeignKey;
import dal.annotations.Storeable;

@Storeable(tableName = "Objects")
public class ObjectResource extends Resource {
	
	@Column(columnName = "id", pk = true)
	public long id;
	
	@Column(columnName = "tomb")
	public String tombamento;
	
	@Column(columnName = "name")
	public String name;
	
	@Column(columnName = "description")
	public String description;
	
	@Column(columnName = "placeCode")
	public String allocatedAtCode;
	@ForeignKey(thisSideAttrs = {"tombamento"}, otherSideAttrs = {"code"})
	public PlaceResource allocatedAt;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTombamento() {
		return tombamento;
	}
	public void setTombamento(String tombamento) {
		this.tombamento = tombamento;
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
	public String getAllocatedAtCode() {
		return allocatedAtCode;
	}
	public void setAllocatedAtCode(String allocatedAtCode) {
		this.allocatedAtCode = allocatedAtCode;
	}
	public PlaceResource getAllocatedAt() {
		return allocatedAt;
	}	
}
