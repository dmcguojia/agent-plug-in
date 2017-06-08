/*
 * 
 * Textarea Maxlength Setter JQuery Plugin 
 * Version 1.0
 * 
 * Copyright (c) 2008 Viral Patel
 * website : http://viralpatel.net/blogs
 * 
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 * 
*/

;(function ($) {

	$.fn.maxlength = function(){
		 
		/*$("textarea[maxlength], input[maxlength]").keypress(function(event){ 
			var key = event.which;
			 
			//all keys including return.
			if(key >= 33 || key == 13 || key == 32) {
				var maxLength = $(this).attr("maxlength");
				var length = this.value.length;
				if(length >= maxLength) {	
					$(this).val($(this).val().substring(0,maxLength));
					event.preventDefault();
					
				}
			}
		});*/
		$("textarea[maxlength]").keyup(function(){ 
			var area=$(this); 
			var max=parseInt(area.attr("maxlength"),10); //获取maxlength的值 
			if(max>0){ 
				if(area.val().length>max){ //textarea的文本长度大于maxlength 
					area.val(area.val().substr(0,max)); //截断textarea的文本重新赋值 
					event.preventDefault();
				} 
			} 
			});
		//复制的字符处理问题 
		$("textarea[maxlength]").blur(function(){ 
			var area=$(this); 
			var max=parseInt(area.attr("maxlength"),10); //获取maxlength的值 
			if(max>0){ 
				if(area.val().length>max){ //textarea的文本长度大于maxlength 
					area.val(area.val().substr(0,max)); //截断textarea的文本重新赋值 
				} 
			} 
		}); 

	}

})(jQuery);

