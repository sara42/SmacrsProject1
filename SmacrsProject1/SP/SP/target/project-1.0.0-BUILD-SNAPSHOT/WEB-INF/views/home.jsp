<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>SignUp</title>
</head>
<body>
	<h1>Please fill your data in order to sign up !</h1>
	<form action="#" th:action="@{/signup}" th:object="${user}"
		method="post">
		<p>Name</p>
		<input type="text" th:field="*{UserName}" size="50">
		<p>Email</p>
		<input type="text" th:field="*{UserEmail}" size="50">
		<p>Address</p>
		<input type="text" th:field="*{UserAdress}" size="50">
		<p>Age</p>
		<input type="text" th:field="*{UserAge}" size="50">
		<p>Salary</p>
		<input type="text" th:field="*{UserSalary}" size="50"> <br>
		<br> <input type="submit" value="SignUp" />
	</form>
</body>
</html>
