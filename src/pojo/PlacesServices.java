package pojo;

import dal.annotations.Column;
import dal.annotations.ForeignKey;
import dal.annotations.Storeable;

@Storeable(tableName = "Places_Services")
public class PlacesServices {
	
	@Column(columnName = "placeID", pk = true)
	public long placeID;
	@ForeignKey(thisSideAttrs = {"placeID"}, otherSideAttrs = {"id"})
	public PlaceResource place;
	
	@Column(columnName = "serviceID", pk = true)
	public long serviceID;
	@ForeignKey(thisSideAttrs = {"serviceID"}, otherSideAttrs = {"id"})
	public ServiceResource service;
}
