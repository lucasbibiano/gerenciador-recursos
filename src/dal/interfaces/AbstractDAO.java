package dal.interfaces;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import pojo.Sector;

import dal.annotations.Column;
import dal.annotations.Storeable;
import dal.connection.ConnectionManager;

public class AbstractDAO<T> {

	private Class<?> className;
	
	public AbstractDAO(Class<?> klass) {
		className = klass;
	}
	
	private String createStringToAdd(T object) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("(");
		
		String prefix = "";
		for (Field field: className.getDeclaredFields()) {			
			Column col = field.getAnnotation(Column.class);
			
			if (col != null) {
				try {
					builder.append(prefix);
					prefix = ", ";
					field.setAccessible(true);
					Object obj = field.get(object);
					field.setAccessible(false);
					builder.append(obj.toString());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		builder.append(")");
		
		return builder.toString();
	}
	
	public String getTableName() {
		return className.getAnnotation(Storeable.class).tableName();
	}
	
	public void create(T object) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionManager.getConnection();
		
		Statement statement = null;
        int updateQuery = 0;
        
        statement = conn.createStatement();
        
        String QueryString = "Insert into table " + getTableName() + " values " + createStringToAdd(object);
        
        updateQuery = statement.executeUpdate(QueryString);
        
        if (updateQuery != 0) {
        	System.out.println("Hue");
        }
	}

	public T getByID(int id) {
		return null;
	}

	public List<T> getAll() {
		return null;
	}

	public void update(T object) {

	}

	public void delete(T object) {

	}
	
	public static void main(String[] args) {
		AbstractDAO<Sector> abdao = new AbstractDAO<Sector>(Sector.class);
		Sector sector = new Sector();
		sector.setName("huaehuaheuae");
		sector.setDescription("tl;dr");
		
		
		System.out.println(abdao.createStringToAdd(sector));
	}
}

