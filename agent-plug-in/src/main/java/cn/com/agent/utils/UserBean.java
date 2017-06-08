package cn.com.agent.utils;

import java.io.Serializable;
import java.util.Date;

public class UserBean implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6345783095206671760L;
	private Long userId;
	private String userCode;
	private String userName;
	private String loginName;
	private String pwd;
	private String pwdValid;
	private Short pwdErrorNumber;
	private Date lastLoginTime;
	private String creator;
	private Date createDate;
	private Long organId;
	private Long deptId;
	private String isadmin;
	private String status;
	private String notes;
	private String remarks;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwdValid() {
		return pwdValid;
	}
	public void setPwdValid(String pwdValid) {
		this.pwdValid = pwdValid;
	}
	public Short getPwdErrorNumber() {
		return pwdErrorNumber;
	}
	public void setPwdErrorNumber(Short pwdErrorNumber) {
		this.pwdErrorNumber = pwdErrorNumber;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getOrganId() {
		return organId;
	}
	public void setOrganId(Long organId) {
		this.organId = organId;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
