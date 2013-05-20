package beans;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;

import pojo.Sector;

import dal.concrete.mysql.SectorDAO;

@ManagedBean(name = "sectorBean")
@SessionScoped
public class SectorBean {
	
	private HtmlDataTable dataTable;
	
	private Sector sector;
	private List<Sector> sectors;
	
	private static SectorDAO dao;
	
	@PostConstruct
	public void init() {
		dao = SectorDAO.getInstance();
		sector = new Sector();
	}

	public String addSector() {			
		try {
			dao.create(sector);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Setor cadastrado"));
			
			sector = new Sector();
			
			return "allsectors";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro no cadastro do setor"));
		
		sector = new Sector();
		
		return "newsector";
	}

	public String editSector() {
		sector = (Sector) dataTable.getRowData();
		
		return "editsector";
	}
	
	public String deleteSector() {
		sector = (Sector) dataTable.getRowData();
		
		try {
			dao.delete(sector);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Setor deletado"));
			
			sector = new Sector();
			
			return "allsectors";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro ao apagar o setor"));
		
		sector = new Sector();
		
		return "allsectors";
	}
	
	public String updateSector() {
		try {
			dao.update(sector);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Setor atualizado"));
			
			sector = new Sector();
			
			return "allsectors";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro na edição do setor"));
		
		sector = new Sector();
		
		return "editsector";
	}
	
	public void getAllSectors() {

	}
	
	public void searchSectorsByName() {
		
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public List<Sector> getSectors() {
		try {
			sectors = dao.getAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		
		return sectors;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
}
