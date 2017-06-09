package cn.com.agent.bean.enums;

public enum APICodeEnum {
	MEMBER_ADDANDMODIFY("010"),
	MEMBER_DELETE("011"),
	TERM_ADDANDMODIFY("020"),
	TERM_DELETE("021"),
	SLIP_ADD("030"),
	MEMBER_QUERY("042");
	
	private String code;
	
	private APICodeEnum(String code){
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
	
}
