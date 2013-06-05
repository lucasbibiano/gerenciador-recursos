package dal.concrete.mysql;

import dal._abstract.mysql.AbstractDAO;
import pojo.ReservationResource;

public class ReservationResourceDAO extends AbstractDAO<ReservationResource> {
	private static ReservationResourceDAO instance;

	public ReservationResourceDAO() {
		super(ReservationResource.class);
	}

	public static ReservationResourceDAO getInstance() {
		if (instance == null)
			instance = new ReservationResourceDAO();
		return instance;
	}
}
