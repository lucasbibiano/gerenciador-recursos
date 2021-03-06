package pojo;

import java.sql.Timestamp;

import dal.annotations.Column;
import dal.annotations.ForeignKey;
import dal.annotations.Storeable;

@Storeable(tableName = "Reservations")
public class Reservation {
	
	@Column(columnName = "id", autoGenerated = true, pk = true)
	public long id;
	
	@Column(columnName = "solicitationTime")
	public Timestamp solicitationTime;
	
	@Column(columnName = "beginTime")
	public Timestamp beginTime;
	
	@Column(columnName = "endTime")
	public Timestamp endTime;
	
	@Column(columnName = "approved")
	public boolean approved;
	
	@Column(columnName = "pendingApproval")
	public boolean pendingApproval;
	
	@Column(columnName = "userCpf")
	public String userCpf;
	@ForeignKey(thisSideAttrs = {"userCpf"}, otherSideAttrs = {"cpf"})
	public User user;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Timestamp getSolicitationTime() {
		return solicitationTime;
	}
	public void setSolicitationTime(Timestamp solicitationTime) {
		this.solicitationTime = solicitationTime;
	}
	public Timestamp getStartTime() {
		return beginTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.beginTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public boolean isPending() {
		return pendingApproval;
	}
	public void setPending(boolean pending) {
		this.pendingApproval = pending;
	}
	public String getUserCpf() {
		return userCpf;
	}
	public void setUserCpf(String userCpf) {
		this.userCpf = userCpf;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
