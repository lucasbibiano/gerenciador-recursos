package beans;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dal.concrete.mysql.ActivityDAO;

import pojo.Activity;

@ManagedBean(name = "activityBean")
public class ActivityBean {
	
	public List<Activity> getActivities() {
		try {
			return ActivityDAO.getInstance().getAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
