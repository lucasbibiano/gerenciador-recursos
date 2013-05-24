package beans;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;

import pojo.ServiceResource;
import dal.concrete.mysql.ServiceResourceDAO;

@ManagedBean(name = "serviceResourceBean")
@SessionScoped
public class ServiceResourceBean {
	
	private ServiceResource serviceResource;
	private List<ServiceResource> serviceResources;
	
	private HtmlDataTable dataTable;
	
	private static ServiceResourceDAO dao;
	
	@PostConstruct
	public void init() {
		dao = ServiceResourceDAO.getInstance();
		setServiceResource(new ServiceResource());
	}

	public String addServiceResource() {			
		try {
			dao.create(serviceResource);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Novo tipo de sala cadastrado"));
			
			serviceResource = new ServiceResource();
			
			return "allserviceresources";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro no cadastro do tipo de sala"));
		
		serviceResource = new ServiceResource();
		
		return "newserviceresource";
	}

	public String editServiceResource() {
		serviceResource = (ServiceResource) dataTable.getRowData();
		
		return "editserviceresource";
	}
	
	public String deleteServiceResource() {
		serviceResource = (ServiceResource) dataTable.getRowData();
		
		try {
			dao.delete(serviceResource);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Tipo de sala deletado"));
			
			serviceResource = new ServiceResource();
			
			return "allserviceResources";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro ao apagar o tipo de sala"));
		
		serviceResource = new ServiceResource();
		
		return "allserviceresources";
	}
	
	public String updateServiceResource() {
		try {
			dao.update(serviceResource);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Tipo de sala atualizado"));
			
			serviceResource = new ServiceResource();
			
			return "allserviceresources";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro na edição do tipo de sala"));
		
		serviceResource = new ServiceResource();
		
		return "editserviceresource";
	}
	
	public String showServiceResource() {
		serviceResource = (ServiceResource) dataTable.getRowData();
		dao.loadRelationships(serviceResource);
				
		return "showserviceresource";
	}	

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	public ServiceResource getServiceResource() {
		return serviceResource;
	}

	public void setServiceResource(ServiceResource serviceResource) {
		this.serviceResource = serviceResource;
	}

	public List<ServiceResource> getServiceResources() {
		try {
			serviceResource = new ServiceResource();
			serviceResources = dao.getAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		
		return serviceResources;
	}
	
}
