<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="../../top.jsp"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style type="text/css">
table tr td input {
	height: 15px
}

table tr td select {
	height: 20px
}
table tr td.head-title {
	height: 25px;
	background-color: #F0F8FF;
	font-weight: bold;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
	padding-left:5px;
}
table tr td.add {
	height: 25px;
}
table tr td.update {
	height: 25px;
	padding-left: 10px;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}
</style>
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
	
	
	<div id="w" class="easyui-window" closed="true" title="My Window"
	iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
	<div class="easyui-layout" fit="true">
		<div region="center" border="false"
			style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
			<form id="backupForm" action="merchant/addBackupMerchant" method="post">
			<input type="hidden" id="merchNo_f" name="merchNo"/>
				<table width="100%" cellpadding="2" cellspacing="2" style="text-align: left">
					<tr>
						<td colspan="4" class="head-title">结算账户信息</td>
					</tr>
					<tr>
						<td class="update" width="15%">结算账号</td>
						<td class="update" width="35%">
							<span id="account_no"></span>
						</td>
						<td class="update" width="15%">账户名称</td>
						<td class="update" width="35%">
							<span id="account_name"></span>
						</td>
					</tr>
					<tr>
						<td class="update">结算账户类型</td>
						<td colspan="3" class="update">
							<select id="deductSign" name="deductSign"  class="easyui-validatebox" required="true" missingMessage="请选择结算账户类型">
								<option value="">--请选择结算账户类型--</option>
								<option value="0">对公</option>
								<option value="1">对私</option>
							</select>
						</td>
					</tr>
					<tbody id="t0_body">
					<tr>
							<td colspan="4" class="head-title">D0交易手续费</td>
						</tr>
						<tr>
							<td class="update">D0交易费率</td>
							<td class="update">
								<input id="d0FeeRat" name="d0FeeRat"/>（%）
							</td>
							<td class="update">D0交易固定手续费</td>
							<td class="update">
								<input id="d0FixedFee" name="d0FixedFee"/>（元）
							</td>
						</tr>
						<tr>
							<td class="update">D0交易最低手续费</td>
							<td class="update">
								<input id="d0MinFeeAmt" name="d0MinFeeAmt"/>（元）
							</td>
							<td class="update">D0交易封顶手续费</td>
							<td class="update">
								<input id="d0MaxFeeAmt" name="d0MaxFeeAmt"/>（元）
							</td>
						</tr>
					</tbody>
					
				</table>
			</form>
		</div>
		<div region="south" border="false"
			style="text-align: center; padding: 5px 0;">
			<a class="easyui-linkbutton" id="save_button" iconCls="icon-ok" href="javascript:sumitBackupMerchant()" onclick="">保存</a> 
			<a class="easyui-linkbutton" id="cancel_button" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeBackupWin()">取消</a>
		</div>
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
							//0正常 1 2  4 5
							if(value=="01"){
								return "未报备";	
							}else if(value=="00"){
								return "已报备";	
							}else if(value=="99"){
								return "已删除";	
							}else if(value=='0'){
								return "正常";		
							}else if(value=='1'){
								return "销户";	
							}else if(value=='2'){
								return "已审批";	
							}else if(value=='4'){
								return "黑名单";	
							}else if(value=='5'){
								return "冻结";	
							}
							
								
						}		
					},
					
					{field:'merchantId',title:'卡友商户号',width:120,align:'center'},
					{field:'APPLY_MERCH_ID',title:'操作',align:'center',
						formatter:function(value,rec){
							if(rec.backupStatus=="01"){
								return '<a href="javascript:backupAdd(\''+rec.merchNo+'\','+rec.setlCycle+')" style="color:blue;">报备新增</a>'
							}else if(rec.backupStatus=="99"){
								return "";	
							}else {
								
								return '<a href="javascript:backupUpdate(\''+rec.merchNo+'\','+rec.setlCycle+')" style="color:blue;">报备修改</a>'
								+"&nbsp;&nbsp;"+
								'<a href="javascript:backupDelete(\''+rec.merchNo+'\','+rec.setlCycle+')" style="color:blue;">报备删除</a>'
								+"&nbsp;&nbsp;"+
								'<a href="javascript:backupQuery(\''+rec.merchNo+'\','+rec.setlCycle+')" style="color:blue;">报备查询</a>';	
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
		
		function backupAdd(merchNo,setlCycle){
			
			$('#backupForm').attr("action","merchant/addBackupMerchant");
			if(setlCycle > 0){
				$("#t0_body").hide();
				unvalidateD0();
			}else{
				$("#t0_body").show();
				validateD0();
			}
			showBackupWin();
		}
		
		function sumitBackupMerchant(){
			var row = $('#merchantList').datagrid('getSelected');
			$.messager.confirm('提示', '您是否要报备此商户?', function(r){
                if (r){
                	/* $.ajax({
        				type: "POST",
        				url: "merchant/addBackupMerchant?merchNo=" + row.merchNo,
        				dataType: "json",
        				success: function(json) {	
        					$.messager.alert("",json.retInfo,"info");
        					search();
        				}
        			}); */
                	
                	$('#backupForm').form('submit', {
    					onSubmit: function() {
    						return $('#backupForm').form('validate');
    					},
    					success: function(data) {
    						var json =  JSON.parse(data);
    						$.messager.alert("",json.retInfo,"info");
    						search();
    						closeBackupWin();
    					}
    				});
                }
            });
			
			
		}
		
		
		
		function backupUpdate(merchNo,setlCycle){
			$('#backupForm').attr("action","merchant/updateBackupMerchant");
			if(setlCycle>0){
				$("#t0_body").hide();
				unvalidateD0();
				
			}else{
				$("#t0_body").show();
				validateD0();
			}
			showBackupWin();
			
		}
		function backupDelete(merchNo,setlCycle){
			 $.messager.confirm('提示', '您是否要删除此报备商户?', function(r){
	                if (r){
	                	$.ajax({
	        				type: "POST",
	        				url: "merchant/deleteBackupMerchant?merchNo=" + merchNo,
	        				dataType: "json",
	        				success: function(json) {	
	        					$.messager.alert("",json.retInfo,"info");
	        					search();
	        				}
	        			});
	                }
	            });
			
		}
		function backupQuery(merchNo,setlCycle){
              	$.ajax({
      				type: "POST",
      				url: "merchant/queryBackupMerchant?merchNo=" + merchNo,
      				dataType: "json",
      				success: function(json) {	
      					$.messager.alert("",json.retInfo,"info");
      					search();
      				}
      			});
		}
		
		
		
		function showBackupWin(){
			$('#w').window({
				title: '商户报备信息',
				top:150,
		  		width: 800,
		  		height: 260,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				modal: true,
				shadow: true,
				closed: false
			});
			var row = $('#merchantList').datagrid('getSelected');
			$("#account_no").html(row.accName);
			$("#account_name").html(row.settleAccount);
			$("#merchNo_f").val(row.merchNo);
		}
		function closeBackupWin(){
			$('#w').window("close");
		}
		function validateD0(){
			
			$('#d0FeeRat').validatebox({
			    required: true,
			    missingMessage:"请填写D0交易费率"
			});
			$('#d0FixedFee').validatebox({
			    required: true,
			    missingMessage:"D0交易费率D0交易固定手续费"
			});
			$('#d0MinFeeAmt').validatebox({
			    required: true,
			    missingMessage:"D0交易费率D0交易最低手续费"
			});
			$('#d0MaxFeeAmt').validatebox({
			    required: true,
			    missingMessage:"D0交易费率D0交易封顶手续费"
			});
		}
		function unvalidateD0(){
			$('#d0FeeRat').validatebox({
			    required: false,
			    missingMessage:"请填写D0交易费率"
			});
			$('#d0FixedFee').validatebox({
			    required: false,
			    missingMessage:"D0交易费率D0交易固定手续费"
			});
			$('#d0MinFeeAmt').validatebox({
			    required: false,
			    missingMessage:"D0交易费率D0交易最低手续费"
			});
			$('#d0MaxFeeAmt').validatebox({
			    required: false,
			    missingMessage:"D0交易费率D0交易封顶手续费"
			});
		}
	</script>
</body>