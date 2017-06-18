package cn.com.agent.bean.enums;



public enum SelfFeeTypeEnum {

	free("0"),
	txn("1"),
	mcc("2"),
	card("5");
	private String code;

	private SelfFeeTypeEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
	public static SelfFeeTypeEnum fromValue(String value) {
        for(SelfFeeTypeEnum status:values()){
            if(status.code.equals(value)){
                return status;
            }
        }
        return null;
    }
    
}
