package pojo;

import dal.annotations.Column;
import dal.annotations.Storeable;

@Storeable(tableName = "Activities")
public class Activity {
	@Column(columnName = "id")
	public long id;
	
	@Column(columnName = "name")
	public String name;
}
