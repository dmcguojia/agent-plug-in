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
						<td align="right">商户名称</td>
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
			<table id="merchantList">
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			$('#merchantList').datagrid({
				title:'商户列表',
				iconCls:'icon-save',
				height:400,
				nowrap: false,
				striped: true,
				//queryParams:data,
				singleSelect:true,
				url: "<%=basePath%>/merchant/queryMerchant",
				remoteSort: false,
				columns:[[
					{field:'merchNo',title:'商户编号',align:'center',width:120},
					{field:'merchName',title:'商户名称',width:200,align:'center'},
					{field:'merchInsti',title:'所属机构',width:200,align:'center',
						formatter:function(value,rec){
							return "山东工信优服信息技术有限公司";		
						}	
					},
					
					{field:'acqBank',title:'收单机构',width:80,align:'center'
						
					},
					{field:'lawyerName',title:'法人名称',width:80,align:'center'},
 					{field:'lawyTelNo',title:'联系方式',width:100,align:'center'},
					{field:'inTime',title:'创建时间',width:150,align:'center',
 						formatter:function(value,rec){
							return formateTime(value);		
						}	
					},
					{field:'status',title:'状态',width:80,align:'center',
						formatter:function(value,rec){
							if(value=="00"){
								return "在用";	
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
					{field:'APPLY_MERCH_ID',title:'操作',align:'center',
						formatter:function(value,rec){
							if(rec.backupStatus=="01"){
								return '<a href="javascript:backupAdd(\''+rec.merchNo+'\')" style="color:blue;">报备新增</a>'
							}else if(rec.backupStatus=="00"){
								
								return '<a href="javascript:backupUpdate(\''+rec.merchNo+'\')" style="color:blue;">报备修改</a>'
								+"&nbsp;&nbsp;"+
								'<a href="javascript:backupDelete(\''+rec.merchNo+'\')" style="color:blue;">报备删除</a>';	
							}else if(rec.backupStatus=="99"){
								return "";	
							}
							
							
					}}
					
				]],
				pagination:true,
				rownumbers:true
			});
			
		})
		
		function search(){
			var data={
					'merchNo':$('#merch_merchantNo').val(),
					'merchName':$('#merch_merchantName').val()
					};
			$('#merchantList').datagrid('load',data);
		}
		function resize(){
			$('#searchForm :input').val('');
		}
		
		function backupAdd(merchNo){
			
		}
		function backupUpdate(merchNo){
			
		}
		function backupDelete(merchNo){
			
		}
	</script>
</body>