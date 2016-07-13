<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script   src="https://code.jquery.com/jquery-1.12.4.min.js"   integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="   crossorigin="anonymous"></script>
 
<script src="js/jquery.tmpl.js" type="text/javascript"></script>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<script id="movieTemplate" type="text/x-jquery-tmpl">
	<li>
		<b>{{html Name}}</b> ({{html ReleaseYear}})
	</li>
</script>

<ul id="movieList"></ul>

<script type="text/javascript">

	var movies = [
		{ Name: "The Red Violin", ReleaseYear: "1998" },
		{ Name: "Eyes Wide Shut", ReleaseYear: "1999" },
		{ Name: "The Inheritance", ReleaseYear: "1976" }
	];

	$( "#movieTemplate" ).tmpl( movies )
		.appendTo( "#movieList" );

</script>



 
 
</body>
</html>