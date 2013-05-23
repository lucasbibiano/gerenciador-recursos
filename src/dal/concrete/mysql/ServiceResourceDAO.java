package dal.concrete.mysql;

import dal._abstract.mysql.AbstractDAO;
import pojo.ServiceResource;

public class ServiceResourceDAO extends AbstractDAO<ServiceResource> {

	private static ServiceResourceDAO instance;

	public ServiceResourceDAO() {
		super(ServiceResource.class);
	}
	
	public static ServiceResourceDAO getInstance() {
		if (instance == null)
			instance = new ServiceResourceDAO();
		return instance;
	}
}
