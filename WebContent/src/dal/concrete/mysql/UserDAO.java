package dal.concrete.mysql;

import java.sql.SQLException;
import java.util.List;

import dal._abstract.mysql.AbstractDAO;

import pojo.User;

public class UserDAO extends AbstractDAO<User>{

	private static UserDAO instance;
	
	public UserDAO() {
		super(User.class);
	}
	
	public static synchronized UserDAO getInstance() {
		if (instance == null)
			instance = new UserDAO();
		return instance;
	}

	public static void main(String[] args) {
		UserDAO dao = UserDAO.getInstance();
		
		try {
			List<User> users = dao.getAll();
			
			for (User user: users) {
				dao.loadRelationships(user);
				System.out.println(user.getCpf() + " Sector: " + user.getSector());
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
}
