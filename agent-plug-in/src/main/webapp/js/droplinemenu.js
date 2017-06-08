(function($){
	$.fn.extend({
		droplinemenu: function(configs) {
			var configs = $.extend({				
				over: 200,
				out: 100, 
				rightdown:'css/down.gif' 
			},configs||{});
			this.find(">ul").addClass("dropmenu");
			this.find("ul li:has(ul)").addClass('hasmenu').find(">a").append("<img class='downarrowclass' src='"+configs.rightdown+"'>");
			var currentobj;
			return $('li.hasmenu').hover(function(){				 
				if ($.browser.msie) {//清除ie下生成的overflow:hidden
					$(this).parent("ul").css({'overflow': 'visible'}); 
				} 
				$(this).find(">ul").stop(true, true).css('top',$(this).height()).slideDown(configs.over);
			},function(){   
				$(this).find(">ul").stop(true, true).slideUp(configs.out);
			});
			 
		}
	});
})(jQuery);
 

