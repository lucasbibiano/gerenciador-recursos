package pojo;

import java.util.List;

import dal.annotations.Column;
import dal.annotations.DBCollection;
import dal.annotations.Storeable;

@Storeable(tableName = "RoomTypes")
public class RoomType {
	
	@Column(pk = true, autoGenerated = true, columnName = "id")
	public int id;
	
	@Column(columnName = "name")
	public String name;
	
	@Column(columnName = "description")
	public String description;
	
	@DBCollection(klass = PlaceResource.class, thisPk = {"id"}, fk = "roomTypeID")
	public List<PlaceResource> roomsWithThatType;

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

	public List<PlaceResource> getRoomsWithThatType() {
		return roomsWithThatType;
	}

	
}
