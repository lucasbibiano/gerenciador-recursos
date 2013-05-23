package beans;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;

import pojo.User;
import dal.concrete.mysql.UserDAO;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
	
	private List<User> users;
	private User user;
	
	private UserDAO dao;
	
	private HtmlDataTable dataTable;

	@PostConstruct
	public void init() {
		dao = UserDAO.getInstance();		
		setUser(new User());
	}
	
	public String addUser() {			
		try {
			dao.create(user);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Usuário cadastrado"));
			
			user = new User();
			
			return "allusers";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro no cadastro do usuário"));
		
		user = new User();
		
		return "newuser";
	}

	public String editUser() {
		user = (User) dataTable.getRowData();
		
		return "edituser";
	}
	
	public String deleteUser() {
		user = (User) dataTable.getRowData();
		
		try {
			dao.delete(user);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Usuário deletado"));
			
			user = new User();
			
			return "allusers";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro ao apagar o usuário"));
		
		user = new User();
		
		return "allusers";
	}
	
	public String updateUser() {
		try {
			dao.update(user);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Usuário atualizado"));
			
			user = new User();
			
			return "allusers";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro na edição do usuário"));
		
		user = new User();
		
		return "edituser";
	}
	
	public String showUser() {
		user = (User) dataTable.getRowData();
		dao.loadRelationships(user);
		
		return "showuser";
	}	


	public List<User> getUsers() {
		try {
			user = new User();
			users = dao.getAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
}
