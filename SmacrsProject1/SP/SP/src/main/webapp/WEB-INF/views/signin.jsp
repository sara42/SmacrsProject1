<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>SignUp</title>
</head>
<body>
	<h1>Please fill your data in order to sign up !</h1>
	<form action="#" th:action="@{/signin}" th:object="${user}"
		method="post">
		<p>Email</p>
		<input type="text" th:field="*{UserEmail}" size="50">
		<p>Password</p>
		<input type="text" th:field="*{UserPassword}" size="50"> <br>
		<br> <input type="submit" value="Login" />
	</form>
</body>
</html>