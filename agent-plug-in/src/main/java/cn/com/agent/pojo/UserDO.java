package cn.com.agent.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_USER")
public class UserDO implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7985192194946026118L;
	private Long userId;
	private String userCode;
	private String userName;
	private String loginName;
	private String pwd;
	private Timestamp pwdValid;
	private Short pwdErrorNumber;
	private Timestamp lastLoginTime;
	private String creator;
	private Timestamp createDate;
	private Long roleId;
	private Long organId;
	private Long deptId;
	private String isadmin;
	private String status;
	private String notes;
	private String remarks;
	private String randCode;
	private String caCode;
	// Constructors

	/** default constructor */
	public UserDO() {
	}

	/** full constructor */
	public UserDO(String userCode, String userName, String loginName,
			String pwd, Timestamp pwdValid, Short pwdErrorNumber,
			Timestamp lastLoginTime, String creator, Timestamp createDate,
			Long roleId, Long organId, Long deptId, String isadmin,
			String status, String notes, String remarks) {
		this.userCode = userCode;
		this.userName = userName;
		this.loginName = loginName;
		this.pwd = pwd;
		this.pwdValid = pwdValid;
		this.pwdErrorNumber = pwdErrorNumber;
		this.lastLoginTime = lastLoginTime;
		this.creator = creator;
		this.createDate = createDate;
		this.roleId = roleId;
		this.organId = organId;
		this.deptId = deptId;
		this.isadmin = isadmin;
		this.status = status;
		this.notes = notes;
		this.remarks = remarks;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "USER_CODE", length = 16)
	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name = "USER_NAME", length = 32)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "LOGIN_NAME", length = 32)
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "PWD", length = 32)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "PWD_VALID", length = 7)
	public Timestamp getPwdValid() {
		return this.pwdValid;
	}

	public void setPwdValid(Timestamp pwdValid) {
		this.pwdValid = pwdValid;
	}

	@Column(name = "PWD_ERROR_NUMBER", precision = 4, scale = 0)
	public Short getPwdErrorNumber() {
		return this.pwdErrorNumber;
	}

	public void setPwdErrorNumber(Short pwdErrorNumber) {
		this.pwdErrorNumber = pwdErrorNumber;
	}

	@Column(name = "LAST_LOGIN_TIME", length = 7)
	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "CREATOR", length = 32)
	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name = "CREATE_DATE", length = 7)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "ROLE_ID", precision = 10, scale = 0)
	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "ORGAN_ID", precision = 10, scale = 0)
	public Long getOrganId() {
		return this.organId;
	}

	public void setOrganId(Long organId) {
		this.organId = organId;
	}

	@Column(name = "DEPT_ID", precision = 10, scale = 0)
	public Long getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	@Column(name = "ISADMIN", length = 1)
	public String getIsadmin() {
		return this.isadmin;
	}

	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}

	@Column(name = "STATUS", length = 2)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "NOTES", length = 128)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "REMARKS", length = 128)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Transient
	public String getRandCode() {
		return randCode;
	}

	public void setRandCode(String randCode) {
		this.randCode = randCode;
	}
	
	@Column(name="CA_CODE",length=11)
	public String getCaCode() {
		return caCode;
	}

	public void setCaCode(String caCode) {
		this.caCode = caCode;
	}
	
	
}