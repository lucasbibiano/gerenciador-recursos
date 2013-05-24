package beans;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;

import pojo.ObjectResource;
import dal.concrete.mysql.ObjectResourceDAO;

@ManagedBean(name = "objectResourceBean")
@SessionScoped
public class ObjectResourceBean {
	
	private ObjectResource object;
	private List<ObjectResource> objects;
	
	private HtmlDataTable dataTable;
	
	private static ObjectResourceDAO dao;
	
	@PostConstruct
	public void init() {
		dao = ObjectResourceDAO.getInstance();
		setObjectResource(new ObjectResource());
	}

	public String addObjectResource() {			
		try {
			dao.create(object);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Novo recurso objeto cadastrado"));
			
			object = new ObjectResource();
			
			return "allobjectresources";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro no cadastro do recurso objeto"));
		
		object = new ObjectResource();
		
		return "newobjectresource";
	}

	public String editObjectResource() {
		object = (ObjectResource) dataTable.getRowData();
		
		return "editobjectresource";
	}
	
	public String deleteObjectResource() {
		object = (ObjectResource) dataTable.getRowData();
		
		try {
			dao.delete(object);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Recurso objeto deletado"));
			
			object = new ObjectResource();
			
			return "allobjectresources";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro ao apagar o recurso objeto"));
		
		object = new ObjectResource();
		
		return "allobjectresources";
	}
	
	public String updateObjectResource() {
		try {
			dao.update(object);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Recurso objeto atualizado"));
			
			object = new ObjectResource();
			
			return "allobjectresources";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro na edição do recurso objeto"));
		
		object = new ObjectResource();
		
		return "editobjectresource";
	}
	
	public String showObjectResource() {
		object = (ObjectResource) dataTable.getRowData();
		dao.loadRelationships(object);
				
		return "showobjectresource";
	}	

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	public ObjectResource getObjectResource() {
		return object;
	}

	public void setObjectResource(ObjectResource object) {
		this.object = object;
	}

	public List<ObjectResource> getObjectResources() {
		try {
			object = new ObjectResource();
			objects = dao.getAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		
		return objects;
	}
	
}
