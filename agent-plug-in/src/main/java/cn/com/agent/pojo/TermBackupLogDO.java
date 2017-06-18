package cn.com.agent.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "T_TERM_BACKUP_LOG")
public class TermBackupLogDO implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7518736590782070380L;
	private Long tid;
	private String action;
	private String requestId;
	private String timestamp;
	
	private String orgId;
	private String mercId;
	private String trmNo;
	private String trmSn;
	private String mfrNo;
	private String modNo;
	private String appNo;
	private String trmSts;
	private String macKey;
	private String pinKey;
	private String tmKey;
	private String trmProv;
	private String trmCity;
	
	private String responseid;
	private String retcode;
	private String retinfo;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_term_backup_log") 
	@SequenceGenerator(name="seq_term_backup_log",sequenceName="SEQ_TERM_BACKUP_LOG",allocationSize=1)
	@Column(name = "TID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	@Column(name = "ACTION")
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@Column(name = "REQUESTID")
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	@Column(name = "TIMESTAMP")
	public String getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Column(name = "ORGID")
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	@Column(name = "MERCID")
	public String getMercId() {
		return mercId;
	}
	public void setMercId(String mercId) {
		this.mercId = mercId;
	}
	@Column(name = "TRMNO")
	public String getTrmNo() {
		return trmNo;
	}
	public void setTrmNo(String trmNo) {
		this.trmNo = trmNo;
	}
	@Column(name = "TRMSN")
	public String getTrmSn() {
		return trmSn;
	}
	public void setTrmSn(String trmSn) {
		this.trmSn = trmSn;
	}
	@Column(name = "MFRNO")
	public String getMfrNo() {
		return mfrNo;
	}
	public void setMfrNo(String mfrNo) {
		this.mfrNo = mfrNo;
	}
	@Column(name = "MODNO")
	public String getModNo() {
		return modNo;
	}
	public void setModNo(String modNo) {
		this.modNo = modNo;
	}
	@Column(name = "APPNO")
	public String getAppNo() {
		return appNo;
	}
	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}
	@Column(name = "TRMSTS")
	public String getTrmSts() {
		return trmSts;
	}
	public void setTrmSts(String trmSts) {
		this.trmSts = trmSts;
	}
	@Column(name = "MACKEY")
	public String getMacKey() {
		return macKey;
	}
	public void setMacKey(String macKey) {
		this.macKey = macKey;
	}
	@Column(name = "PINKEY")
	public String getPinKey() {
		return pinKey;
	}
	public void setPinKey(String pinKey) {
		this.pinKey = pinKey;
	}
	@Column(name = "TMKEY")
	public String getTmKey() {
		return tmKey;
	}
	public void setTmKey(String tmKey) {
		this.tmKey = tmKey;
	}
	@Column(name = "TRMPROV")
	public String getTrmProv() {
		return trmProv;
	}
	public void setTrmProv(String trmProv) {
		this.trmProv = trmProv;
	}
	@Column(name = "TRMCITY")
	public String getTrmCity() {
		return trmCity;
	}
	public void setTrmCity(String trmCity) {
		this.trmCity = trmCity;
	}
	@Column(name = "RESPONSEID")
	public String getResponseid() {
		return responseid;
	}
	public void setResponseid(String responseid) {
		this.responseid = responseid;
	}
	@Column(name = "RETCODE")
	public String getRetcode() {
		return retcode;
	}
	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}
	@Column(name = "RETINFO")
	public String getRetinfo() {
		return retinfo;
	}
	public void setRetinfo(String retinfo) {
		this.retinfo = retinfo;
	}
	
	
}
