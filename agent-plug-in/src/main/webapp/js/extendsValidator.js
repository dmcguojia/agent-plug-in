$.extend($.fn.validatebox.defaults.rules, {
   bankcard : {// 验证银行卡卡号
        validator : function(value) { 
            return /^\d{10,30}$/.test(value); 
        }, 
        message : '银行账号必须为10至30位数字' 
    },
	number : {// 验证数字
	        validator : function(value) { 
	            return /^\d+$/.test(value); 
	        }, 
	        message : '请输入数字' 
	    },
	amount : {// 验证金额
	        validator : function(value) { 
	            return  /(^(0|([1-9][0-9]*))((.[0-9]{1,2}){0,1}$))/.test(value); 
	         
	        }, 
	        message : '请输入正确的金额格式,最多精确到小数点后2位' 
	    },
	  busicode : {// 业务代码
	        validator : function(value) { 
	            return  /^\d{4}$/.test(value); 
	         
	        }, 
	        message : '业务代码必须为4位数字' 
	    },
	    rate : {//  万分比
	        validator : function(value) { 
	            return  /^\d{1,4}$/.test(value); 
	         
	        }, 
	        message : '0~9999之间的数字' 
	    },
	    percent : {//  百分比
	        validator : function(value) { 
	            return /^(100|[0-9]{1,2})([.]\d{1,2})?$/.test(value);
	            // /(^\d{1,2}$)|(^(0|([1-9][0-9])(.[0-9]{1,2})$))/.test(value);
	         
	        }, 
	        message : '0~100之间,最多精确到小数点后2位' 
	    },
	    miramount : {// 验证金额，单位分
	        validator : function(value) { 
	            return  /^([0-9]{1,12})$/.test(value); 
	        }, 
	        message : '请输入不以0开头的数字,最大长度为12' 
	    },
	    mcc : {//MCC
		        validator : function(value) { 
		            return  /^\d{4}$/.test(value); 
		         
		        }, 
		        message : 'MCC必须为4位数字' 
		    },
		    merchno : {//商户号
		        validator : function(value) { 
		            return  /^\w{13,15}$/.test(value); 
		         
		        }, 
		        message : '请输入正确的商户号' 
		    },
		     packcode : {// 版本号
		        validator : function(value) { 
		            return  /^\w{8}$/.test(value); 
		         
		        }, 
		        message : '8位字母,数字或下划线组成' 
		    }
    });
