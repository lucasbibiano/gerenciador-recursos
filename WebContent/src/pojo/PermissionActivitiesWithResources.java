package pojo;

import dal.annotations.Column;
import dal.annotations.ForeignKey;
import dal.annotations.Polymorphic;
import dal.annotations.Storeable;

@Storeable(tableName = "Permission_Activities_with_Resources")
public class PermissionActivitiesWithResources {
	
	@Column(columnName = "permissionID", pk = true)
	public long permissionID;
	@ForeignKey(thisSideAttrs = {"permissionID"}, otherSideAttrs = {"id"})
	public Permission permission;
	
	@Column(columnName = "activityID", pk = true)
	public long activityID;
	@ForeignKey(thisSideAttrs = {"activityID"}, otherSideAttrs = {"id"})
	public Activity actitivity;
	
	@Column(columnName = "resourceID", pk = true)
	public long resourceID;
	@Column(columnName = "resourceType")
	public String resourceType;
	@Polymorphic(tableAttr = "resourceType", fk = @ForeignKey(thisSideAttrs = {"resourceID"},
		otherSideAttrs = {"id"}))
	public Resource resource;
}
