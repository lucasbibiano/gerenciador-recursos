package beans;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;

import pojo.RoomType;
import dal.concrete.mysql.RoomTypeDAO;

@ManagedBean(name = "roomTypeBean")
@SessionScoped
public class RoomTypeBean {
	
	private RoomType roomType;
	private List<RoomType> roomTypes;
	
	private HtmlDataTable dataTable;
	
	private static RoomTypeDAO dao;
	
	@PostConstruct
	public void init() {
		dao = RoomTypeDAO.getInstance();
		setRoomType(new RoomType());
	}

	public String addRoomType() {			
		try {
			dao.create(roomType);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Novo tipo de sala cadastrado"));
			
			roomType = new RoomType();
			
			return "allroomtypes";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro no cadastro do tipo de sala"));
		
		roomType = new RoomType();
		
		return "newroomtype";
	}

	public String editRoomType() {
		roomType = (RoomType) dataTable.getRowData();
		
		return "editroomtype";
	}
	
	public String deleteRoomType() {
		roomType = (RoomType) dataTable.getRowData();
		
		try {
			dao.delete(roomType);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Tipo de sala deletado"));
			
			roomType = new RoomType();
			
			return "allroomTypes";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro ao apagar o tipo de sala"));
		
		roomType = new RoomType();
		
		return "allroomtypes";
	}
	
	public String updateRoomType() {
		try {
			dao.update(roomType);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Tipo de sala atualizado"));
			
			roomType = new RoomType();
			
			return "allroomtypes";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro na edição do tipo de sala"));
		
		roomType = new RoomType();
		
		return "editroomtype";
	}
	
	public String showRoomType() {
		roomType = (RoomType) dataTable.getRowData();
		dao.loadRelationships(roomType);
				
		return "showroomtype";
	}	

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public List<RoomType> getRoomTypes() {
		try {
			roomType = new RoomType();
			roomTypes = dao.getAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		
		return roomTypes;
	}
	
}
