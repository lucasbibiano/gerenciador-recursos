package pojo;

import dal.annotations.Column;
import dal.annotations.ForeignKey;
import dal.annotations.Storeable;

@Storeable(tableName = "Reservations_Objects")
public class ReservationObject {

	@Column(pk = true, columnName = "objectID")
	public long objectID;
	@ForeignKey(thisSideAttrs = {"objectID"}, otherSideAttrs = {"id"})
	public ObjectResource object;
	
	@Column(pk = true, columnName = "reservationID")
	public long reservationID;
	@ForeignKey(thisSideAttrs = {"reservationID"}, otherSideAttrs = {"id"})
	public Reservation reservation;
}
