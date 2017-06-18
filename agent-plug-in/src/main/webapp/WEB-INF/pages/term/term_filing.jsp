<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="../../top.jsp"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<body>
<div style="padding-top:2px;margin-left:2px;margin-right:2px" id="continer">
    <div id="p" class="easyui-panel" title="查询条件" style="height:90px;padding-top:5px;background:#fafafa;"  iconCls="icon-save" collapsible="true">
		<form action="" id="searchForm" name="searchForm">
			<table width="99%">
				<tr>
					<td align="right">商户编号</td>
					<td align="left" style="padding-left:5px"><input id="merch_merchantNo" name="merchant.merchantNo" value="" /></td>
					<td align="right">终端号</td>
					<td align="left" style="padding-left: 5px"><input id="merch_merchantName" name="merchant.merchantName" value=""/></td>
					<td align="right"></td>
				</tr>
				<tr>
					<td align="right" colspan="4">
						<a href="javascript:search()"  class="easyui-linkbutton" iconCls="icon-search">查询</a>
						<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div style="margin-top:2px">
		<table id="posList">
		</table>
	</div>
</div>
<script type="text/javascript">
$(function(){
	$('#posList').datagrid({
		title:'终端列表',
		iconCls:'icon-save',
		height:400,
		singleSelect:false,
		url:"term/queryTerm",
		columns:[[
			{title:'',checkbox:true},
			{field:'termNo',title:'终端编号',align:'center',width:100},
	    	//{field:'merchName',title:'商户名称',width:100,align:'center'},
		    {field:'merchNo',title:'商户编号',width:120,align:'center'},
			{field:'zdxhparaName',title:'终端型号',width:120,align:'center'},	
 			{field:'serialNum',title:'终端序列号',width:100,align:'center'},									
			{field:'jjtzfparaName',title:'机具投资方',width:120,align:'center'},
			{field:'instAddr',title:'安装地址',width:120,align:'center'},
 			{field:'status',title:'状态',width:120,align:'center',
				formatter:function(value,rec){
					if(value=="00"){
						return "在用";	
					}else if(value=="42"){
						return "停机";	
					}else if(value=="62"){
						return "撤机";	
					}
						
				}		
 			},
 			{field:'backupStatus',title:'报备状态',width:80,align:'center',
				formatter:function(value,rec){
					if(value=="01"){
						return "未报备";	
					}else if(value=="00"){
						return "已报备";	
					}else if(value=="99"){
						return "已删除";	
					}
						
				}		
			},
 			{field:'apply_term_id',title:'操作',align:'center',width:80,
			    formatter:function(value,rec){
			    	if(rec.backupStatus=="01"){
						return '<a href="javascript:backupAdd(\''+rec.termNo+'\')" style="color:blue;">报备新增</a>'
					}else if(rec.backupStatus=="00"){
						
						return '<a href="javascript:backupUpdate(\''+rec.termNo+'\')" style="color:blue;">报备修改</a>'
						+"&nbsp;&nbsp;"+
						'<a href="javascript:backupDelete(\''+rec.termNo+'\')" style="color:blue;">报备删除</a>';	
					}else if(rec.backupStatus=="99"){
						return "";	
					}

			   }
			}
		]],
		pagination:true,
		rownumbers:true,
		toolbar: [{
			id: 'btnadd',
			text: '批量报备',
			iconCls: 'icon-add',
			handler: function() {
				batchBackUp();
			}
		}]
	});
})
function search(){
    var data={'termNo':$('#merch_merchantName').val(),'merchNO':$('#merch_merchantNo').val()};
   $('#posList').datagrid('load',data);
}
function resize(){
	$('#searchForm :input').val('');
}

function backupAdd(termNo){
	$.messager.confirm('提示', '您是否要报备此终端?', function(r){
        if (r){
        	$.ajax({
        		type: "POST",
        		url: "term/addBackupTerm?termNo=" + termNo,
        		dataType: "json",
        		success: function(json) {	
        			$.messager.alert("",json.retInfo,"info");
        			search();
        		}
        	});
        }
    });
	
}
function backupUpdate(termNo){
	$.messager.confirm('提示', '您是否要更新此报备终端?', function(r){
        if (r){
        	$.ajax({
        		type: "POST",
        		url: "term/updateBackupTerm?termNo=" + termNo,
        		dataType: "json",
        		success: function(json) {	
        			$.messager.alert("",json.retInfo,"info");
        			search();
        		}
        	});
        }
    });
	
}
function backupDelete(termNo){
	$.messager.confirm('提示', '您是否要删除此报备终端?', function(r){
        if (r){
        	$.ajax({
        		type: "POST",
        		url: "term/deleteBackupTerm?termNo=" + termNo,
        		dataType: "json",
        		success: function(json) {	
        			$.messager.alert("",json.retInfo,"info");
        			search();
        		}
        	});
        }
    });
}
function batchBackUp(){
	var rows = $('#posList').datagrid('getSelections');
	var termNo = "";
	$.each(rows, function(key, value) {
		termNo += value.termNo+";";
	})
	if(termNo==""){
		$.messager.alert("","请选择终端","info");
		
	}else{
		$.messager.confirm('提示', '您是否要报备此匹终端?', function(r){
	        if (r){
	        	$.ajax({
	        		type: "POST",
	        		url: "term/batchBackupTerm",
	        		data:"termNo=" + termNo,
	        		dataType: "json",
	        		success: function(json) {	
	        			$.messager.alert("",json.retInfo,"info");
	        			search();
	        		}
	        	});
	        }
	    });
	}
	
}
</script>
</body>