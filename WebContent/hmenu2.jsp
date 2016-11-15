<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Aircraft</title>
<link rel="stylesheet" type="text/css" href="hmenu1.css">

</head>
<body>

	<p>${images[0]}</p>
	<a href="route.do?data=" >Main Menu</a><br />
	<a href="hmenu1.do" >Hanger</a><br />

<fieldset>
<legend>Add Aircraft</legend>
 	  <form action="AddJet.do" method="POST">
  	  <label for="tailNumber">Tail Number:</label>
      <input type="text" name="tailNumber" maxlength="15" pattern="[a-zA-z0-9]" size="30" title="Alphanumeric characters only" placeholder="Leave blank to auto assign tail number">
      <br>
      <label for="manufacturer">Manufacturer:</label>
      <input type="text" name="manufacturer" maxlength="30"  required>
      <br>
      <label for="model">Model:</label >
      <input type="text" name="model" maxlength="30" required>
      <br>
      <label for="speed">Speed:</label >
      <input type="text" name="speed" pattern="\d{0,10}\.{0,1}\d{0,2}" title="1-12 Deceimal Numbers Only">
      <br>
       <label for="range">Range:</label>
      <input type="text" name="range" pattern="\d{0,10}\.{0,1}\d{0,2}" title="1-12 Deceimal Numbers Only">
      <br>
       <label for="price">price:</label>
      <input type="text" name="price" pattern="\d{0,10}\.{0,1}\d{0,2}" title="1-12 Deceimal Numbers Only">
      <br>
       <label for="fuelCapacity">Fuel Capacity:</label>
      <input type="text" name="fuelCapacity" pattern="\d{0,10}\.{0,1}\d{0,2}" title="1-12 Deceimal Numbers Only">
      <br>
      <input type="submit" value="Submit"> <input type="reset">
      </form>
</fieldset>


	
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