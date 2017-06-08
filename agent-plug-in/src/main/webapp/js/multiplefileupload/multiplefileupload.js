var FileInputList = function() {
	this.sequence = 0;
}
FileInputList.prototype.add=function(inputFilename,creatbuttonId){
	this.sequence=this.sequence+1;
	var fileInput = new FileInput(this.sequence,inputFilename,creatbuttonId);
	fileInput.creat();
}

var FileInput = function(id, inputFilename, creatbuttonId) {
	this.id = id;
	this.name = inputFilename;
	this.creatbuttonId = creatbuttonId;
}
// 创建文件选择框 
FileInput.prototype.creat = function() {
	var textfieldid = "textfield" + this.id;
	var buttonid = "button" + this.id;
	var deletebuttonid = "deletebutton" + this.id;
	var divid = "uploadDiv"+this.id;
	var buttonText = "<div id='" + divid + "'>";
	buttonText += "<input type='text' name='" + textfieldid + "' id='"
			+ textfieldid + "' class='type-file-text' />";
	buttonText += "<input type='button' name='" + buttonid + "' id='"
			+ buttonid + "' value='浏览...' class='type-file-button' />";
	buttonText += "<input name='" + this.name
			+ "' type='file' class='type-file-file' id='upload' size='25'/>";
	buttonText += "<input type='button' class='type-add-button' id='" + deletebuttonid
			+ "' value='删除'/>"
	buttonText += "</div>";
	$(buttonText).insertBefore("#" + this.creatbuttonId);
	
	var currentUpload = $("#" + buttonid).siblings("input[name=" + this.name + "]") ;  
	
	$("#" + buttonid).click(function() {
		currentUpload.trigger('click');
	});

	currentUpload.change(function() {
		$("#" + textfieldid).val(currentUpload.val());
	});

	$("#" + deletebuttonid).click(function() {
		$("#" +divid).remove();
	});
}

/*var PayInstList = function() {
	this.sequence = 1;
}

PayInstList.prototype.add=function(fileInputList){
	this.sequence=this.sequence+1;
	var payInst = new PayInst(this.sequence,fileInputList);
	payInst.creat();
}

var PayInst = function(id,fileInputList) {
	this.id = id;
	this.fileInputList=fileInputList;
}
// 创建对账机构 
PayInst.prototype.creat = function() {
	var fileInputList = this.fileInputList;
	var payinstselecttridexp = "payinstselect" ;
	var payinstselecttrid = "payinstselect" + this.id;
	var fileaddtrid = "fileadd" + this.id;
	var deletepayinstbuttonid = "deletepayinstbutton" + this.id;
	var addFileSelectButtonid = "addFileSelectButton"+this.id;
	var payinstbuttonid = "payinstbutton"+this.id;
	var payinsttextfieldid ="payinsttextfield"+this.id;
	var htmltext = "<tr id='"+payinstselecttrid+"'><td align='center' width='20%'>对账机构</td>";
	htmltext+="<td align='center' width='30%'><select id='payinistid"+this.id+"' required='true' class='easyui-validatebox'></select></td>";
	htmltext+="<td colspan='2' align='left'><input type='button' id='"+deletepayinstbuttonid+"' value='删除机构' class='type-file-button'/> </td></tr>";
	htmltext+="<tr id='"+fileaddtrid+"' height='26'><td align='center'>对账文件</td>";
	htmltext+="<td colspan='3'><input type='text' name='textfield' id='"+payinsttextfieldid+"' class='type-file-text' />";
	htmltext+="<input type='button' name='button' id='"+payinstbuttonid+"' value='浏览...' class='type-file-button' />";
	htmltext+="<input name='upload' type='file' class='type-file-file' id='upload' size='25' />"
	htmltext+="<input type='button' id='"+addFileSelectButtonid+"' value='添加文件'/></td></tr>";
	$(htmltext).insertAfter($("tr[id*=" + payinstselecttridexp+"]:last").next("tr"));
	$("#" + deletepayinstbuttonid).click(function() {
		$("#" +payinstselecttrid).remove();
		$("#" +fileaddtrid).remove();
	});
	
		var currentUpload = $("#" + payinstbuttonid).siblings("input[name=upload]") ;  
		$("#"+payinstbuttonid).click(function() {
			currentUpload.trigger('click');});

		currentUpload.change(function() {
		$("#"+payinsttextfieldid).val(currentUpload.val());
	});
	
	$("#"+addFileSelectButtonid).click(function(){fileInputList.add("upload",addFileSelectButtonid)});
	
}*/
