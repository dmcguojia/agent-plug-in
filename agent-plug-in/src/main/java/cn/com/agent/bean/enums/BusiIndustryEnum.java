package cn.com.agent.bean.enums;

public enum BusiIndustryEnum {

	BD5611("003"),	//一般类
	BD1520("002"),	//餐娱类（房产汽车类）
	BD5021("004"),	//一般类（批发）
	BD5541("005"),	//民生类
	BD7011("001"),	//餐娱类
	BD9703("007");	//县乡优惠

	private String code;

	private BusiIndustryEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
}
