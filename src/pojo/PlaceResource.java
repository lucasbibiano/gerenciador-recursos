package pojo;

import java.util.List;

import dal.annotations.Column;
import dal.annotations.ForeignKey;
import dal.annotations.ManyToMany;
import dal.annotations.Storeable;

@Storeable(tableName = "Places")
public class PlaceResource implements Resource {
	
	@Column(columnName = "id", pk = true)
	public long id;
	
	@Column(columnName = "code")
	public String code;
	
	@Column(columnName = "name")
	public String name;
	
	@Column(columnName = "description")
	public String description;
	
	@Column(columnName = "length")
	public int length;
	
	@Column(columnName = "width")
	public int width;
	
	@Column(columnName = "capacity")
	public int capacity;
	
	@Column(columnName = "roomTypeID")
	public long roomTypeID;
	@ForeignKey(thisSideAttrs = {"roomTypeID"}, otherSideAttrs = {"id"})
	public RoomType roomType;
	
	@ManyToMany(onTable = "Places_Services", otherClass = ServiceResource.class,
		thisPK = {"id"}, thisPKOtherSide = {"placeID"}, otherPK = {"id"}, otherPKOtherSide = {"serviceID"})
	public List<ServiceResource> services;
		
	public List<ServiceResource> getServices() {
		return services;
	}

	public String getFullName() {
		return name + " " + code;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public long getRoomTypeID() {
		return roomTypeID;
	}

	public void setRoomTypeID(long roomTypeID) {
		this.roomTypeID = roomTypeID;
	}

	public RoomType getRoomType() {
		return roomType;
	}
}
