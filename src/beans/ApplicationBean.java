package beans;

import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import views.helpers.SubnavItem;


@ManagedBean(name = "appBean")
public class ApplicationBean {
	public String pageTitle() {		
		return "Open-Res: Gerenciador de Recursos";
	}
	
	public String pageTitle(String pageTitle) {		
		return "Open-Res: Gerenciador de Recursos | " + pageTitle;
	}
	
	
	public List<SubnavItem> getPillsPages() {
		LinkedList<SubnavItem> list = new LinkedList<SubnavItem>();
		
		list.add(new SubnavItem("/Open-Res/faces/dashboard/dashboard.xhtml", "Setores"));
		list.add(new SubnavItem("/Open-Res/facesfunction/allfunctions.xhtml", "Funções"));
		list.add(new SubnavItem("/Open-Res/faces/user/allusers.xhtml", "Usuários"));
		list.add(new SubnavItem("/Open-Res/faces/roomtype/allroomtypes.xhtml", "Tipos de Sala"));
		list.add(new SubnavItem("/Open-Res/faces/reservation/allreservations.xhtml", "Reservas"));
		
		return list;
	}
}
