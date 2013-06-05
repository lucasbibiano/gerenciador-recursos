package pojo;

import dal.annotations.Column;
import dal.annotations.ForeignKey;
import dal.annotations.Storeable;

@Storeable(tableName = "Users")
public class User {
	
	@Column(columnName = "cpf", pk = true)
	public String cpf;
	
	@Column(columnName = "name")
	public String name;
	
	@Column(columnName = "login")
	public String login;
	
	@Column(columnName = "password")
	public String password;
	
	@Column(columnName = "telephone")
	public String telephone;

	@Column(columnName = "email")
	public String email;
	
	@Column(columnName = "sectorID")
	public long sectorID;
	@ForeignKey(thisSideAttrs = {"sectorID"}, otherSideAttrs = {"id"})
	public Sector sector;
	
	@Column(columnName = "functionID")
	public long functionID;
	@ForeignKey(thisSideAttrs = {"functionID"}, otherSideAttrs = {"id"})
	public Function function;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public long getSectorID() {
		return sectorID;
	}
	public void setSectorID(long sectorID) {
		this.sectorID = sectorID;
	}
	public Sector getSector() {
		return sector;
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
	
}
