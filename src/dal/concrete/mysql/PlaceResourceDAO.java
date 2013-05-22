package dal.concrete.mysql;

import java.sql.SQLException;

import pojo.PlaceResource;
import pojo.RoomType;

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
		
		RoomType type = new RoomType();
		type.name = "sala bolada";
		type.description = "uhfalshdfsadf";
		
		long typeID = 0;
		
		try {
			RoomTypeDAO.getInstance().create(type);
			typeID = RoomTypeDAO.getInstance().getAll().get(0).id;
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		PlaceResource hue = new PlaceResource();
		hue.name = "huehueheuhe";
		hue.description = "heuheuheu";
		hue.capacity = 42;
		hue.code = "heuheuheu";
		hue.length = 332;
		hue.width = 34432;
		hue.roomTypeID = typeID;
		
		try {
			dao.create(hue);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
	}
}
