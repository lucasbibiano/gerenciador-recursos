package dal.concrete.mysql;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import pojo.Sector;
import pojo.User;

public class SectorDAO extends AbstractDAO<Sector> {

	private static SectorDAO instance;
	
	public static synchronized SectorDAO getInstance() {
		if (instance == null)
			instance = new SectorDAO();
		return instance;
	}
	
	private SectorDAO() {
		super(Sector.class);
	}
	
	public List<Sector> searchByName(String name) {
		HashMap<String, Object> attrs = new HashMap<String, Object>();
		attrs.put("name", name);
		
		try {
			return this.getByAttributes(attrs);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		SectorDAO dao = SectorDAO.getInstance();
		
		try {
			List<Sector> sectors = dao.getAll();
			
			for (Sector sector: sectors) {
				dao.loadRelationships(sector);
				System.out.println(sector.getName());

				List<User> users = sector.getUsers(); 
				
				for (User user: users) {
					System.out.println("\t-" + user.getName());
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
