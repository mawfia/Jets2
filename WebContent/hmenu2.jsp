<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Aircraft</title>
</head>
<body>

	<p>${images[0]}</p>
	<a href="route.do?data=" >Main Menu</a><br />
	<a href="hmenu1.do" >Hanger</a><br />
	
<!-- 	<fieldset> -->
<!-- 	<legend>Add Aircraft</legend> -->
<%-- 	<form action="AddJet.do" method="POST"> --%>
<!-- 	Manufacturer:<br />	<input type="text" name="manufacturer" ><br />    -->
<!-- 	Model:<br />   		<input type="text" name="model" ><br /> -->
<!-- 	Speed:<br />   		<input type="text" name="speed" ><br /> -->
<!-- 	Range:<br />   		<input type="text" name="range" ><br /> -->
<!-- 	Price:<br />   		<input type="text" name="price" ><br /> -->
<!-- 	Fuel Capacity:<br /><input type="text" name="fuelCapacity" placeholder="(In pounds)"><br /> -->
<!-- 	Photo:<br />   		<input type="text" name="photo" ><br /> -->
<!-- 	Pilot:<br />   		<input type="text" name="pilot" ><br /> -->
<!-- 	<input type="submit" value="Submit">   <input type="reset"> -->
<%-- 	</form> --%>
<!-- 	</fieldset> -->


 <form action="AddJet.do" method="POST">
      <label for="manufacturer">Manufacturer:</label>
      <input type="text" name="Manufacturer" required>
      <br>
      <label for="model">Model:</label>
      <input type="text" name="model" required>
      <br>
      <label for="speed">Speed:</label>
      <input type="text" name="speed" required>
      <br>
      <input type="submit" value="Submit">
    </form>



	
<%-- 	<form:form action="AddJet.do" method="POST" modelAttribute="jet"> --%>
<%-- 		<form:label path="manufacturer">manufacturer:</form:label> --%>
<%-- 		<form:input path="manufacturer" /> --%>
<%-- 		<form:errors path="manufacturer" /> --%>
<!-- 		<br /> -->
<%-- 		<form:label path="model">model:</form:label> --%>
<%-- 		<form:input path="model" /> --%>
<%-- 		<form:errors path="model" /> --%>
<!-- 		<input type="submit" value="Login" /> -->
<%-- 	</form:form> --%>
</body>
</html>