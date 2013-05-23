package dal.concrete.mysql;

import dal._abstract.mysql.AbstractDAO;
import pojo.Function;

public class FunctionDAO extends AbstractDAO<Function>{

	private static FunctionDAO instance;

	public FunctionDAO() {
		super(Function.class);
	}

	public static FunctionDAO getInstance() {
		if (instance == null)
			instance = new FunctionDAO();
		return instance;
	}
}
