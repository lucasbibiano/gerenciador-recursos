package dal.concrete.mysql;

import dal._abstract.mysql.AbstractDAO;
import pojo.Resource;

public class ResourceDAO extends AbstractDAO<Resource> {
	private static ResourceDAO instance;

	public ResourceDAO() {
		super(Resource.class);
	}

	public static ResourceDAO getInstance() {
		if (instance == null)
			instance = new ResourceDAO();
		return instance;
	}
}
