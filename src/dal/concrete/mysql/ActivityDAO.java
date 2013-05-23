package dal.concrete.mysql;

import pojo.Activity;
import dal._abstract.mysql.AbstractDAO;

public class ActivityDAO extends AbstractDAO<Activity> {
	private static ActivityDAO instance;

	public ActivityDAO() {
		super(Activity.class);
	}

	public static ActivityDAO getInstance() {
		if (instance == null)
			instance = new ActivityDAO();
		return instance;
	}
}


