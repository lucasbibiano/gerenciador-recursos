package dal.concrete.mysql;

import pojo.RoomType;

public class RoomTypeDAO extends AbstractDAO<RoomType> {
	private static RoomTypeDAO instance;

	public RoomTypeDAO() {
		super(RoomType.class);
	}

	public static RoomTypeDAO getInstance() {
		if (instance == null)
			instance = new RoomTypeDAO();
		return instance;
	}
}
