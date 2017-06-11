package cn.com.agent.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TCity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_CITY")
public class CityDO implements java.io.Serializable {

	// Fields

	private Long CId;
	
	private String CName;
	private String CZcode;
	private String CPcode;
	private Long PId;
	private String CCode;
	private String xzCode;
	
	// Constructors

	/** default constructor */
	public CityDO() {
	}

	/** full constructor */
	public CityDO(String CName, String CZcode, String CPcode) {
		
		this.CName = CName;
		this.CZcode = CZcode;
		this.CPcode = CPcode;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "C_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getCId() {
		return this.CId;
	}

	public void setCId(Long CId) {
		this.CId = CId;
	}

	

	@Column(name = "C_NAME", length = 32)
	public String getCName() {
		return this.CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	@Column(name = "C_ZCODE", length = 6)
	public String getCZcode() {
		return this.CZcode;
	}

	public void setCZcode(String CZcode) {
		this.CZcode = CZcode;
	}

	@Column(name = "C_PCODE", length = 6)
	public String getCPcode() {
		return this.CPcode;
	}

	public void setCPcode(String CPcode) {
		this.CPcode = CPcode;
	}
	@Column(name = "P_ID", precision = 10, scale = 0)
	public Long getPId() {
		return PId;
	}

	public void setPId(Long pId) {
		PId = pId;
	}
	
	@Column(name = "C_CODE", length = 4)
	public String getCCode() {
		return this.CCode;
	}

	public void setCCode(String CCode) {
		this.CCode = CCode;
	}
	
	@Column(name = "XZ_CODE", length = 4)
	public String getXzCode() {
		return this.xzCode;
	}

	public void setXzCode(String xzCode) {
		this.xzCode = xzCode;
	}
}