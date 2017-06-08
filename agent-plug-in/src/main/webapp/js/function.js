
var formatDate = function (formatDate, formatString) {
    if(formatDate instanceof Date) {
        var months = new Array("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
        var yyyy = formatDate.getFullYear();
        var yy = yyyy.toString().substring(2);
        var m = formatDate.getMonth();
        var mm = (m+1) < 10 ? "0" + (m+1) : (m+1);
        var mmm = months[m];
        var d = formatDate.getDate();
        var dd = d < 10 ? "0" + d : d;
 
        var h = formatDate.getHours();
        var hh = h < 10 ? "0" + h : h;
        var n = formatDate.getMinutes();
        var nn = n < 10 ? "0" + n : n;
        var s = formatDate.getSeconds();
        var ss = s < 10 ? "0" + s : s;
 
        formatString = formatString.replace(/yyyy/i, yyyy);
        formatString = formatString.replace(/yy/i, yy);
        formatString = formatString.replace(/mmm/i, mmm);
        formatString = formatString.replace(/mm/i, mm);
        formatString = formatString.replace(/m/i, m);
        formatString = formatString.replace(/dd/i, dd);
        formatString = formatString.replace(/d/i, d);
        formatString = formatString.replace(/hh/i, hh);
        formatString = formatString.replace(/h/i, h);
        formatString = formatString.replace(/nn/i, nn);
        formatString = formatString.replace(/n/i, n);
        formatString = formatString.replace(/ss/i, ss);
        formatString = formatString.replace(/s/i, s);
 
        return formatString;
    } else {
        return "";
    }

}

 

function formateTime(time){
	return formatDate(new Date(time),"yyyy-mm-dd");
}
function formateDateTime(time){
	return formatDate(new Date(time),"yyyy-mm-dd hh:nn:ss");
}
function remove_a()
{
	$('a').focus(function(){
	  this.blur();
	});
}






   // 清除表单数据
   function clearForm(formName) { 
     var formObj = document.forms[formName]; 
     var formEl = formObj.elements; 
     for (var i=0; i<formEl.length; i++) 
     { 
        var element = formEl[i]; 
        if (element.type == 'submit') { continue; } 
        if (element.type == 'reset') { continue; } 
        if (element.type == 'button') { continue; } 
        if (element.type == 'hidden') { continue; } 
 
        if (element.type == 'text') { element.value = ''; } 
        if (element.type == 'textarea') { element.value = ''; } 
        if (element.type == 'checkbox') { element.checked = false; } 
        if (element.type == 'radio') { element.checked = false; } 
        if (element.type == 'select-multiple') { element.selectedIndex = 0; } 
        if (element.type == 'select-one') { element.selectedIndex = 0; } 
     } 
   }
   

function isInteger(id, msg)
{
   var a = isNumber(id, msg);

   if(a){
     var value = $('#' + id).val();   

	 if(value.indexOf('.') > 0){
       alert(msg);
	   $('#' + id).focus();
	   return false;
     }
   }

   return a;
}

function checkInt(value)
{
  // var re = /^-?\\d+$/;
  var re = /^[0-9]*[1-9][0-9]*$/;
  if (!re.test(value))
  {
    return false;
  }
  return true;
}  

function isNumber(id, msg)
{
   var value = $('#' + id).val();
   var a = /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/.test(value);
   if(!a){
     alert(msg);
	 $('#' + id).focus();
	 return a;
   }
   
   return true;
}



 function is_null(id, msg){
    var j = $('#' + id);
	if(j.val() == null || j.val() == ''){
         alert(msg);
		 j.focus();
		 return true;
	}

	return false;
  }

  


  // 设置表格的样式
  function table_css(id)
  {
    // 查询表格
	var jtable = $('#' + id);

    // 设置表格的title
	var jth = jtable.find('th');
	jth.each(function(i){
	  if(i == 0){
        $(this).css('border-left', '1px solid #5A83A1');
	  }
      if(i > 0){
        $(this).css('background-image', 'url(common/images/table_th.gif)');
        $(this).css('background-repeat', 'no-repeat');
	  }

	  if(i == jth.length - 1){
        $(this).css('border-right', '1px solid #5A83A1');
	  }
	});

	// 设置td
	var jbody = jtable.find('tbody');
	jbody.each(function(i){
	   var bgurl = '';

	   if(i == jbody.children().length - 1){
         bgurl = 'table_td_bot2';
	   }

	   if(i == jbody.children().length - 2){
         // bgurl = 'table_td_bot1';
	   }

       if(i == 0){
         bgurl = 'table_td_top';
	   }

	   $(this).find('td').each(function(j){
		 if(j > 0){
		  if(bgurl == ''){
            $(this).css('border-left', '1px solid #fff');
		  } else {
		    $(this).css('background-image', 'url(common/images/' + bgurl + '.gif)');
            $(this).css('background-repeat', 'no-repeat');
          }
		  if(i == 0){
            //
		  }
		 }
	   });
	});
  }


// 格式化数字
function FormatNumber(money)        // nAfterDot小数位数
{
	if(/[^0-9\.]/.test(money)){return  money; } 
	money=money.replace(/^(\d*)$/,"$1.");  
	money=(money+"00").replace(/(\d*\.\d\d)\d*/,"$1");  
	money=money.replace(".",",");  
	var re=/(\d)(\d{3},)/;  
	while(re.test(money)){  
		money=money.replace(re,"$1,$2");  
	}  
	money=money.replace(/,(\d\d)$/,".$1");  
	return   money.replace(/^\./,"0.")  
}

/*
 * 取所在周的第一天，参数格式2009-01-01
 */
function getFirstDay(cdate){
	var checkArray= new Array();
	checkArray = cdate.split("-");
	var date=new Date(checkArray[0],checkArray[1]-1,checkArray[2]);
	// var lastday = new Date(date.getYear(),date.getMonth(),0).getDate();
	// //得到本月最大的日期
	var WeekFirstDay = new Date(date.getYear(),date.getMonth(),date.getDate()-date.getDay()+1); // 得到本周的第一天
	
	var year = WeekFirstDay.getYear()+'';
	var month = WeekFirstDay.getMonth()+1+'';
	var day = WeekFirstDay.getDate()+'';

	if(month.length == 1){
		month = '0'+month;
	}
	if(day.length == 1){
		day = '0'+day;
	}
	return year+'-'+month+'-'+day; 
}

/*
 * 取所在周的最后一天，参数格式2009-01-01
 */
function getLastDay(cdate){
	var checkArray= new Array();
	checkArray = cdate.split("-");
	var date=new Date(checkArray[0],checkArray[1]-1,checkArray[2]);
	var WeekFirstDay = new Date(date.getYear(),date.getMonth(),date.getDate()-date.getDay()+1); // 得到本周的第一天
	var WeekLastDay = new Date(WeekFirstDay.getYear(),WeekFirstDay.getMonth(),WeekFirstDay.getDate()+6); // 得到本周的最后一天

	var year = WeekLastDay.getYear()+'';
	var month = WeekLastDay.getMonth()+1+'';
	var day = WeekLastDay.getDate()+'';

	if(month.length == 1){
		month = '0'+month;
	}
	if(day.length == 1){
		day = '0'+day;
	}
	return year+'-'+month+'-'+day; 
}


/*
 * 判断数组是否已包含了某个元素
 */
Array.prototype.contains = function(obj) {
	var i = this.length;
	while (i--) {
		if (this[i] === obj) {
			return true;
		}
	}
	return false;
}


// iframe自动适应高度
function SetCwinHeight(obj)
{
  var cwin=obj;
  if (document.getElementById)
  {
    if (cwin && !window.opera)
    {
      if (cwin.contentDocument && cwin.contentDocument.body.offsetHeight)
        cwin.height = cwin.contentDocument.body.offsetHeight*5; // FF NS
      else if(cwin.Document && cwin.Document.body.scrollHeight)
        cwin.height = cwin.Document.body.scrollHeight*5;// IE
    }
    else
    {
        if(cwin.contentWindow.document && cwin.contentWindow.document.body.scrollHeight)
            cwin.height = cwin.contentWindow.document.body.scrollHeight+500;// Opera
    }
  }
}
// 清除分页信息
function clearpage(){
	$('#__pageIndex').val('');
	$('#total_page').val('');
}


function formatFloat(value)
{
    return Math.round(value*Math.pow(10, 2))/Math.pow(10, 2);
}

function randomColor()
{
     var str = '0123456789abcdef';
    var color = '#';
    for(i = 0; i < 6; i++)
     {
        color = color + str.charAt(Math.random() * 16);
    }
     return color;
} 
// 取URL中的参数
function getParameterByName(name) {
    var match = RegExp('[?&]' + name + '=([^&]*)')
                    .exec(window.location.search);
    return match && decodeURIComponent(match[1].replace(/\+/g, ' '));
}

function endsWith(str, suffix) {
    return str.indexOf(suffix, str.length - suffix.length) !== -1;
}
function cleanFile(id){    
	var _file = document.getElementById(id);    
	if(_file.files){        
		_file.value = "";    
	}else{        
		if (typeof _file != "object"){ 
			return null; 
		}        
		var _span = document.createElement("span");        
		_span.id = "__tt__";        
		_file.parentNode.insertBefore(_span,_file);        
		var tf = document.createElement("form");        
		tf.appendChild(_file);        
		document.getElementsByTagName("body")[0].appendChild(tf);        
		tf.reset();        
		_span.parentNode.insertBefore(_file,_span);        
		_span.parentNode.removeChild(_span);        
		_span = null;        
		tf.parentNode.removeChild(tf);    
	}
}