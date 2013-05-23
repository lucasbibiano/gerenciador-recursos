package beans;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;

import pojo.Function;
import dal.concrete.mysql.FunctionDAO;

@ManagedBean(name = "functionBean")
@RequestScoped
public class FunctionBean {
	
	private Function function;
	private List<Function> functions;
	
	private HtmlDataTable dataTable;
	
	private static FunctionDAO dao;
	
	@PostConstruct
	public void init() {
		dao = FunctionDAO.getInstance();
		setFunction(new Function());
	}

	public String addFunction() {			
		try {
			dao.create(function);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Nova função cadastrada"));
			
			function = new Function();
			
			return "allfunctions";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro no cadastro da função"));
		
		function = new Function();
		
		return "newfunction";
	}

	public String editFunction() {
		function = (Function) dataTable.getRowData();
		
		return "editfunction";
	}
	
	public String deleteFunction() {
		function = (Function) dataTable.getRowData();
		
		try {
			dao.delete(function);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Função deletada"));
			
			function = new Function();
			
			return "allfunctions";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro ao apagar a função"));
		
		function = new Function();
		
		return "allfunctions";
	}
	
	public String updateFunction() {
		try {
			dao.update(function);
			
			FacesContext.getCurrentInstance()
		       .addMessage("success", new FacesMessage("Função atualizada"));
			
			function = new Function();
			
			return "allfunctions";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance()
	       .addMessage("error", new FacesMessage("Houve algum erro na edição da função"));
		
		function = new Function();
		
		return "editfunction";
	}
	
	public String showFunction() {
		function = (Function) dataTable.getRowData();
		dao.loadRelationships(function);
				
		return "showfunction";
	}	

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public List<Function> getFunctions() {
		try {
			function = new Function();
			functions = dao.getAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		
		return functions;
	}
	
}
