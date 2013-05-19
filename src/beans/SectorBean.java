package beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import pojo.Sector;

import dal.concrete.mysql.SectorDAO;

@ManagedBean(name = "sectorBean")
@ViewScoped
public class SectorBean implements Serializable {

	private static final long serialVersionUID = 76888622285120538L;
	
	private String name;
	private String description;
	private long id;
	private List<Sector> sectors;
	
	private static SectorDAO dao;
	
	@PostConstruct
	public void init() {
		dao = SectorDAO.getInstance();
	}

	public String addSector() {		
		Sector sector = new Sector();
		
		sector.setName(this.name);
		sector.setDescription(this.description);

		try {
			dao.create(sector);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Setor cadastrado"));
			
			return "allsectors";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro no cadastro do setor"));
		
		return "newsector";
	}

	public void removeSector() {
		
	}
	
	public void editSector() {
	}
	
	public void getAllSectors() {

	}
	
	public void searchSectorsByName() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Sector> getSectors() {
		try {
			sectors = dao.getAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		
		return sectors;
	}
}
