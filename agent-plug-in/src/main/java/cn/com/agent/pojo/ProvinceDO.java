package cn.com.agent.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TProvince entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_PROVINCE")
public class ProvinceDO implements java.io.Serializable {

	// Fields

	private Long PId;
	private String PName;
	private String PCode;

	// Constructors

	/** default constructor */
	public ProvinceDO() {
	}

	/** full constructor */
	public ProvinceDO(String PName) {
		this.PName = PName;
		
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "P_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getPId() {
		return this.PId;
	}

	public void setPId(Long PId) {
		this.PId = PId;
	}

	@Column(name = "P_NAME", length = 20)
	public String getPName() {
		return this.PName;
	}

	public void setPName(String PName) {
		this.PName = PName;
	}

	@Column(name = "P_CODE", length = 4)
	public String getPCode() {
		return this.PCode;
	}

	public void setPCode(String PCode) {
		this.PCode = PCode;
	}
}