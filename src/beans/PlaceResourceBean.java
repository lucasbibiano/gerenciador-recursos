package beans;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;

import pojo.PlaceResource;
import dal.concrete.mysql.PlaceResourceDAO;

@ManagedBean(name = "placeResourceBean")
@SessionScoped
public class PlaceResourceBean {
	
	private PlaceResource place;
	private List<PlaceResource> places;
	
	private HtmlDataTable dataTable;
	
	private static PlaceResourceDAO dao;
	
	@PostConstruct
	public void init() {
		dao = PlaceResourceDAO.getInstance();
		setPlaceResource(new PlaceResource());
	}

	public String addPlaceResource() {			
		try {
			dao.create(place);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Novo recurso objeto cadastrado"));
			
			place = new PlaceResource();
			
			return "allplaceresources";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro no cadastro do recurso objeto"));
		
		place = new PlaceResource();
		
		return "newplaceresource";
	}

	public String editPlaceResource() {
		place = (PlaceResource) dataTable.getRowData();
		
		return "editplaceresource";
	}
	
	public String deletePlaceResource() {
		place = (PlaceResource) dataTable.getRowData();
		
		try {
			dao.delete(place);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Recurso objeto deletado"));
			
			place = new PlaceResource();
			
			return "allplaceresources";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro ao apagar o recurso objeto"));
		
		place = new PlaceResource();
		
		return "allplaceresources";
	}
	
	public String updatePlaceResource() {
		try {
			dao.update(place);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Recurso objeto atualizado"));
			
			place = new PlaceResource();
			
			return "allplaceresources";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro na edição do recurso objeto"));
		
		place = new PlaceResource();
		
		return "editplaceresource";
	}
	
	public String showPlaceResource() {
		place = (PlaceResource) dataTable.getRowData();
		dao.loadRelationships(place);
				
		return "showplaceresource";
	}	

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	public PlaceResource getPlaceResource() {
		return place;
	}

	public void setPlaceResource(PlaceResource place) {
		this.place = place;
	}

	public List<PlaceResource> getPlaceResources() {
		try {
			place = new PlaceResource();
			places = dao.getAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		
		return places;
	}
	
}
