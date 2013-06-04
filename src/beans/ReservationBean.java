package beans;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;

import dal.concrete.mysql.ReservationDAO;
import dal.concrete.mysql.ReservationResourceDAO;

import pojo.Reservation;
import pojo.ReservationResource;

@ManagedBean(name = "reservationBean")
@SessionScoped
public class ReservationBean {
	private Reservation reservation;
	private ReservationResource reservationResource;
	
	private List<Reservation> reservations;
	private List<ReservationResource> reservationsResources;
	
	private HtmlDataTable dataTable;
	
	private ReservationDAO reservationDAO = ReservationDAO.getInstance();
	private ReservationResourceDAO reservationResourceDAO = ReservationResourceDAO.getInstance();

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public List<ReservationResource> getReservationsResources() {
		return reservationsResources;
	}

	public void setReservationsResources(List<ReservationResource> reservationsResources) {
		this.reservationsResources = reservationsResources;
	}

	public List<Reservation> getReservations() {
		try {
			reservation = new Reservation();
			reservations = reservationDAO.getAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return reservations;	
	}

	public ReservationResource getReservationResource() {
		return reservationResource;
	}

	public void setReservationResource(ReservationResource reservationResource) {
		this.reservationResource = reservationResource;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
}
