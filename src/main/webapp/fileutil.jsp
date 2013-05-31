<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'fileutil.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="css/slickgrid/slick.grid.css" type="text/css" media="screen" charset="utf-8" />
        <link rel="stylesheet" href="css/smoothness/jquery-ui-1.8.5.custom.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/slickgrid/examples.css" type="text/css" media="screen" charset="utf-8" />
	</head>

	<body>
		<h3>Directory Browser that displays only (gif, jpg, JPG, png, txt, jpeg)</h3>
		<table width="100%">
		<tr>
			<td valign="top" width="50%">
				<div id="myGrid" style="width:600px;height:500px;"></div>
			</td>
		</tr>
		</table>
		<hr>
		<h3>Upload file (Uses Iframe)</h3>
		<form id="myform" action="services/document/upload" method="POST" enctype="multipart/form-data">
			<div id="fileSection">
				File:
				<input type="file" name="fileup0" />
			</div>
			<input type="submit" value="Upload file" />
		</form>


	</body>
	
	    <script language="JavaScript" src="lib/jquery-1.4.3.min.js"></script> 
		<script language="JavaScript" src="lib/jquery-ui-1.8.5.custom.min.js"></script> 
		<script language="JavaScript" src="lib/jquery.event.drag-2.0.min.js"></script> 
		<script language="JavaScript" src="lib/jquery.form.js"></script>
        
        <script language="JavaScript" src="javascripts/slickgrid/slick.core.js"></script> 
		<script language="JavaScript" src="javascripts/slickgrid/slick.editors.js"></script> 
		<script language="JavaScript" src="javascripts/slickgrid/slick.grid.js"></script> 
	<script>
	$(function() {
		loadGrid();
		ajaxFileUpload();
		downloadFile();
		deleteFile();
	});
	
	
	function downloadFile(){
	 $(".download-file").click(function(event) {
			event.preventDefault();
			if ($("#downloadFrame").length == 0) {
				$('<iframe id="downloadFrame" style="display:none;" src="about:none"></iframe>').appendTo('body');
			}
			$("#downloadFrame").attr("src", $(this).attr("href"));
		});
	}
	
	function deleteFile(){
	 $(".delete-file").live("click", function(event){
	   event.preventDefault();
	   $.getJSON($(this).attr("href"), function(vals) {
		    loadGrid();
		});
	 });
	}
	
	function ajaxFileUpload(){
		function cb_success (rt, st, xhr, wf) {
		   loadGrid();
		   $('#myform').resetForm();
		}
		var options = {
	        success: cb_success,
	        dataType: 'html',
	        contentType: 'text/plain',
	        method: 'POST'
    	};
    	$('#myform').ajaxForm(options);
	}
	
	function loadGrid(){
	  var grid;
		var data = [];
		var downloadFileFormatter = function(row, cell, value, columnDef, dataContext) {
		    return "<a class='download-file' href='services/document/download?blobKey=" + dataContext["name"] + "'>Download</a>" +
		    "&nbsp;<a class='delete-file' href='services/document/delete?blobKey=" + dataContext["name"] + "'>Delete</a>";
		};
		var columns = [
			{id:"download", name:"Actions", formatter:downloadFileFormatter, width:110},
			{id:"name", name:"Name", field:"name", width:120, cssClass:"cell-title"},
			{id:"size", name:"Size", field:"size"},
			{id:"url", name:"Path", field:"url", width:200},
			{id:"contentType", name:"Type", field:"contentType", width:50}
		];
 
		var options = {
			enableAddRow: false,
			enableCellNavigation: true
		};
		
		 $.getJSON("services/document/list?timire="+Math.min(100, Math.round(Math.random() * 110)) ,  function(vals){
                $.each(vals, function() { 
                    data.push(this); 
                }); 
                grid = new Slick.Grid($("#myGrid"), data, columns, options); 
            }); 
	}
</script>
</html>
