<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>SignUp</title>
</head>
<body>
<h1>
	Please fill your data in order to sign up !  
</h1>
<from action="/SmacrsProject1" method="post">
<p >  Name   </p> <input type="text" name="Name" size="50"> 
<p>  Email  </p> <input type="text" name="Email" size="50"> 
<p>  Address</p> <input type="text" name="Adress" size="50"> 
<p>  Age    </p> <input type="text" name="Age" size="50">
<p>  Salary </p> <input type="text" name="Salary" size="50" > <br>
<br> <button onclick="Data()">SignUp</button > 
<p id="print"></p>

<script>
function Data(){
var Name= document.getElementById("Name").value;
var Email= document.getElementById("Email").value;
var Adress= document.getElementById("Adress").value;
var Age= document.getElementById("Age").value;
var Salary= document.getElementById("Salary").value;

document.getElementById("print").innerHTML="You are successfully sign up ";

}
</script>

</from>







</body>
</html>
