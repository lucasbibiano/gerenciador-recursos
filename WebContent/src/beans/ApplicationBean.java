package beans;

import javax.faces.bean.ManagedBean;


@ManagedBean(name = "appBean")
public class ApplicationBean {
	public String pageTitle() {		
		return "Open-Res: Gerenciador de Recursos";
	}
	
	public String pageTitle(String pageTitle) {		
		return "Open-Res: Gerenciador de Recursos | " + pageTitle;
	}	
}
