<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>New User Registration</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
</head>

<body>
<div class="container">
	<h1>Register</h1>
	<form action="register" method="post">
		Username:
		<input name="username" class="form-control"/>
		
		Password:
		<input name="password" type="password" class="form-control"/>
		
		<button class="btn btn-primary btn-block">Register</button>
	</form>

</div>

</body>
</html>