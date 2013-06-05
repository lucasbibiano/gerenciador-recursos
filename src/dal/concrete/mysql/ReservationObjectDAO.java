package dal.concrete.mysql;

import dal._abstract.mysql.AbstractDAO;
import pojo.ReservationObject;

public class ReservationObjectDAO extends AbstractDAO<ReservationObject> {
	private static ReservationObjectDAO instance;

	public ReservationObjectDAO() {
		super(ReservationObject.class);
	}

	public static ReservationObjectDAO getInstance() {
		if (instance == null)
			instance = new ReservationObjectDAO();
		return instance;
	}
}
