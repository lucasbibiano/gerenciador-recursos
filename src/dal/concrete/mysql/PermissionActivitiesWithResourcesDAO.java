package dal.concrete.mysql;

import pojo.PermissionActivitiesWithResources;
import dal._abstract.mysql.AbstractDAO;

public class PermissionActivitiesWithResourcesDAO extends AbstractDAO<PermissionActivitiesWithResources> {
	private static PermissionActivitiesWithResourcesDAO instance;

	public PermissionActivitiesWithResourcesDAO() {
		super(PermissionActivitiesWithResources.class);
	}

	public static PermissionActivitiesWithResourcesDAO getInstance() {
		if (instance == null)
			instance = new PermissionActivitiesWithResourcesDAO();
		return instance;
	}
}


