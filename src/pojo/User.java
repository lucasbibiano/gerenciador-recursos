package pojo;

import dal.annotations.Column;
import dal.annotations.ForeignKey;
import dal.annotations.Storeable;

@Storeable(tableName = "Users")
public class User {
	
	@Column(columnName = "cpf", pk = true)
	private String cpf;
	
	@Column(columnName = "name")
	private String name;
	
	@Column(columnName = "telephone")
	private String telephone;

	@Column(columnName = "email")
	private String email;
	
	@Column(columnName = "sectorID")
	private long sectorID;
	
	@ForeignKey(thisSideAttrs = {"sectorID"}, otherSideAttrs = {"id"})
	private Sector sector;
	
	@Column(columnName = "functionID")
	private long functionID;
	
	@ForeignKey(thisSideAttrs = {"functionID"}, otherSideAttrs = {"id"})
	private Function function;
	
	public long getSectorID() {
		return sectorID;
	}
	public void setSectorID(long sectorID) {
		this.sectorID = sectorID;
	}
	public long getFunctionID() {
		return functionID;
	}
	public void setFunctionID(long functionID) {
		this.functionID = functionID;
	}
	public Function getFunction() {
		return function;
	}
	public void setFunction(Function function) {
		this.function = function;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
}
