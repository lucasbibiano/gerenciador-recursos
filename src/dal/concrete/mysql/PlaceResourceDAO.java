package dal.concrete.mysql;

import java.sql.SQLException;

import pojo.PlaceResource;

public class PlaceResourceDAO extends AbstractDAO<PlaceResource> {
	private static PlaceResourceDAO instance;

	public PlaceResourceDAO() {
		super(PlaceResource.class);
	}

	public static PlaceResourceDAO getInstance() {
		if (instance == null)
			instance = new PlaceResourceDAO();
		return instance;
	}
	
	public static void main(String[] args) {
		PlaceResourceDAO dao = PlaceResourceDAO.getInstance();
		
		PlaceResource hue = new PlaceResource();
		hue.name = "huehueheuhe";
		hue.description = "heuheuheu";
		hue.capacity = 42;
		hue.code = "heuheuheu";
		hue.length = 332;
		hue.width = 34432;
		hue.reservable = true;

		
		try {
			dao.create(hue);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
	}
}
