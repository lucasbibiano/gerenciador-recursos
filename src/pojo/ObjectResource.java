package pojo;

import dal.annotations.Column;
import dal.annotations.ForeignKey;
import dal.annotations.Storeable;

@Storeable(tableName = "Objects")
public class ObjectResource implements Resource {
	
	@Column(columnName = "id", pk = true)
	public long id;
	
	@Column(columnName = "tomb")
	public String tombamento;
	
	@Column(columnName = "name")
	public String name;
	
	@Column(columnName = "description")
	public String description;
	
	@Column(columnName = "placeID")
	public long allocatedAtID;
	@ForeignKey(thisSideAttrs = {"allocatedAtID"}, otherSideAttrs = {"id"})
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
	public long getAllocatedAtID() {
		return allocatedAtID;
	}
	public void setAllocatedAtID(long allocatedAtID) {
		this.allocatedAtID = allocatedAtID;
	}
	public PlaceResource getAllocatedAt() {
		return allocatedAt;
	}
	
	@Override
	public String getType() {
		return "Objects";
	}
}
