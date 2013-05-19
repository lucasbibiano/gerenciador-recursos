package dal.concrete.mysql;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import pojo.Sector;

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
}
