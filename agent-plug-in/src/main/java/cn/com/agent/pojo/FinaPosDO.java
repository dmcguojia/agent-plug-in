package cn.com.agent.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TFinaPos entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_FINA_POS")
public class FinaPosDO implements java.io.Serializable {

	// Fields

	private Long termId;
	private String termNo;
	private String merchNo;
	private String investInstiid;
	private Long maintainInstiid;
	private Long e1code;
	private String pwdKeyboardNo;
	private Long secuType;
	private String secuId;
	private String serialNum;
	private String vicCode;
	private String material;
	private String typeCode;
	private String menuVer;
	private String status;
	private String instAddr;
	private Double foregift;
	private String jbpmid;
	private Long inUser;
	private Date inTime;
	private Long stexaUser;
	private Date stexaTime;
	private String stopinion;
	private Long civilexaUser;
	private Date civilexaTime;
	private String civilOpinion;
	private String notes;
	private String remarks;
	
	private String source;
	private Long apiLogId;
	private String backupStatus;
	// Constructors

	/** default constructor */
	public FinaPosDO() {
	}

	/** full constructor */
	public FinaPosDO(String termNo, String merchNo, String investInstiid,
			Long maintainInstiid, Long e1code, String pwdKeyboardNo,
			Long secuType, String secuId, String serialNum, String vicCode,
			String material, String typeCode, String menuVer, String status,
			String instAddr, Double foregift, String jbpmid, Long inUser,
			Date inTime, Long stexaUser, Date stexaTime, String stopinion,
			Long civilexaUser, Date civilexaTime, String civilOpinion,
			String notes, String remarks) {
		this.termNo = termNo;
		this.merchNo = merchNo;
		this.investInstiid = investInstiid;
		this.maintainInstiid = maintainInstiid;
		this.e1code = e1code;
		this.pwdKeyboardNo = pwdKeyboardNo;
		this.secuType = secuType;
		this.secuId = secuId;
		this.serialNum = serialNum;
		this.vicCode = vicCode;
		this.material = material;
		this.typeCode = typeCode;
		this.menuVer = menuVer;
		this.status = status;
		this.instAddr = instAddr;
		this.foregift = foregift;
		this.jbpmid = jbpmid;
		this.inUser = inUser;
		this.inTime = inTime;
		this.stexaUser = stexaUser;
		this.stexaTime = stexaTime;
		this.stopinion = stopinion;
		this.civilexaUser = civilexaUser;
		this.civilexaTime = civilexaTime;
		this.civilOpinion = civilOpinion;
		this.notes = notes;
		this.remarks = remarks;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "TERM_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getTermId() {
		return this.termId;
	}

	public void setTermId(Long termId) {
		this.termId = termId;
	}

	@Column(name = "TERM_NO", length = 8)
	public String getTermNo() {
		return this.termNo;
	}

	public void setTermNo(String termNo) {
		this.termNo = termNo;
	}

	@Column(name = "MERCH_NO", precision = 10, scale = 0)
	public String getMerchNo() {
		return this.merchNo;
	}

	public void setMerchNo(String merchNo) {
		this.merchNo = merchNo;
	}

	@Column(name = "INVEST_INSTIID")
	public String getInvestInstiid() {
		return this.investInstiid;
	}

	public void setInvestInstiid(String investInstiid) {
		this.investInstiid = investInstiid;
	}

	@Column(name = "MAINTAIN_INSTIID", precision = 10, scale = 0)
	public Long getMaintainInstiid() {
		return this.maintainInstiid;
	}

	public void setMaintainInstiid(Long maintainInstiid) {
		this.maintainInstiid = maintainInstiid;
	}

	@Column(name = "E1CODE", precision = 10, scale = 0)
	public Long getE1code() {
		return this.e1code;
	}

	public void setE1code(Long e1code) {
		this.e1code = e1code;
	}

	@Column(name = "PWD_KEYBOARD_NO", length = 8)
	public String getPwdKeyboardNo() {
		return this.pwdKeyboardNo;
	}

	public void setPwdKeyboardNo(String pwdKeyboardNo) {
		this.pwdKeyboardNo = pwdKeyboardNo;
	}

	@Column(name = "SECU_TYPE", precision = 10, scale = 0)
	public Long getSecuType() {
		return this.secuType;
	}

	public void setSecuType(Long secuType) {
		this.secuType = secuType;
	}

	@Column(name = "SECU_ID", length = 32)
	public String getSecuId() {
		return this.secuId;
	}

	public void setSecuId(String secuId) {
		this.secuId = secuId;
	}

	@Column(name = "SERIAL_NUM", length = 8)
	public String getSerialNum() {
		return this.serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	@Column(name = "VIC_CODE", length = 32)
	public String getVicCode() {
		return this.vicCode;
	}

	public void setVicCode(String vicCode) {
		this.vicCode = vicCode;
	}

	@Column(name = "MATERIAL", length = 8)
	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Column(name = "TYPE_CODE", length = 32)
	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@Column(name = "MENU_VER", length = 8)
	public String getMenuVer() {
		return this.menuVer;
	}

	public void setMenuVer(String menuVer) {
		this.menuVer = menuVer;
	}

	@Column(name = "STATUS", length = 2)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "INST_ADDR", length = 128)
	public String getInstAddr() {
		return this.instAddr;
	}

	public void setInstAddr(String instAddr) {
		this.instAddr = instAddr;
	}

	@Column(name = "FOREGIFT", precision = 10)
	public Double getForegift() {
		return this.foregift;
	}

	public void setForegift(Double foregift) {
		this.foregift = foregift;
	}

	@Column(name = "JBPMID", length = 32)
	public String getJbpmid() {
		return this.jbpmid;
	}

	public void setJbpmid(String jbpmid) {
		this.jbpmid = jbpmid;
	}

	@Column(name = "IN_USER", precision = 10, scale = 0)
	public Long getInUser() {
		return this.inUser;
	}

	public void setInUser(Long inUser) {
		this.inUser = inUser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "IN_TIME", length = 7)
	public Date getInTime() {
		return this.inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	@Column(name = "STEXA_USER", precision = 10, scale = 0)
	public Long getStexaUser() {
		return this.stexaUser;
	}

	public void setStexaUser(Long stexaUser) {
		this.stexaUser = stexaUser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STEXA_TIME", length = 7)
	public Date getStexaTime() {
		return this.stexaTime;
	}

	public void setStexaTime(Date stexaTime) {
		this.stexaTime = stexaTime;
	}

	@Column(name = "STOPINION", length = 128)
	public String getStopinion() {
		return this.stopinion;
	}

	public void setStopinion(String stopinion) {
		this.stopinion = stopinion;
	}

	@Column(name = "CIVILEXA_USER", precision = 10, scale = 0)
	public Long getCivilexaUser() {
		return this.civilexaUser;
	}

	public void setCivilexaUser(Long civilexaUser) {
		this.civilexaUser = civilexaUser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CIVILEXA_TIME", length = 7)
	public Date getCivilexaTime() {
		return this.civilexaTime;
	}

	public void setCivilexaTime(Date civilexaTime) {
		this.civilexaTime = civilexaTime;
	}

	@Column(name = "CIVIL_OPINION", length = 128)
	public String getCivilOpinion() {
		return this.civilOpinion;
	}

	public void setCivilOpinion(String civilOpinion) {
		this.civilOpinion = civilOpinion;
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
	
	@Column(name = "SOURCE", length = 4)
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Column(name = "API_LOG_ID", length = 10)
	public Long getApiLogId() {
		return apiLogId;
	}

	public void setApiLogId(Long apiLogId) {
		this.apiLogId = apiLogId;
	}
	@Column(name = "BACKUP_STATUS")
	public String getBackupStatus() {
		return backupStatus;
	}

	public void setBackupStatus(String backupStatus) {
		this.backupStatus = backupStatus;
	}

	
	
}