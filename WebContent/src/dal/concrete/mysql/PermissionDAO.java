package dal.concrete.mysql;

import pojo.Permission;
import dal._abstract.mysql.AbstractDAO;

public class PermissionDAO extends AbstractDAO<Permission> {
	private static PermissionDAO instance;

	public PermissionDAO() {
		super(Permission.class);
	}

	public static PermissionDAO getInstance() {
		if (instance == null)
			instance = new PermissionDAO();
		return instance;
	}
}
