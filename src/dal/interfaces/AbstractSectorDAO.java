package dal.interfaces;

import java.util.List;

import pojo.Sector;

public abstract class AbstractSectorDAO extends AbstractDAO<Sector> {
	
	public AbstractSectorDAO() {
		super(Sector.class);
	}
	
	public abstract List<Sector> searchByName();
}
