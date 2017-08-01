<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compound </title>

 <link rel="stylesheet" href="css/ChemDoodleWeb.css" type="text/css">
 <script type="text/javascript" src="js/ChemDoodleWeb.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script src="js/jquery.tmpl.js" type="text/javascript"></script> 
<script type="text/javascript">

$(document).ready(function(){
	$.get('SingleCompoundServlet', {
		Id: <%=request.getParameter("Id")%> 
		 }, function(compound) { 
			 Compound= compound;
			
			LoadCif(compound.Cif); 
		//	$("#cifViz").html(new String(compound.Cif));
				
			 
			 $("#CompoundName").text(compound.Formula);
			
			 
		//	 $("#CompoundDetailsContent").html('');			
			$("#CompoundDetailsTemplate").tmpl(compound).appendTo("#CompoundDetailsContent");


	
	});
	
	
});
function LoadCif(cif)
{
	var MAZfile = cif;// you can change the 1s here to generate a supercell
	var maz = ChemDoodle.readCIF(MAZfile, 1, 1, 1);

	//setup component
	var crystalTransformer = new ChemDoodle.TransformCanvas3D('mol-canvas', 500, 500);
	// set the atom/bond representation to 'Ball and Stick', although other representations are also useful for zeolites
	crystalTransformer.specs.set3DRepresentation('Ball and Stick');
	// set the background color to black
	crystalTransformer.specs.backgroundColor = '#000000';
	// declare an orthographic perspective to more easily see the zeolite pattern
	crystalTransformer.specs.projectionPerspective_3D = false;
	// set the line widths for the unit cell to be 1.5 pixels
	crystalTransformer.specs.crystals_unitCellLineWidth = 1.5;
	// set the unit cell line color to white
	crystalTransformer.specs.shapes_color = 'white';
	// set the unit cell line width to 2
	crystalTransformer.specs.shapes_lineWidth = 2;
	crystalTransformer.specs.atoms_displayLabels_3D = true;

	 

	  
	  crystalTransformer.loadContent([maz.molecule], [maz.unitCell]);

}

function ViewCIF()
{
	var s = Compound.Cif.replace(/(?:\r\n|\r|\n)/g, '<br />');
	$('#CompoundFormula').text(Compound.Formula);	

	$('#CifModal').modal();	
	$('#content').html(s);
}

function DownloadCIF()
{
	var downloadId;	
	if(Compound.Source ='cod')
		downloadId = Compound.CodID;
	else
		downloadId =  Compound.ICSDID;
	window.location = 'CIFServlet?downloadId='+downloadId+"&source="+Compound.Source;
}





function ViewCompoundProperties(propType)
{
	$('#CompoundFormulaName').text(Compound.Formula);	

	var src = '../static/View/';
	var srcId = '';
	if (Compound.Source=='cod')
		srcId  = Compound.CodID;
	else 
		srcId  = Compound.ICSDID;
	if(propType=='dos1'){
		src = src + 'dos/'+Compound.Source+'/'+srcId+'100.png';
			
	}
	if(propType=='dos2'){		
		src = src + 'dos/'+Compound.Source+'/'+srcId+'200.png';
	}
	if(propType=='dos3'){
		src = src + 'dos/'+Compound.Source+'/'+srcId+'300.png';
			
	}
	
	else if(propType=='bs')
	{
	//	src = src + 'bandstructure/'+Compound.Source+'/'+srcId+'.spaghetti_ps00.png';
		
	}
	else if(propType=='fs')
	{
		src = '';
		
	}
	else if(propType=='hf')
	{
		src = 'DataImage/hf.png';
		
	}
	
	  $('#BandViewer').modal('show');
     //$('#Viewer').on('shown.bs.modal', function () {
    	//GetBandstructures(Compound.Id);
    	//alert('hello');
    	//});
     GetBandstructures(Compound.Id);
}


function ViewDos(id)
{
	GetDos(id);	
}

</script>


<script id="CompoundDetailsTemplate"  type="text/x-jquery-tmpl">




<td>
<table class="table table-striped">
<tr>
	<td><strong>Source</strong></td>	
	<td>{{html Source}} - {{if Source == "cod"}}{{html CodID}}
{{/if}}
{{if Source == "icsd"}}{{html ICSDID}}
{{/if}}
</td>
</tr>
<tr>
	<td><strong>Formula</strong></td>	
	<td>{{html Formula}}</td>
</tr>
<tr>
	<td><strong>Space Group</strong></td>
		<td>{{html SpaceGroup}}</td>

</tr>
<tr>
	<td><strong>Crystal System</strong></td>
		<td>{{html CrystalSystem}}</td>

</tr>
<tr>
	<td><strong>Space Group Name</strong></td>
		<td>{{html SpaceGroupName}}</td>

</tr>
<tr>
	<td><strong>Space Group Name Hall</strong></td>
		<td>{{html SymmetrySpaceGroupNameHall}}</td>

</tr>
<tr>
	<td><strong>Cell Angle Alpha</strong></td>
		<td>{{html CellAngleAlpha}}</td>
</tr>
<tr>
	<td><strong>Cell Length A</strong></td>
		<td>{{html CellLengthA}}</td>
</tr>
<tr>
	<td><strong>Cell Length B</strong></td>
		<td>{{html CellLengthB}}</td>

</tr>
<tr>
	<td><strong>Cell Length C</strong></td>
		<td>{{html CellLengthC}}</td>

</tr>
<tr>
	<td><strong>Volume</strong></td>
		<td>{{html CellVolume}}</td>

</tr>

{{if BSExists}}
<tr>
<td><strong>BandStructure</strong></td>
<td><button style="width:180px;" class="btn btn-secondary" onclick="ViewCompoundProperties('bs')">BandStructure</button></td>
</tr>
{{/if}}	 



{{if DosExists}}
<tr>
<td><strong>Dos</strong></td>
<td><button style="width:180px;" class="btn btn-secondary" onclick="ViewDos({{html Id}})">Dos</button></td>
</tr>
{{/if}}	 
<tr>
<td><strong>CIF</strong></td>
<td>
<a style="cursor: pointer;" onclick="ViewCIF();">View</a> 
</td>
</tr>

</table>
</td>
	
</script>	


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<style type="text/css">
.main{
margin-top:-40px;
}


.modal .modal-body {
    max-height: 800px;
    overflow-y: auto;
}
.modal {
  text-align: center;
}

@media screen and (min-width: 768px) {
  .modal:before {
    content: " ";
    display: inline-block;
    height: 100%;
    vertical-align: middle;
  }
}

.modal-dialog {
  display: inline-block;
  text-align: center;
  vertical-align: middle;
}

</style>
<script>
function goBack() {
    window.history.back();
}
</script>
</head>
<body>
<jsp:include page="topBar.jsp"/>
<jsp:include page="leftSidebar.jsp"/>

<div class="main">

<jsp:include page="BandstructureChart.jsp"/>
<jsp:include page="DosChart.jsp"/>

<div class="page-header">
	<h1><span id='CompoundName'></span> </h1>
</div>

	<div style="float:right;"><button class="btn btn-secondary" onclick="goBack()">Go Back</button></div>	    

	<div style="clear:both;"></div>
	
	
	
		    <table style="padding-top: 10px;" class="table" >
	    <tbody >
	   
	    <tr id="CompoundDetailsContent"><td></td>
	    <td >
	    	 <figure> 
			
			<canvas id="mol-canvas"></canvas>
  			</figure>
	    
	    </td></tr>
	    </tbody>
	    </table>


<div  id="CifModal"  class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg">
     
      <!-- Modal content-->
      
       
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" id="CompoundFormula"></h4>
        </div>
        <div class="modal-body">
       
<div id="content" ></div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  	
	
</div>


</body>
</html>