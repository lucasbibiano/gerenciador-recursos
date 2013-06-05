package dal.concrete.mysql;

import pojo.ObjectResource;
import dal._abstract.mysql.AbstractDAO;

public class ObjectResourceDAO extends AbstractDAO<ObjectResource> {
	private static ObjectResourceDAO instance;

	public ObjectResourceDAO() {
		super(ObjectResource.class);
	}

	public static ObjectResourceDAO getInstance() {
		if (instance == null)
			instance = new ObjectResourceDAO();
		return instance;
	}
}


