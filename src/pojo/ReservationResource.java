package pojo;

import dal.annotations.Column;
import dal.annotations.ForeignKey;
import dal.annotations.Polymorphic;
import dal.annotations.Storeable;

@Storeable(tableName = "Reservations_Resources")
public class ReservationResource {

	@Column(pk = true, columnName = "resourceID")
	public long resourceID;
	@Column(columnName = "resourceType")
	public String resourceType;
	@Polymorphic(tableAttr = "resourceType", fk = @ForeignKey(thisSideAttrs = {"resourceID"},
		otherSideAttrs = {"id"}))
	public Resource resource;
	
	@Column(pk = true, columnName = "reservationID")
	public long reservationID;
	@ForeignKey(thisSideAttrs = {"reservationID"}, otherSideAttrs = {"id"})
	public Reservation reservation;
}
