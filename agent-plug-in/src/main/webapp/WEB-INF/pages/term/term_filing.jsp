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
		singleSelect:true,
		url:"term/queryTerm",
		columns:[[
			{field:'termNo',title:'终端编号',align:'center',width:100},
	    	{field:'merchName',title:'商户名称',width:100,align:'center'},
		    {field:'merchNo',title:'商户编号',width:120,align:'center'},
			{field:'zdxhparaName',title:'终端型号',width:120,align:'center'},	
 			{field:'serialNum',title:'终端序列号',width:100,align:'center'},									
			{field:'jjtzfparaName',title:'机具投资方',width:120,align:'center'},
			{field:'instAddr',title:'安装地址',width:120,align:'center'},
 			{field:'status',title:'状态',width:120,align:'center'},
 			{field:'apply_term_id',title:'操作',align:'center',width:80,
			    formatter:function(value,rec){
					return '<a href="pages/pos/queryOneApplyfAction.action?termId='+value+'&sort=88" style="color:blue;">详细信息</a>';

			   }
			}
		]],
		pagination:true,
		rownumbers:true
	});
})
function search(){
    var data={'termNo':$('#termNo').val(),'merchNo':$('#merchNo').val()};
   $('#posList').datagrid('load',data);
}
function resize(){
	$('#searchForm :input').val('');
}
</script>
</body>