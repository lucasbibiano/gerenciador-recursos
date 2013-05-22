package dal.concrete.mysql;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import pojo.Reservation;

public class ReservationDAO extends AbstractDAO<Reservation>{

	private static ReservationDAO instance;

	public ReservationDAO() {
		super(Reservation.class);
	}

	public static ReservationDAO getInstance() {
		if (instance == null)
			instance = new ReservationDAO();
		return instance;
	}
}
