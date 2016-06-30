<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calendario-Acceso</title>
<link rel="stylesheet" href="./codebase/login.css">
<link rel="stylesheet" href="./codebase/alertify.core.css">
<link rel="stylesheet" href="./codebase/alertify.default.css">
<link rel="stylesheet" href="./codebase/alertify.bootstrap.css">
<link rel="stylesheet" type="text/css" href="./codebase/sweetalert.css">
</head>
<body>

	<div class="container">
	
	  <div id="login-form">
	
	    <h3>Iniciar Sesión</h3>
	
	    <fieldset>
	
	      <form id="form_Login" action="Login" method="post" >
	      
	      	
	      	<input id="cUsuario" name="cUsuario" type="text" required value="Usuario" onBlur="if(this.value=='')this.value='Usuario'" onFocus="if(this.value=='Usuario')this.value=''">
	      	<input id="cPassword" name="cPassword" type="password" required value="Password" onBlur="if(this.value=='')this.value='Password'" onFocus="if(this.value=='Password')this.value=''">
	        
	        <input type="button" value="Ingresar" onclick="validarUsuario();">
	        
	
	        <footer class="clearfix">
	
	          <!--  <p><span class="info">?</span><a href="http://localhost:8080/cachorros/">Registrate aquí</a></p> -->
	
	        </footer>
	
	      </form>
	
	    </fieldset>
	
	  </div> <!-- end login-form -->
	
	</div>
	<script type="text/javascript" src="codebase/js/login.js"></script>
	<script type="text/javascript" src="codebase/js/lib/alertify.js"></script>
	<script type="text/javascript" src="codebase/js/lib/alertify.min.js"></script>
	<script type="text/javascript" src="codebase/js/lib/sweetalert.min.js"></script>
	<script type="text/javascript" src="codebase/js/lib/jquery-1.10.2.js"></script>
</body>
</html>