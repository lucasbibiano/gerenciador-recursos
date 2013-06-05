package beans;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;

import pojo.User;
import utils.Utils;
import dal.concrete.mysql.UserDAO;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
	
	private List<User> users;
	private User user;
	
	private User currentUser;
	
	private UserDAO dao;
	
	private HtmlDataTable dataTable;

	@PostConstruct
	public void init() {
		dao = UserDAO.getInstance();		
		setUser(new User());
		User u = new User();
		u.cpf = "true";
		
		setCurrentUser(u);
	}
	
	public void login() {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("login", currentUser.login);
		
		List<User> result = null;
		
		try {
			result = dao.getByAttributes(params);
			
			if (result == null || result.isEmpty())
				return;
			
			if (result.get(0).password.equals(Utils.MungPass(currentUser.password)))
				currentUser = result.get(0);
			else {
				currentUser = new User();
				currentUser.cpf = "true";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String logout() {
		currentUser = new User();
		currentUser.cpf = "true";
		
		return "/home/index.html";
	}
	
	public String addUser() {			
		try {
			user.password = Utils.MungPass(user.password);
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
			dao.deleteByPk(user);
			
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
			user.password = Utils.MungPass(user.password);
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

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
