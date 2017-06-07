<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compound </title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script src="js/jquery.tmpl.js" type="text/javascript"></script>   
<script type="text/javascript">
$(document).ready(function(){
	$("#NoResultText").hide();
	 $("#CompoundTable").hide();
	 
		$('#elementName').text('<%=request.getParameter("ElementName")%>');
	
		var sg ='<%=request.getParameter("SpaceGroup")%>';
	$.get('CompoundServlet', {
		 AtomicNo : <%=request.getParameter("AtomicNo")%>,
		 AE: '<%=request.getParameter("AE")%>',
		 IsShowAll:<%=request.getParameter("IsShowAll")%>,
		 SpaceGroup :sg.length==0? 0:sg ,
		 CrystalSystem : '<%=request.getParameter("CrystalSystem")%>', 
		 }, function(compoundList) {
		
			 $("#NoResultText").hide();
			 $("#CompoundTable").hide();
			 
			 if(compoundList.length==0)
			 {
				 $("#NoResultText").show();
				 
			 }
			 else
				 $("#CompoundTable").show();
			 
			 $("#NoResultText").hide();
				$("#CompoundContent").html('');			
				$("#CompoundListTemplate").tmpl(compoundList).appendTo("#CompoundContent");

	
	});
	

});
function ViewCIF(codId)
{
	
	$.get('SingleCompoundServlet', {
		 CODId : codId 
		 }, function(compound) {
			
			var s = compound.Cif.replace(/(?:\r\n|\r|\n)/g, '<br />');
			$('#CompoundFormula').text(compound.Formula);	

			$('#CifModal').modal();	
			$('#content').html(s);

	});

}

function DownloadCIF(codId)
{
	window.location = 'CIFServlet?CODId='+codId;
}

function GoToSingleCompound(codId)
{
	location.href =  "\SingleCompound.jsp?CODId="+codId;
}
</script>

<script id="CompoundListTemplate"  type="text/x-jquery-tmpl">
<tr>

	
	<td><a style="cursor:pointer;" onclick="GoToSingleCompound({{html CodID}})"> {{html Formula }}</a></td>
	<td>{{html SpaceGroup}}</td>
	<td>{{html CrystalSystem}}</td>
	  <td>{{html SpaceGroupName}}</td>
<td><a style="cursor: pointer;" onclick="ViewCIF({{html CodID}});">View</a> | <a style="cursor: pointer;"  onclick="DownloadCIF({{html CodID}})">Download</a>


</tr>
</script>	

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<script>
function goBack() {
    window.history.back();
}
</script>
<style type="text/css">
.main{
margin-top:-40px;
}
td,th{
	text-align: center;
}
.modal .modal-body {
    max-height: 420px;
    overflow-y: auto;
}

</style>
</head>
<body>
<jsp:include page="topBar.jsp"/>
<jsp:include page="leftSidebar.jsp"/>

<div class="main">


<div class="page-header">
	<h1><span id='elementName'></span> </h1>
</div>
<div style="float:right;"><button class="btn btn-secondary" onclick="goBack()">Go Back</button></div>
<div style="clear:both;"></div>

	<table id="CompoundTable" class="table table-striped">
	    <thead>
	      <tr>
	        
	        
	 
	<th>Formula</th>
	<th>Space Group</th>
	<th>Crystal System</th>
	  <th>Space Group Name</th>
	  <th>CIF</th>

	      </tr>
	    </thead>
	    <tbody id="CompoundContent">
	    
	    </tbody>
	    </table>
	    
	    
	         <div id="NoResultText" >
	    No Result Matched
	    </div>
	
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