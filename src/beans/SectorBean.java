package beans;

import java.io.Serializable;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import pojo.Sector;

import dal.concrete.mysql.SectorDAO;

@ManagedBean(name = "sectorBean")
@ViewScoped
public class SectorBean implements Serializable {

	private static final long serialVersionUID = 76888622285120538L;
	
	private String name;
	private String description;
	private long id;
	
	private static SectorDAO dao;
	
	@PostConstruct
	public void init() {
		dao = SectorDAO.getInstance();
	}

	public String addSector() {		
		Sector sector = new Sector();
		
		sector.setName(this.name);
		sector.setDescription(this.description);
		
		System.out.println("\n\n========================\n\n");
		System.out.println(this.name == null);
		System.out.println(this.description == null);
		System.out.println("\n\n========================\n\n");

		try {
			dao.create(sector);
			
			return null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
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
}
