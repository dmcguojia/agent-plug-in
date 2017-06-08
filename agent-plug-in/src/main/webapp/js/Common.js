/*************************
	code by lincee
*************************/

	//---------------------- global function ----------------
	
	function parseString(a) { 
		return ""+a;
	} 
	
	function isAlien(a) {
	  return isObject(a) && typeof a.constructor != 'function';
	} 
	 
	function isArray(a) {
	  return isObject(a) && a.constructor == Array;
	}
	
	function isBoolean(a) {
	  return typeof a == 'boolean';
	}
	
	function isEmpty(o) {
	  var i, v;
	  if (isObject(o)) {
		for (i in o) {
		  v = o[i];
		  if (isUndefined(v) && isFunction(v)) {
			return false;
		  }
		}
	  }
	  return true;
	}
	
	function isFunction(a) {
	  return typeof a == 'function';
	}
	
	function isNumber(a) {
	  return typeof a == 'number' && isFinite(a);
	}
	
	function isObject(a) {
	  return (a && typeof a == 'object') || isFunction(a);
	}
	
	function isString(a) {
	  return typeof a == 'string';
	}
	
	function isUndefined(a) {
	  return typeof a == 'undefined';
	}
	
	//******************************************
	function isNull(a) {
	  return ("null" == ""+a) || ("undefined" == ""+a);
	}
	
	function $(id, target) {
		if(isNull(target)) 
			return document.getElementById(id);
		else 
			return eval(target+".document.getElementById('"+id+"')");
	}
	function $F(id, target) {
		return $(id, target).value;
	}
	
	function escapeString(s) {
		if(s.length == 0)
			return s;
		else
			return escape(s);
	}
	// o �����tagName(tagNameΪȫ��д)
	function getParent(o, tagName) {
		try {
			for(var i = 0; i < 99; i++) {
				o = o.parentNode;
				if(o.tagName == tagName) return o;
				if(null == o) break;
			}
		} catch(e){}
		return null;
	}
	// o������tagName(tagNameΪȫ��д)��������body�µ�tagName
	function getForebear(o, tagName) {
		var result = null;
		try {
			for(var i = 0; i < 99; i++) {
				o = o.parentNode;
				if(o.tagName == tagName) result = o;
				if(null == o) break;
			}
		} catch(e){}
		return result;
	}
	// object
	function show(o) {
		if(!isNull(o)) o.style.display = "";
	}
	function hide(o) {
		if(!isNull(o)) o.style.display = "none";
	}
	// Layer
	function showLayer(o) {
		if(!isNull(o)) o.style.visibility = "show";
	}
	function hideLayer(o) {
		if(!isNull(o)) o.style.visibility = "hidden";
	}
	FlyLayer = {bIsCatchFlyBar : false,dragClickX : 0,dragClickY : 0}
	function convertFlyLayer(div) {
		if(!isNull(div)) {
			div["onmousedown"] = function(){
				FlyLayer.bIsCatchFlyBar = true;
				var x=event.x+document.body.scrollLeft;
				var y=event.y+document.body.scrollTop;
				FlyLayer.dragClickX=x-this.style.pixelLeft;
				FlyLayer.dragClickY=y-this.style.pixelTop;
				this.setCapture();
				this.onmousemove = function() {
					if(FlyLayer.bIsCatchFlyBar){
						this.style.left = event.x+document.body.scrollLeft-FlyLayer.dragClickX;
						this.style.top = event.y+document.body.scrollTop-FlyLayer.dragClickY;
					}	
				};
			};
			div["onmouseup"] = function (){
				FlyLayer.bIsCatchFlyBar = false;
				this.releaseCapture();
				this.onmousemove = null;
			};
		}	
	}
    String.prototype.replaceAll = function(inchar, outchar) {
        try {
            return this.split(inchar).join(outchar);
        } catch(e) {
            return this;
        }
    }
	// �ַ��
	String.prototype.charLength = function() {
		return this.length;
	}
	// �ֽڳ���
	String.prototype.byteLength = function() {
		return this.replace(/[^\x00-\xff]/g,'**').length;
	}
	// ����׷������
	Function.prototype.attach = function(func){
		var f = this;
		return function(){
			f();
			func();
		}
	}	
	// ����׷�������¼� $("id").attachEvent("onclick", function(){});
	Object.prototype.attachEvent = function (method, func) {
		if(!this[method])
			this[method] = func;
		else
			this[method] = this[method].attach(func);
	}
	//******************************************
	var beforeTrNavigator = null;	
	window.attachEvent("onload", function() {
		// base_tr_navigator
		var trArray = document.getElementsByTagName("TR");
		for(var i = 0; i < trArray.length; i++) {
			if("base_tr_navigator" == trArray[i].className)	 { // ��ѯ�б�
				var trList = trArray[i].parentNode.childNodes;
				var isExecute = false;
				for(var j = 0; j < trList.length; j++) {
					var tr = trList[j];
					if("base_tr_navigator" == tr.className) {
						isExecute = true;
					} else {
						if(true == isExecute) {
							tr["onmouseover"] = function() {if("base_tr_navigator_click" != this.className)this.className = "base_tr_navigator_mouse_over";}
							tr["onmouseout"] = function() {if("base_tr_navigator_click" != this.className)this.className = "";}
							tr["onclick"] = function() {
								if (null != beforeTrNavigator) 
									try { beforeTrNavigator.className = ""; }catch(ex) {}
								this.className = "base_tr_navigator_click";
								beforeTrNavigator = this;
							}
						}
					}
					delete tr;
				}
				delete trList;
			}
		}
		delete trArray;		
		// image button and image tag
		for (var i = 0; i < document.forms.length; i++) {
			var form = document.forms[0];
			if(form.all) {
				for(var i = 0; i < form.all.length; i++) {
					var element = form.all[i];
					if (element.type && "image" == element.type.toLowerCase() && "true" == element.getAttribute("mouseover")) {
						var src = element.src;
						var last_indexof = src.lastIndexOf(".");
						var mouseoversrc = src.substring(0, last_indexof) + "_mouseover" + src.substring(last_indexof)
						element.setAttribute("mouseoversrc", mouseoversrc);
						element.setAttribute("mouseoutsrc", src);							
						element["onmouseover"] = function() {this.src = this.getAttribute("mouseoversrc");}
						element["onmouseout"] = function() {this.src = this.getAttribute("mouseoutsrc");	}
						delete mouseoversrc;
						delete last_indexof;
						delete src;
					}
					delete element;
				}
			}
			delete form;
		}
		var imageArray = document.getElementsByTagName("IMG");
		for (var i = 0; i < imageArray.length; i++) {
			var element = imageArray[i];
			if ("true" == element.getAttribute("mouseover")) {
				var src = element.src;
				var last_indexof = src.lastIndexOf(".");
				var mouseoversrc = src.substring(0, last_indexof) + "_mouseover" + src.substring(last_indexof)
				element.setAttribute("mouseoversrc", mouseoversrc);
				element.setAttribute("mouseoutsrc", src);							
				element["onmouseover"] = function() {this.src = this.getAttribute("mouseoversrc");}
				element["onmouseout"] = function() {this.src = this.getAttribute("mouseoutsrc");	}
				delete mouseoversrc;
				delete last_indexof;
				delete src;
			}
			delete element;
		}
		delete imageArray;
	});
	//---------------- XmlManager ------
	XmlManager = {	
		initObject : function(){
			var objXml = null;
			// microsoft IE
			if(null == objXml){
				try {
					objXml = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
			if(null == objXml){
				try {
					objXml = new ActiveXObject("MSXML2.XMLHTTP");
				} catch (e) {
				}
			}
		
			// Netscape or Mozilla or Safari
			if(null == objXml){
				try {
					objXml = new XMLHttpRequest();
				} catch (e) {
				}
			}
			return objXml;
		},
		
		// method "get" or "post", boolAsync "true" or "false"
		carryInformation : function(url, method, boolAsync, refererUrl) {
			var result = "" ;
			method = method.toUpperCase();
			var objXml = this.initObject();
			if(null == objXml) {
				window.open(url, "", "");
			} else {
				objXml.open(method, url, boolAsync);
				objXml.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				if(method == "POST") {
					objXml.setRequestHeader("Method", "POST " + url + " HTTP/1.1");
					if(!isNull(refererUrl)) objXml.setRequestHeader("Referer",refererUrl);
				}
				objXml.send();
				try {
					result = objXml.responseText;
				}catch(e){
				}
				delete objXml;
			}
			return result;
		},
		// post data and accept return data; method "get" or "post"
		getSourceCode : function(url){
			// waiting until return data done
			return this.carryInformation(url, "GET", false) ;
		}
	}

// --------------------- Calendar --------------
	function CalendarComponent_FormatDatePartString(a) {
		return 	(""+a).length == 1 ? ("0"+a) : (""+a);
	}		
	function CalendarComponent_DateAdd(interval,number,date){
		number = parseInt(number);
		if (typeof(date)=="string"){var date = new Date(date.split("-")[0],date.split("-")[1],date.split("-")[2])}
		if (typeof(date)=="object"){var date = date}
		switch(interval){
		case "y":return new Date(date.getFullYear()+number,date.getMonth(),date.getDate()); break;
		case "m":return new Date(date.getFullYear(),date.getMonth()+number,CalendarComponent_CheckDate(date.getFullYear(),date.getMonth()+number,date.getDate())); break;
		case "d":return new Date(date.getFullYear(),date.getMonth(),date.getDate()+number); break;
		case "w":return new Date(date.getFullYear(),date.getMonth(),7*number+date.getDate()); break;
		}
	}
	function CalendarComponent_CheckDate(year,month,date){
		var enddate = ["31","28","31","30","31","30","31","31","30","31","30","31"];
		var returnDate = "";
		if (year%4==0){enddate[1]="29"}
		if (date>enddate[month]){returnDate = enddate[month]}else{returnDate = date}
		return returnDate;
	}
	function CalendarComponent_WeekDay(date){
		var theDate;
		if (typeof(date)=="string"){theDate = new Date(date.split("-")[0],date.split("-")[1],date.split("-")[2]);}
		if (typeof(date)=="object"){theDate = date}
		return theDate.getDay();
	}
	function CalendarComponent_Calendar(){
		var lis = "";
		var style = "";
		style +="<style type='text/css'>";
		style +=".calendar { width:170px; height:auto; font-size:12px; margin-right:14px; background:url(calendarbg.gif) no-repeat right center #fff; border:1px solid #397EAE; padding:1px}";
		style +=".calendar ul {list-style-type:none; margin:0; padding:0;}";
		style +=".calendar .day { background-color:#EDF5FF; height:20px;}";
		style +=".calendar .day li,.calendar .date li{ float:left; width:14%; height:20px; line-height:20px; text-align:center}";
		style +=".calendar li a { text-decoration:none; font-family:Tahoma; font-size:11px; color:#333}";
		style +=".calendar li a:hover { color:#f30; text-decoration:underline}";
		style +=".calendar li a.hasArticle {font-weight:bold; color:#f60 !important}";
		style +=".lastMonthDate, .nextMonthDate {color:#bbb;font-size:11px}";
		style +=".selectThisYear a, .selectThisMonth a{text-decoration:none; margin:0 2px; color:#000; font-weight:bold}";
		style +=".calendar .LastMonth, .calendar .NextMonth{ text-decoration:none; color:#000; font-size:18px; font-weight:bold; line-height:16px;}";
		style +=".calendar .LastMonth { float:left;}";
		style +=".calendar .NextMonth { float:right;}";
		style +=".calendarBody {clear:both}";
		style +=".calendarTitle {text-align:center;height:20px; line-height:20px; clear:both}";
		style +=".today { background-color:#ffffaa;border:1px solid #f60; padding:2px}";
		style +=".today a { color:#f30; }";
		style +=".calendarBottom {clear:both; border-top:1px solid #ddd; padding: 3px 0; text-align:left}";
		style +=".calendarBottom a {text-decoration:none; margin:2px !important; font-weight:bold; color:#000}";
		style +=".calendarBottom a.closeCalendar{float:right}";
		style +=".closeCalendarBox {float:right; border:1px solid #000; background:#fff; font-size:9px; width:11px; height:11px; line-height:11px; text-align:center;overflow:hidden; font-weight:normal !important}";
		style +="</style>";
	
		var now;
		if (typeof(arguments[0])=="string"){
			selectDate = arguments[0].split("-");
			var year = selectDate[0];
			var month = parseInt(selectDate[1])-1+"";
			var date = selectDate[2];
			now = new Date(year,month,date);
		}else if (typeof(arguments[0])=="object"){
			now = arguments[0];
		}
		var lastMonthEndDate = CalendarComponent_DateAdd("d","-1",now.getFullYear()+"-"+now.getMonth()+"-01").getDate();
		var lastMonthDate = CalendarComponent_WeekDay(now.getFullYear()+"-"+now.getMonth()+"-01");
		var thisMonthLastDate = CalendarComponent_DateAdd("d","-1",now.getFullYear()+"-"+(parseInt(now.getMonth())+1).toString()+"-01");
		var thisMonthEndDate = thisMonthLastDate.getDate();
		var thisMonthEndDay = thisMonthLastDate.getDay();
		var todayObj = new Date();
		today = todayObj.getFullYear()+"-"+todayObj.getMonth()+"-"+todayObj.getDate();
		
		for (i=0; i<lastMonthDate; i++){  // Last Month's Date
			lis = "<li class='lastMonthDate'>"+lastMonthEndDate+"</li>" + lis;
			lastMonthEndDate--;
		}
		for (i=1; i<=thisMonthEndDate; i++){ // Current Month's Date
			if(today == now.getFullYear()+"-"+now.getMonth()+"-"+i){
				var todayString = now.getFullYear()+"-"+CalendarComponent_FormatDatePartString(parseInt(now.getMonth())+1).toString()+"-"+CalendarComponent_FormatDatePartString(i);
				lis += "<li><a href=javascript:void(0) class='today' onclick='CalendarComponent_SelectThisDay(this)' title='"+now.getFullYear()+"-"+CalendarComponent_FormatDatePartString(parseInt(now.getMonth())+1)+"-"+CalendarComponent_FormatDatePartString(i)+"'>"+i+"</a></li>";
			}else{
				lis += "<li><a href=javascript:void(0) onclick='CalendarComponent_SelectThisDay(this)' title='"+now.getFullYear()+"-"+CalendarComponent_FormatDatePartString(parseInt(now.getMonth())+1)+"-"+CalendarComponent_FormatDatePartString(i)+"'>"+i+"</a></li>";
			}
		}
		var j=1;
		for (i=thisMonthEndDay; i<6; i++){  // Next Month's Date
			lis += "<li class='nextMonthDate'>"+j+"</li>";
			j++;
		}
		lis += style;
	
		var CalendarTitle = "<a href='javascript:void(0)' class='NextMonth' onclick=CalendarComponent_Calendar(CalendarComponent_DateAdd('m',1,'"+now.getFullYear()+"-"+now.getMonth()+"-"+now.getDate()+"'),this) title='Next Month'>&raquo;</a>";
		CalendarTitle += "<a href='javascript:void(0)' class='LastMonth' onclick=CalendarComponent_Calendar(CalendarComponent_DateAdd('m',-1,'"+now.getFullYear()+"-"+now.getMonth()+"-"+now.getDate()+"'),this) title='Previous Month'>&laquo;</a>";
		CalendarTitle += "<span class='selectThisYear'><a href='javascript:void(0)' onclick='CalendarComponent_CalendarSelectYear(this)' title='Click here to select other year' >"+now.getFullYear()+"</a></span>��<span class='selectThisMonth'><a href='javascript:void(0)' onclick='CalendarComponent_CalendarSelectMonth(this)' title='Click here to select other month'>"+(parseInt(now.getMonth())+1).toString()+"</a></span>��"; 
	
		if (arguments.length>1){
			arguments[1].parentNode.parentNode.getElementsByTagName("ul")[1].innerHTML = lis;
			arguments[1].parentNode.innerHTML = CalendarTitle;
		}else{
			var CalendarBox = style+"<div class='calendar'><div class='calendarTitle'>"+CalendarTitle+"</div><div class='calendarBody'><ul class='day'><li>��</li><li>һ</li><li>��</li><li>��</li><li>��</li><li>��</li><li>��</li></ul><ul class='date' id='thisMonthDate'>"+lis+"</ul></div><div class='calendarBottom'><a href='javascript:void(0)' class='closeCalendar' onclick='CalendarComponent_CloseCalendar(this)'>&times;</a><span><span><a href=javascript:void(0) onclick='CalendarComponent_SelectThisDay(this)' title='"+todayString+"'>Today</a> <a href=javascript:void(0) onclick='CalendarComponent_SelectThisDay(this)' title=''>Clear</a></span></span></div></div>";
			return CalendarBox;
		}
	}
	
	function CalendarComponent_CalendarMonth(){
		var lis = "";
		var style = "";
		style +="<style type='text/css'>";
		style +=".calendar { width:170px; height:auto; font-size:12px; margin-right:14px; background:url(calendarbg.gif) no-repeat right center #fff; border:1px solid #397EAE; padding:1px}";
		style +=".calendar ul {list-style-type:none; margin:0; padding:0;}";
		style +=".calendar .day { background-color:#EDF5FF; height:20px;}";
		style +=".calendar .day li,.calendar .date li{ float:left; width:14%; height:20px; line-height:20px; text-align:center}";
		style +=".calendar li a { text-decoration:none; font-family:Tahoma; font-size:11px; color:#333}";
		style +=".calendar li a:hover { color:#f30; text-decoration:underline}";
		style +=".calendar li a.hasArticle {font-weight:bold; color:#f60 !important}";
		style +=".lastMonthDate, .nextMonthDate {color:#bbb;font-size:11px}";
		style +=".selectThisYear a, .selectThisMonth a{text-decoration:none; margin:0 2px; color:#000; font-weight:bold}";
		style +=".calendar .LastMonth, .calendar .NextMonth{ text-decoration:none; color:#000; font-size:18px; font-weight:bold; line-height:16px;}";
		style +=".calendar .LastMonth { float:left;}";
		style +=".calendar .NextMonth { float:right;}";
		style +=".calendarBody {clear:both}";
		style +=".calendarTitle {text-align:center;height:20px; line-height:20px; clear:both}";
		style +=".today { background-color:#ffffaa;border:1px solid #f60; padding:2px}";
		style +=".today a { color:#f30; }";
		style +=".calendarBottom {clear:both; border-top:1px solid #ddd; padding: 3px 0; text-align:left}";
		style +=".calendarBottom a {text-decoration:none; margin:2px !important; font-weight:bold; color:#000}";
		style +=".calendarBottom a.closeCalendar{float:right}";
		style +=".closeCalendarBox {float:right; border:1px solid #000; background:#fff; font-size:9px; width:11px; height:11px; line-height:11px; text-align:center;overflow:hidden; font-weight:normal !important}";
		style +="</style>";
	
		var now;
		if (typeof(arguments[0])=="string"){
			selectDate = arguments[0].split("-");
			var year = selectDate[0];
			var month = parseInt(selectDate[1])-1+"";
			var date = selectDate[2];
			now = new Date(year,month,date);
		}else if (typeof(arguments[0])=="object"){
			now = arguments[0];
		}
		var lastMonthEndDate = CalendarComponent_DateAdd("d","-1",now.getFullYear()+"-"+now.getMonth()+"-01").getDate();
		var lastMonthDate = CalendarComponent_WeekDay(now.getFullYear()+"-"+now.getMonth()+"-01");
		var thisMonthLastDate = CalendarComponent_DateAdd("d","-1",now.getFullYear()+"-"+(parseInt(now.getMonth())+1).toString()+"-01");
		var thisMonthEndDate = thisMonthLastDate.getDate();
		var thisMonthEndDay = thisMonthLastDate.getDay();
		var todayObj = new Date();
		today = todayObj.getFullYear()+"-"+todayObj.getMonth();
		
		for (i=0; i<lastMonthDate; i++){  // Last Month's Date
			lis = "<li class='lastMonthDate'>"+lastMonthEndDate+"</li>" + lis;
			lastMonthEndDate--;
		}
		for (i=1; i<=thisMonthEndDate; i++){ // Current Month's Date
			if(today == now.getFullYear()+"-"+now.getMonth()+"-"+i){
				var todayString = now.getFullYear()+"-"+CalendarComponent_FormatDatePartString(parseInt(now.getMonth())+1).toString();
				lis += "<li><a href=javascript:void(0) class='today' onclick='CalendarComponent_SelectThisDay(this)' title='"+now.getFullYear()+"-"+CalendarComponent_FormatDatePartString(parseInt(now.getMonth())+1)+"'>"+i+"</a></li>";
			}else{
				lis += "<li><a href=javascript:void(0) onclick='CalendarComponent_SelectThisDay(this)' title='"+now.getFullYear()+"-"+CalendarComponent_FormatDatePartString(parseInt(now.getMonth())+1)+"'>"+i+"</a></li>";
			}
		}
		var j=1;
		for (i=thisMonthEndDay; i<6; i++){  // Next Month's Date
			lis += "<li class='nextMonthDate'>"+j+"</li>";
			j++;
		}
		lis += style;
	
		var CalendarTitle = "<a href='javascript:void(0)' class='NextMonth' onclick=CalendarComponent_CalendarMonth(CalendarComponent_DateAdd('m',1,'"+now.getFullYear()+"-"+now.getMonth()+"-"+now.getDate()+"'),this) title='Next Month'>&raquo;</a>";
		CalendarTitle += "<a href='javascript:void(0)' class='LastMonth' onclick=CalendarComponent_CalendarMonth(CalendarComponent_DateAdd('m',-1,'"+now.getFullYear()+"-"+now.getMonth()+"-"+now.getDate()+"'),this) title='Previous Month'>&laquo;</a>";
		CalendarTitle += "<span class='selectThisYear'><a href='javascript:void(0)' onclick='CalendarComponent_CalendarSelectYear(this)' title='Click here to select other year' >"+now.getFullYear()+"</a></span>��<span class='selectThisMonth'><a href='javascript:void(0)' onclick='CalendarComponent_CalendarSelectMonth(this)' title='Click here to select other month'>"+(parseInt(now.getMonth())+1).toString()+"</a></span>��"; 
	
		if (arguments.length>1){
			arguments[1].parentNode.parentNode.getElementsByTagName("ul")[1].innerHTML = lis;
			arguments[1].parentNode.innerHTML = CalendarTitle;
		}else{
			var CalendarBox = style+"<div class='calendar'><div class='calendarTitle'>"+CalendarTitle+"</div><div class='calendarBody'><ul class='day'><li>��</li><li>һ</li><li>��</li><li>��</li><li>��</li><li>��</li><li>��</li></ul><ul class='date' id='thisMonthDate'>"+lis+"</ul></div><div class='calendarBottom'><a href='javascript:void(0)' class='closeCalendar' onclick='CalendarComponent_CloseCalendar(this)'>&times;</a><span><span><a href=javascript:void(0) onclick='CalendarComponent_SelectThisDay(this)' title='"+todayString+"'>Today</a> <a href=javascript:void(0) onclick='CalendarComponent_SelectThisDay(this)' title=''>Clear</a></span></span></div></div>";
			return CalendarBox;
		}
	}
	
	
	function CalendarComponent_SelectThisDay(d){
		var boxObj = d.parentNode.parentNode.parentNode.parentNode.parentNode;
			boxObj.targetObj.value = d.title;
			boxObj.parentNode.removeChild(boxObj);
	}
	function CalendarComponent_CloseCalendar(d){
		var boxObj = d.parentNode.parentNode.parentNode;
			boxObj.parentNode.removeChild(boxObj);
	}
	function CalendarComponent_CalendarSelectYear(obj){
			var opt = "";
			var thisYear = obj.innerHTML;
			for (i=1970; i<=2020; i++){
				if (i==thisYear){
					opt += "<option value="+i+" selected>"+i+"</option>";
				}else{
					opt += "<option value="+i+">"+i+"</option>";
				}
			}
			opt = "<select onblur='CalendarComponent_SelectThisYear(this)' onchange='CalendarComponent_SelectThisYear(this)' style='font-size:11px'>"+opt+"</select>";
			obj.parentNode.innerHTML = opt;
	}
	function CalendarComponent_SelectThisYear(obj){
		var v_select_month = null;
		if (null == v_select_month) {
			try {
				v_select_month = obj.parentNode.parentNode.getElementsByTagName("SPAN")[1].getElementsByTagName("A")[0].innerHTML;
			} catch(e){}
		}
		if (null == v_select_month) {
			try {
				v_select_month = obj.parentNode.parentNode.getElementsByTagName("SPAN")[1].getElementsByTagName("SELECT")[0].value;
			} catch(e){}
		}
		if (null == v_select_month) {
			v_select_month = "1";
		}
		CalendarComponent_Calendar(obj.value+"-"+v_select_month+"-1", obj.parentNode);
		delete v_select_month;
	}
	function CalendarComponent_CalendarSelectMonth(obj){
			var opt = "";
			var thisMonth = obj.innerHTML;
			for (i=1; i<=12; i++){
				if (i==thisMonth){
					opt += "<option value="+i+" selected>"+i+"</option>";
				}else{
					opt += "<option value="+i+">"+i+"</option>";
				}
			}
			opt = "<select onblur='CalendarComponent_SelectThisMonth(this)' onchange='CalendarComponent_SelectThisMonth(this)' style='font-size:11px'>"+opt+"</select>";
			obj.parentNode.innerHTML = opt;
	}
	function CalendarComponent_SelectThisMonth(obj){
		var v_select_year = null;
		if (null == v_select_year) {
			try {
				v_select_year = obj.parentNode.parentNode.getElementsByTagName("SPAN")[0].getElementsByTagName("A")[0].innerHTML;
			} catch(e){}
		}
		if (null == v_select_year) {
			try {
				v_select_year = obj.parentNode.parentNode.getElementsByTagName("SPAN")[0].getElementsByTagName("SELECT")[0].value;
			} catch(e){}
		}
		if (null == v_select_year) {
			v_select_year = "2008";
		}
		
		CalendarComponent_Calendar(v_select_year+"-"+obj.value+"-1",obj.parentNode);
		delete v_select_year;
	}

	//---------------------- Common ----------------
	var contextPath = "/ncmccs_culture";
	var openWindowWidth = screen.availWidth * 80 / 100;
	var openWindowHeight = screen.availHeight * 65 / 100;
	var openWindowTop = (screen.availHeight - this.openWindowHeight) / 2;
	var openWindowLeft = (screen.availWidth - this.openWindowWidth) / 2;
	var openWindowStyle = "scrollbars=yes,resizable=yes"
			+ ",width=" + openWindowWidth
			+ ",height=" + openWindowHeight
			+ ",top=" + openWindowTop
			+ ",left=" + openWindowLeft;
	var treeWindowStyle = "scrollbars=yes,resizable=yes"
		+ ",width=" + openWindowWidth/2
		+ ",height=" + openWindowHeight
		+ ",top=" + openWindowTop
		+ ",left=" + openWindowLeft;
			
			
	Common = {
		CreateOptionMenuHtml : function (itemArray) {
			var DELETE_ICON_SRC = contextPath + "/common/images/menu/delete_icon.gif";

			var OptionMenuHtml = "";
			OptionMenuHtml += '<table width="200" border="0" cellpadding="1" cellspacing="1" bgcolor="#002D96">'
			OptionMenuHtml += '  <tr>'
			OptionMenuHtml += '    <td bgcolor="#F6F6F6"><table width="100%" border="0" cellspacing="0" cellpadding="0">'
			for (var i = 0; i < itemArray.length; i++) {
				if (itemArray[i] && itemArray[i].innerHTML) {
					OptionMenuHtml += '      <tr>'
					OptionMenuHtml += '        <td height="25" style="text-indent:30px" class="operating_options" onmouseover="this.className=\'operating_options_mouse_over\'" onmouseout="this.className=\'operating_options\'">'+itemArray[i].innerHTML+'</td>'
					OptionMenuHtml += '      </tr>'
				}
			}
			OptionMenuHtml += '      <tr>'
			OptionMenuHtml += '        <td height="1" style="text-indent:30px" class="operating_options"><hr size="1" color="#6A8CCB" /></td>'
			OptionMenuHtml += '      </tr>'
			OptionMenuHtml += '      <tr>'
			OptionMenuHtml += '        <td height="25" class="operating_options" onmouseover="this.className=\'operating_options_mouse_over\'" onmouseout="this.className=\'operating_options\'"><table width="100%" border="0" cellspacing="0" cellpadding="0">'
			OptionMenuHtml += '          <tr>'
			OptionMenuHtml += '            <td width="22" align="center" valign="middle"><img src="'+DELETE_ICON_SRC+'" alt="DELETE" /></td>'
			OptionMenuHtml += '            <td width="8">&nbsp;</td>'
			OptionMenuHtml += '            <td><a href="javascript:hide($(\'DIVOptionMenuHtml\'));">�رղ˵�</a></td>'
			OptionMenuHtml += '          </tr>'
			OptionMenuHtml += '        </table></td>'
			OptionMenuHtml += '      </tr>'
			OptionMenuHtml += '    </table></td>'
			OptionMenuHtml += '  </tr>'
			OptionMenuHtml += '</table>'
			return OptionMenuHtml;
		},
		
		replaceAll : function (conversionString, inChar, outChar) { // �滻���е��ַ�
			var convertedString = conversionString ;
			try {
				convertedString = conversionString.split(inChar);
				convertedString = convertedString.join(outChar);
			}catch(e){}
			return convertedString;
		},
		
		// ���Ψһ���ַ�
		makeUniqueString : function() { 
			var datetimeVar = new Date();
			var year = parseString(datetimeVar.getYear());
			year = year.substring(2);
			var month = parseString(datetimeVar.getMonth());
			month = parseString(Number(month)+1);
			if(month.length == 1) month = "0" + month;
			var day = parseString(datetimeVar.getDate());
			if(day.length == 1) day = "0" + day;
			var hours = parseString(datetimeVar.getHours());
			if(hours.length == 1) hours = "0" + hours;
			var minutes = parseString(datetimeVar.getMinutes());
			if(minutes.length == 1) minutes = "0" + minutes;
			var seconds = parseString(datetimeVar.getSeconds());
			if(seconds.length == 1) seconds = "0" + seconds;
			// 1 - 3 λ�������
			var randomString = Math.floor(1000 * Math.random());
			var result = year + ""
					+ month + ""
					+ day + ""
					+ hours + ""
					+ minutes + ""
					+ seconds + ""
					+ randomString + "";
			
			return result;
		},
		// onclick="Common.open('a.action',new function(){this.id='1';this.name='name'},'_blank')"
		createForm : function(url, parameters, target, method){
			var newForm = document.createElement("FORM");
			if(!isNull(url))
				newForm.action = url;
			if(!isNull(method))
				newForm.method = method;
			if(!isNull(target))
				newForm.target = target;
			if(!isNull(parameters)) {	
				for(var v in parameters) {
					if(!isObject(parameters[v])) {
						var input = document.createElement("INPUT");
						input.type = "hidden";
						input.name = v;
						input.value = parameters[v];
						newForm.appendChild(input);
						delete input;
					}
				}
			}
			document.body.appendChild(newForm);
			newForm.submit();
			delete newForm;
		},
		//onblur="Common.limitNum(this);"
		limitNum : function(obj) { 
    		if(obj.value.replace(/[\d+]/ig,"").length>0) { 
		        alert('���������֣�'); 
		        obj.value="";
		        obj.focus();
		        return false;
   	 		} 			
		}, 
		//onblur="Common.limitNum(this,length);"
		limitNumLength : function(obj,length) { 
    		if(obj.value.replace(/[\d+]/ig,"").length>0) { 
		        alert('���������֣�'); 
		        obj.value="";
		        obj.focus();
		        return false;
   	 		} 
			if(obj.value.length>length){
				 alert('����������ֳ���'+ length +'λ,���������롣'); 
				 obj.value="";
				 obj.focus();
				 return false;
			}
		},
		//onblur="Common.strlen(this,length);"
		//length Ϊ����
		strlen :function(obj,length){
			var str = obj.value;
			var len = 0;      
	    	for (var i = 0; i < str.length; i++) {      
	        	if(str.charCodeAt(i)<27 || str.charCodeAt(i)>126)
	        		len += 2; 
	        	else len ++;      
	   		}
	   		if(len>length){
		   		 alert('��������ַ����'+ length +'���ַ�,���������롣'); 
				 //obj.value="";
				 obj.focus();
				 return false; 
			 }    		     	
		},
	
		// onkeypress="event.returnValue = Common.isDigit();"
		isDigit : function(){ // ��ʱ��С���̲���ʹ
		  return ((event.keyCode >= 48) && (event.keyCode <= 57));
		},

		// onkeyup="Common.onlyInteger(this)"
		onlyInteger : function(textObject) {
			if(null != textObject) {
				var textValue = parseInt(textObject.value);
				if(isNaN(textValue)) textValue = "";
				textObject.value = textValue;
			}
		},
		// onchange="Common.onlyFloat(this)"
		onlyFloat : function(textObject) {
			if(null != textObject) {
				var textValue = parseFloat(textObject.value);
				if(isNaN(textValue)) textValue = "";
				textObject.value = textValue;
			}
		},
		// onclick="Common.inputDate(this)"
        inputDate : function(inputObj){
			var calendarObj = document.createElement("span");
			calendarObj.innerHTML = CalendarComponent_Calendar(new Date());
			calendarObj.style.position = "absolute";
			calendarObj.targetObj = inputObj;
			inputObj.parentNode.insertBefore(calendarObj,inputObj.nextSibling);
		},
		
		inputMonth : function(inputObj){
			var calendarObj = document.createElement("span");
			calendarObj.innerHTML = CalendarComponent_CalendarMonth(new Date());
			calendarObj.style.position = "absolute";
			calendarObj.targetObj = inputObj;
			inputObj.parentNode.insertBefore(calendarObj,inputObj.nextSibling);
		},
		// onclick="Common.inputDateTime(this)"
		inputDateTime : function(inputObj){
			var showx = event.screenX - event.offsetX + 30;//- 4 - 210 ; // + deltaX;
			var showy = event.screenY - event.offsetY + 15; // + deltaY;
			var result = window.showModalDialog(contextPath+"/common/js/datetime.html", "", "dialogWidth:207px; dialogHeight:240px; dialogLeft:"+showx+"px; dialogTop:"+showy+"px; status:no; directories:yes;scrollbars:no;Resizable=no;");
			if(null != result) {
				inputObj.value = ""+result;
			}
		},
		// onclick="Common.displayOrNot(document.getElementById('one'))"
		displayOrNot : function(objTable){
			if(null != objTable) {
				if("none" == objTable.style.display) {
					objTable.style.display = "";
				} else {
					objTable.style.display = "none";
				}
			} else {
				//alert("null");
			}
		},
		// remove options selected from select object
		deleteBySelected : function(selectId) {
			var selectObject = $(selectId);
			if(!isNull(selectObject)) {
				var selectLength = selectObject.options.length;
				for(var i = selectLength - 1; i >= 0; i--) {
					if(true == selectObject.options[i].selected) {
						selectObject.options[i] = null;	
					}
				}	
			}
		},
		
		// ����html�༭��д�����ݣ���ֵ����Ӧ�Ŀؼ���
		// onsubmit="return true && Common.saveContent(this.elements['element.name']);
		saveContent : function(objContent) {
			try {
				objContent.value = frames.message.document.body.innerHTML;
			}catch(e){}
			return true;
		},
		
		// ������ݿ��е�ֵ��ʾ��html�༭����
		// <script language='javascript'>Common.displayContent(document.form1.elements['element.name'])</ script>
		displayContent : function(objContent) {
			try {
				window.frames["message"].document.open();
				window.frames["message"].document.write(objContent.value);
				window.frames["message"].document.close();
			}catch(e){}
			return true;
		}, 
		
		lengthByte : function(s) {
			return parseString(s).replace(/[^\x00-\xff]/g,'**').length;
		},
		
		// ȫ��ѡ��/ȫ��ȡ��
		checkAllOrNot : function(objCheckBox, isSelected) {
			if(null != objCheckBox) {
				if(isNaN(objCheckBox.length)) {
					objCheckBox.checked = isSelected;
				} else {
					for(var i = 0; i < objCheckBox.length; i++) {
						objCheckBox[i].checked = isSelected;
					}
				}
			}	
		},
		
		// ����ɾ���ʱ��Ҫѡ���¼���˺����Ǽ���Ƿ�����Ŀ��ѡ��
		checkSelect : function(objCheck) {
			var checkCount = 0;
			try {
				if(isNaN(objCheck.length)) {
					if(objCheck.checked == false) {
						alert("��ѡ���¼");
						return false;
					}
				} else {
					for(var i = 0; i < objCheck.length; i++) {
						if(objCheck[i].checked == true) {
							checkCount++;
						}
					}
					if(checkCount == 0) {
						alert("��ѡ���¼");
						return false;
					}
				}
			}catch(e){
				alert("��ѡ���¼");
				return false;
			}
			return true;
		},
		confirm : function(url, message) {
			if(confirm(message)) {
				location.href = url;
			} else {
				var tmp = null;	
			}	
		},
		
		// ȷ��ɾ��
		confirmDelete : function(url) {
			this.confirm(url, "ȷ��ɾ�� ?");	
		},
		// ȷ�����
		confirmClear : function(url) {
			this.confirm(url, "ȷ�Ͻ����л�Ա�������� ?");	
		},
		// ȷ������
		confirmInvalid : function(url) {
			this.confirm(url, "ȷ������ ?");	
		},
		// ȷ�����
		confirmAuditing : function() {
			if(confirm("�Ƿ�ͨ����� ?")){
				return true;
			} else {
				return false;
			}
		},
		tagIndex : null,
		// ��������ʱ ���ӱ��
		addTag : function(tagTemplate, tagContainer, tagControllerName) {
			if(isNull(tagTemplate)) tagTemplate = $("tagTemplate");
			if(isNull(tagContainer)) tagContainer = $("tagContainer");
			if(isNull(tagControllerName)) tagControllerName = "tagController";	
			if(isNull(this.tagIndex)) this.tagIndex = document.getElementsByName(tagControllerName).length - 1; // start with 0
			for(var i = 0; i < tagTemplate.childNodes.length; i++)
				tagContainer.appendChild(tagTemplate.childNodes[i].cloneNode(true));
			var divController = "DIV" == tagContainer.tagName ? tagContainer : getParent(tagContainer, "DIV");
			divController.innerHTML = divController.innerHTML.replaceAll("{?}", this.tagIndex++);
			delete divController;
			this.customerAddTag(tagTemplate, tagContainer, tagControllerName);
		},
		customerAddTag : function(tagTemplate, tagContainer, tagControllerName) {},
		// ��������ʱ ���ٱ��(ɾ��������table)
		decreaseTag : function(tagContainer, tagControllerName) {
			if(isNull(tagContainer)) tagContainer = $("tagContainer");
			if(isNull(tagControllerName)) tagControllerName = "tagController";
			if(tagContainer.childNodes.length > 0) {
				var tagControllerArray = document.getElementsByName(tagControllerName);
				var controlTagName = tagContainer.childNodes[0].tagName;
				for(var i = tagControllerArray.length - 1; i >= 1; i--) {
					if(tagControllerArray[i].checked) {
						tagContainer.removeChild(getParent(tagControllerArray[i], controlTagName));
					}
				}
				delete controlTagName;
				delete tagControllerArray;
			}
			
			this.customerDecreaseTag(tagContainer, tagControllerName);
		},	
		customerDecreaseTag : function(tagContainer, tagControllerName) {},
		// ��������ʱ,�ı���ʾ˳��,direction[UP/DOWN]
		moveTag : function(direction, tagContainer, tagControllerName) {
			if(isNull(tagContainer)) tagContainer = $("tagContainer");
			if(isNull(tagControllerName)) tagControllerName = "tagController";
			if(tagContainer.childNodes.length > 1) { // items count greater than 1, that is to say the container has 2 items at least
				var tagControllerArray = document.getElementsByName(tagControllerName);
				var controlTagName = tagContainer.childNodes[0].tagName;
				var tagTemporaryArray = new Array();
				function TemporaryClass(c, t){this.c=c;this.t=t;}
				for(var i = tagControllerArray.length - 1; i >= 1; i--) // move to temporary array
					tagTemporaryArray.unshift(new TemporaryClass(tagControllerArray[i], getParent(tagControllerArray[i], controlTagName)));
				if(tagTemporaryArray.length > 1) { // swap tag
					if("UP" == direction) {
						for(var i = 1; i < tagTemporaryArray.length; i++) {
							if(true == tagTemporaryArray[i].c.checked) {
								if(false == tagTemporaryArray[i-1].c.checked) {
									var swapTemp = tagTemporaryArray[i-1];
									tagTemporaryArray[i-1] = tagTemporaryArray[i];
									tagTemporaryArray[i] = swapTemp;
									delete swapTemp;
								}
							}
						}
					} else if("DOWN" == direction) {
						for(var i = tagTemporaryArray.length - 2; i >= 0; i--) {
							if(true == tagTemporaryArray[i].c.checked) {
								if(false == tagTemporaryArray[i+1].c.checked) {
									var swapTemp = tagTemporaryArray[i+1];
									tagTemporaryArray[i+1] = tagTemporaryArray[i];
									tagTemporaryArray[i] = swapTemp;
									delete swapTemp;
								}
							}
						}
	
					}
				}
				
				for(var i = 0; i < tagTemporaryArray.length; i++) {
					var checked = tagTemporaryArray[i].c.checked;
					tagContainer.appendChild(tagTemporaryArray[i].t);
					tagTemporaryArray[i].c.checked = checked;
				}
				delete tagTemporaryArray;
				delete tagControllerArray;
			}
			this.customerMoveTag(direction, tagContainer, tagControllerName);
		},
		customerMoveTag : function(direction, tagContainer, tagControllerName) {},
		// ---- open operate layer -----
		operate : function(o, static_position) {	
			var children = o.parentNode.childNodes;
			for(var i = children.length - 1; i >= 0; i--) {
				var SPAN = children[i];
				if("hiddenSpan" == SPAN.id) {
					var DIV = $("DIVOptionMenuHtml");
					if(null == DIV) {
						DIV = document.createElement("DIV");
						DIV.id = "DIVOptionMenuHtml";
						DIV.style.position = "absolute";
						document.body.appendChild(DIV);
					}
					if (!static_position) {
						try {
							if(document.documentElement) { // xhtml
								if (document.all) { // xhtml ie
									DIV.style.top = document.documentElement.scrollTop + (event.clientY + 5);
									DIV.style.left =  document.documentElement.scrollLeft + (event.clientX + 5);
								} else { // xhtml firefox
									DIV.style.top = (document.documentElement.scrollTop + 200) + "px";
									DIV.style.left =  "50px";
								}
							} else { // not xhtml ie
								DIV.style.top = document.body.scrollTop + (event.clientY + 5);
								DIV.style.left =  document.body.scrollLeft + (event.clientX + 5);
							}
						} catch(e){
						}
					}
					// option items
					DIV.innerHTML = this.CreateOptionMenuHtml(SPAN.childNodes);
					show(DIV); 
					break;
				}
				delete SPAN;
			}
			delete children;
		},
		// click icon close(+) or open(-)
		clickTreeImage : function(img, closeImage, openImage) {
			var children = img.parentNode.childNodes;
			if(img.src.indexOf(openImage) != -1) { 
				img.src = closeImage;
				for(var i = 0; i < children.length; i++)
					if("DIV" == children[i].tagName)
						children[i].style.display = "none";
			} else {
				img.src = openImage;
				location.href = "?id=" + img.id;
			}
			delete children;
		},
		// onclick="Common.fileUpload()" : ���õĵط�����ʵ�� document.fileUploadCallback({id:id, fileName:fileName, fileSize:fileSize})
		fileUpload : function() {
			var windowWidth = 300;
			var windowHeight = 120;
			var showx = screen.availWidth / 2;
			var showy = screen.availHeight / 2;
			
			if (document.all) { // ie
				showx = event.screenX - event.offsetX + 30;//- 4 - 210 ; // + deltaX;
				if (showx > screen.availWidth - windowWidth)
					showx = screen.availWidth - windowWidth;
					
				showy = event.screenY - event.offsetY + 15; // + deltaY;
				if (showy > screen.availHeight - windowHeight)
					showy = screen.availHeight - windowHeight;
			} else { // firefox
			}
			var fileUploadWindow = window.open(contextPath+"/common/js/FileUpload.html", "fileUploadWindow", "width="+windowWidth+",height="+windowHeight+",resizable=no,left="+showx+",top="+showy);
			try {
				fileUploadWindow.focus();	
			}catch(e){}
		},
		// -------- open page for select --------------
		previousObject : null,
		clickObject : function(po, currentObject) {
			if(!isNull(this.previousObject)) 
				this.previousObject.className = null;
			if(!isNull(currentObject)) {
				currentObject.className="after";
				this.previousObject = currentObject;
			}
			this.customClickObject(po, currentObject);	
		},
		customClickObject : function(po, currentObject) {
			window.opener.document.selectObjectCallback(po);
			window.close();
		},
		selectWindow : null, 
		selectObject : null, // {hiddenId:'object_id', textId:'object_name'}
		clickSelectObject : function(po, executeMethod, afterExecuteMethod) {
			var _afterExecuteMethod = isNull(afterExecuteMethod)
					? ("window.close()")
					: afterExecuteMethod;
			
			if (isNull(executeMethod)) {
				window.opener.document.selectObjectCallback(po);
			} else {
				alert(executeMethod);
			}
			eval(_afterExecuteMethod);
		},
		
		submitTerminal:function(){
			
		    var list = document.getElementsByName('checkbox');
		    var customerNameStr = "";
		    var customerIdStr = "";		    
		    //alert(list.length);
		    for(var i =0;i<list.length;i++){
		    	if(document.getElementsByName('checkbox')[i].checked){
		    		
		    		var str = "";
		    		str = document.getElementsByName('checkbox')[i].value
		    		var customerName = "";
		    		var customerId="";
		    		customerName =str.substr(str.indexOf(',')+1);
		    		customerId = str.substr(0,str.indexOf(','));
		    		//alert(str.substr(str.indexOf(',')+1));
		    		customerNameStr +=str.substr(str.indexOf(',')+1)+',';
		    		customerIdStr +=customerId+',';
		    	}	
		    }		   
		   
		    parent.window.opener.document.getElementById('customer_name').value=customerNameStr;
		    parent.window.opener.document.getElementById('c_id').value=customerIdStr;
		    parent.window.close();   
        	//parent.parent.window.close();   
        	//top.window.close(); 
      
		},
		
		kkkk:function(){
		    var list = document.getElementsByName('checkbox');
		    var customerNameStr = "";
		    var customerIdStr = "";		    
		    for(var i =0;i<list.length;i++){
		    	if(document.getElementsByName('checkbox')[i].checked){
		    		var str = "";
		    		str = document.getElementsByName('checkbox')[i].value
		    		var customerName = "";
		    		var customerId="";
		    		customerNameStr =str.substr(str.indexOf(',')+1);
		    		customerIdStr = str.substr(0,str.indexOf(','));
		    	}	
		    }		   
		   
		    parent.window.opener.document.getElementById('customer_name').value=customerNameStr;
		    parent.window.opener.document.getElementById('c_id').value=customerIdStr;
		    parent.window.close();   
		},
		
		//--------------------------------------------
		submitAllDeptFrom:function(rowNo){
		    /*
			var list = document.getElementsByName('checkbox');
		    var customerNameStr = "";
		    var customerIdStr = "";		    
		    for(var i =0;i<list.length;i++){
		    	if(document.getElementsByName('checkbox')[i].checked){
		    		var str = "";
		    		str = document.getElementsByName('checkbox')[i].value
		    		var customerName = "";
		    		var customerId="";
		    		customerNameStr =str.substr(str.indexOf(',')+1);
		    		customerIdStr = str.substr(0,str.indexOf(','));
		    	}	
		    }		   
		   */
		   var str = "";
   		str = document.getElementById('checkbox').value
   		var customerName = "";
   		var customerId="";
   		customerNameStr =str.substr(str.indexOf(',')+1);
   		customerIdStr = str.substr(0,str.indexOf(','));
   		
		    parent.window.opener.document.getElementById('customer_name'+rowNo).value=customerNameStr;
		    parent.window.opener.document.getElementById('c_id'+rowNo).value=customerIdStr;
		    parent.window.close();   
		    
		},
		//--------------------------------------------
		
		submitTerminalRadio:function(){
		    var list = document.getElementsByName('checkbox');
		    var customerNameStr = "";
		    var customerIdStr = "";		    
		    for(var i =0;i<list.length;i++){
		    	if(document.getElementsByName('checkbox')[i].checked){
		    		var str = "";
		    		str = document.getElementsByName('checkbox')[i].value
		    		var customerName = "";
		    		var customerId="";
		    		customerNameStr =str.substr(str.indexOf(',')+1);
		    		customerIdStr = str.substr(0,str.indexOf(','));
		    	}	
		    }		   
		   
		    parent.window.opener.document.getElementById('cc_name').value=customerNameStr;
		    parent.window.opener.document.getElementById('cc_id').value=customerIdStr;
		    parent.window.close();   
		},
		submitReserveListRadio:function(){
		    var list = document.getElementsByName('checkbox');
		    var customerNameStr = "";
		    var customerIdStr = "";	
		    var price="";
		    var price_type="";
		    var str = "";
		    for(var i =0;i<list.length;i++){
		    	if(document.getElementsByName('checkbox')[i].checked){
		    		
		    		str = document.getElementsByName('checkbox')[i].value
		    		customerNameStr =str.substr(str.indexOf(',')+1);
		    		customerIdStr = str.substr(0,str.indexOf(','));
		    		//customerIdStr= str.split(',')[0];
		    		//customerNameStr= str.split(',')[1];
		    		//price= str.split(',')[2];
		    		//price_type= str.split(',')[3];
		    		//alert("customerIdStr="+customerIdStr+",customerNameStr="+customerNameStr+",price="+price+",price_type="+price_type);
		    		
		    	}	
		    }		   
		   
		    
		    parent.window.opener.document.getElementById('c_id').value=customerIdStr;	
		    parent.window.opener.document.getElementById('customer_name').value=customerNameStr;
		    //parent.window.opener.document.getElementById('aaa').value=str;
		    parent.window.opener.document.getElementById('c_price').value=str;		    
		    parent.window.close();   
		},		
		allOrCancelCustomer:function(){
			var list = document.getElementsByName('checkbox');
			var cball = document.getElementById('cball');
			if(cball.checked){				
				 for(var i =0;i<list.length;i++){		    			    	
		    		document.getElementsByName('checkbox')[i].checked = true;		    		
		    	}	
		    }				
			else{
				 for(var i =0;i<list.length;i++){		    			    	
		    		document.getElementsByName('checkbox')[i].checked = false;		    		
		    	}			
			}						

		},

		// onclick="Common.selectDepartment({hiddenId:'h',textId:'t'})" : uses document.selectDepartmentCallback({id:'id",name:'name'}) to accept
		selectDepartment : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../system/queryDepartmentForSelect.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		// onclick="Common.selectRole({hiddenId:'h',textId:'t'})" : uses document.selectDepartmentCallback({id:'id",name:'name'}) to accept
		selectRole : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../system/queryRoleForSelect.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
			
		selectGroup : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../system/queryGroupForSelect.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectOrgName : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../system/queryOrganiseForSelect.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},	
		
		selectDicType : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../inventory/queryDicTypeForSelect.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},	
		
		selectCustomerName : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../sale/queryCustomerForSelect.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectCustomerName2 : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../sale/queryCustomerForSelect2.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectTopic : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../info/queryQuestionaryByState.action?questionaryModel.state=2", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectUserByUserType : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../system/queryUserByUserType.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectPresentType : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../member/queryPresentTypeForSelect.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectOrganiseTree : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../system/queryOrganiseCheckBoxTreeAction.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectOrganiseTreeRadio : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../terminal/queryTerminalListRadio.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		selectReserveTreeRadio : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../reserve/queryReserveListRadio.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},		
		selectOrganiseTreeRadioTo : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../system/queryOrganiseRadioToTreeAction.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectTerminalInfo : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../terminal/queryTerminalListInfo.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectReserveCustomerRadio : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../reserve/queryReserveCustomerRadioAction.action?reserveCustomer.state=0", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectCustomerManagerRadio : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../system/queryUserForSelect.action?user.userType=01", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectCustomerDriverRadio : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../inventory/queryDriverForSelect.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectUserName : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../system/queryUserForSelect.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectProductName : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../sale/queryProductForSelect.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectProduct : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../sale/queryProductListForSelect.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectReserveProduct : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../reserve/queryReserveProductForSelect.action?reserveProduct.state=0", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		selectNewProduct : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../sale/queryNewProductForSelect.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		},
		
		selectMemberName : function(selectObject) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../member/queryMemberForSelect.action", "selectWindow", openWindowStyle);
			try {this.selectWindow.focus();}catch(e){}
		} ,
		selectAllDept : function(selectObject , rowNo) {
			this.selectObject = selectObject;
			this.selectWindow = window.open("../pages/tree/role_tree_bussiness_config.jsp?rowNo="+rowNo, "selectWindow", treeWindowStyle);
			try {this.selectWindow.focus();}catch(e){alert(e);}
		}
	}
	
	// ************** select object call back
	// ****** window.opener.document.selectObjectCallback({id:'id',name:'name'});***********
	document.selectObjectCallback = function(po) {
		if(!isNull(Common.selectObject)) {
			$(Common.selectObject.hiddenId).value = po.id;
			$(Common.selectObject.textId).value = po.name;
		}

	}
	
