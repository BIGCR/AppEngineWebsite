<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.google.apiservices.GoogleAPIKeyHelper"%>
<html><!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">   
    <!--custom css-->
    <link href="css/custom.css" rel="stylesheet" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Google App Engine</title>
</head>

<body onLoad="langDropdownInit()">
	
	<div class="col-md-6">
		<form class="form-inline">
			<div class="form-group">
			  <label class="sr-only">String To Translate</label>
			  <input type="text" class="form-control" id="textToTranslate">
			</div>
			<div class="form-group">
			  <label class="sr-only">Language to translate to</label>
			  <input type="text" class="form-control" id="targetLang">
			</div>			
			<!-- <button type="submit" class="btn btn-primary">Sign in</button> -->
			<button id="translateButton" class="btn btn-default">Button</button>
		</form>
	</div>	
	
	<button id="translateText" class="btn btn-default">Translate</button>
	<button id="langInit" class="btn btn-default">LangInit</button>
	<button id="webFonts" class="btn btn-default">WebFonts</button>
	
	<div id="languageDropDown" class="dropdown"></div>
	
	
	<table>
      <tr>
        <td colspan="2" style="font-weight:bold;">Available Servlets:</td>        
      </tr>
      <tr>
        <td><a href="googlewebapp">GoogleWebApp</a></td><br>
        <td><a href="googletranslateapi">GoogleTranslateAPI</a></td>
        <td><a href="googlewebfontsapiservlet">GoogleWebFontServlet</a></td>
      </tr>
    </table>	
</body>

	<script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	<script src="js/googleAPI.js" type="text/javascript"></script>
</html>
