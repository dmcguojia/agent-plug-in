package cn.com.agent.bean.enums;

public enum IdTypeEnum {
	ID0("00"),//身份证
	ID1("02"),//军官证
	ID2("04"),//港澳通行证
	ID3("06");//护照

	private String code;

	private IdTypeEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
	
}
