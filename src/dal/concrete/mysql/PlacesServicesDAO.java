package dal.concrete.mysql;

import dal._abstract.mysql.AbstractDAO;
import pojo.PlacesServices;

public class PlacesServicesDAO extends AbstractDAO<PlacesServices> {
	private static PlacesServicesDAO instance;

	public PlacesServicesDAO() {
		super(PlacesServices.class);
	}

	public static PlacesServicesDAO getInstance() {
		if (instance == null)
			instance = new PlacesServicesDAO();
		return instance;
	}
}
