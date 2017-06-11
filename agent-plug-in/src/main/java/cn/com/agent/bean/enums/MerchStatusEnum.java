package cn.com.agent.bean.enums;

public enum MerchStatusEnum {

	normal(0),//正常
	cancellation(1),//销户
	blackList(4),//黑名单
	freeze(5);//冻结
	
	private int code;

	private MerchStatusEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
}
