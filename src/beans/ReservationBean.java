package beans;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;

import dal.concrete.mysql.ReservationDAO;
import dal.concrete.mysql.ReservationObjectDAO;
import dal.concrete.mysql.UserDAO;

import pojo.PlaceResource;
import pojo.Reservation;
import pojo.ReservationObject;
import pojo.User;

@ManagedBean(name = "reservationBean")
@SessionScoped
public class ReservationBean {
	private Reservation reservation;
	private ReservationObject reservationResource;
	
	private List<Reservation> reservations;
	private List<ReservationObject> reservationsResources;
		
	private long roomID;
	private List<Long> objectsIDs;
	
	private HtmlDataTable dataTable;
	
	private String beginTime;
	private String endTime;
	
	private ReservationDAO reservationDAO = ReservationDAO.getInstance();
	private ReservationObjectDAO reservationResourceDAO = ReservationObjectDAO.getInstance();

	@ManagedProperty(value="#{userBean}")
    private UserBean userBean;

	@PostConstruct
	public void init() {
		setReservation(new Reservation());
	}
	
	public String reserve() {
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String formattedDate = sdf.format(date);
			
			reservation.solicitationTime = Timestamp.valueOf(formattedDate);
			reservation.userCpf = userBean.getCurrentUser().cpf;
			reservation.beginTime = Timestamp.valueOf(beginTime);
			reservation.endTime = Timestamp.valueOf(endTime);
			reservation.approved = false;
			reservation.pendingApproval = true;
			reservation.placeID = roomID;
			
			reservation.id = reservationDAO.create(reservation);
			
			for (Long i: objectsIDs) {
				ReservationObject relation = new ReservationObject();
				relation.reservationID = reservation.id;
				relation.objectID = i;
				
				reservationResourceDAO.create(relation);
			}
		} catch (ClassNotFoundException | SQLException e) {
			reservation = new Reservation();
			e.printStackTrace();
		}
		
		return "allreservations";
	}
	
	public String approveReservation() {
		try {
			reservation = (Reservation) dataTable.getRowData();
			reservation.approved = true;
			reservation.pendingApproval = false;
		
			reservationDAO.update(reservation);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return "allreservations";
	}
	
	public String disapproveReservation() {
		try {
			reservation = (Reservation) dataTable.getRowData();
			reservation.approved = false;
			reservation.pendingApproval = false;
		
			reservationDAO.update(reservation);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return "allreservations";
	}
	
	public String cancelDecision() {
		try {
			reservation = (Reservation) dataTable.getRowData();
			reservation.pendingApproval = true;
		
			reservationDAO.update(reservation);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return "allreservations";
	}
	
	public String showReservation() {
		reservation = (Reservation) dataTable.getRowData();
		reservationDAO.loadRelationships(reservation);
				
		return "showreservation";
	}	
	
	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public List<ReservationObject> getReservationsResources() {
		return reservationsResources;
	}

	public void setReservationsResources(List<ReservationObject> reservationsResources) {
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

	public ReservationObject getReservationResource() {
		return reservationResource;
	}

	public void setReservationResource(ReservationObject reservationResource) {
		this.reservationResource = reservationResource;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public long getRoomID() {
		return roomID;
	}

	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}

	public List<Long> getObjectsIDs() {
		return objectsIDs;
	}

	public void setObjectsIDs(List<Long> objectsIDs) {
		this.objectsIDs = objectsIDs;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
