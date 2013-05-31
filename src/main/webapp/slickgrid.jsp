<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		<title>SlickGrid example 1: Basic grid</title>
		<link rel="stylesheet" href="css/slickgrid/slick.grid.css" type="text/css" media="screen" charset="utf-8" />
        <link rel="stylesheet" href="css/smoothness/jquery-ui-1.8.5.custom.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/slickgrid/examples.css" type="text/css" media="screen" charset="utf-8" />
	</head>
	<body>
		<table width="100%">
		<tr>
			<td valign="top" width="50%">
				<div id="myGrid" style="width:600px;height:500px;"></div>
			</td>
			<td valign="top">
				<h2>Demonstrates:</h2>
				<ul>
					<li>basic grid with minimal configuration</li>
				</ul>
			</td>
		</tr>
		</table>

		<script language="JavaScript" src="lib/jquery-1.4.3.min.js"></script> 
		<script language="JavaScript" src="lib/jquery-ui-1.8.5.custom.min.js"></script> 
		<script language="JavaScript" src="lib/jquery.event.drag-2.0.min.js"></script> 
        
        <script language="JavaScript" src="javascripts/slickgrid/slick.core.js"></script> 
		<script language="JavaScript" src="javascripts/slickgrid/slick.editors.js"></script> 
		<script language="JavaScript" src="javascripts/slickgrid/slick.grid.js"></script> 
		<script>

		var grid;
		var data = [];
		var columns = [
			{id:"title", name:"Title", field:"title", width:120, cssClass:"cell-title"},
			{id:"duration", name:"Duration", field:"duration"},
			{id:"%", name:"% Complete", field:"percentComplete", width:80, resizable:false, formatter:GraphicalPercentCompleteCellFormatter},
			{id:"start", name:"Start", field:"start", minWidth:60},
			{id:"finish", name:"Finish", field:"finish", minWidth:60},
			{id:"effort-driven", name:"Effort Driven", sortable:false, width:80, minWidth:20, maxWidth:80, cssClass:"cell-effort-driven", field:"effortDriven", formatter:BoolCellFormatter}
		];
 
		var options = {
			//editable: false,
			enableAddRow: false,
			enableCellNavigation: true
		};

		$(function() {
		     //http://localhost:8080/wlrestgrid/services/helloworld/getGridData
             $.getJSON("services/helloworld/getGridData?timire="+Math.min(100, Math.round(Math.random() * 110)) , 
                function(vals){
                $.each(vals, function() { 
                    data.push(this); 
                }); 
                grid = new Slick.Grid($("#myGrid"), data, columns, options); 
            }); 
        });

		</script>

	</body>
</html>
