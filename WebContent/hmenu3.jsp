<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Aircraft</title>
</head>
<body>
	<p>${images[0]}</p> 
	<a href="route.do?data=" >Main Menu</a><br />
	<a href="hmenu1.do" >Hanger</a><br />
	
	<fieldset>
	<legend>Update Aircraft</legend>
	<c:choose>
		<c:when test="${ empty index }">
       		<img src="${fleet.get(keys[0]).photo}" /><br />
    	</c:when>
    	<c:otherwise>
			<img src="${sessionScope.fleet.get(keys[0]).photo}" /> <br />   
		</c:otherwise>
	</c:choose>
	<form action="UpdateJet.do" method="POST">
		<input type="text" id="ajax" list="json-datalist" name="browsers2" placeholder="Select Aircfat" title="1-2 digits">
		<datalist id="json-datalist"> 
			<c:forEach var="jet" items="${sessionScope.fleet.values()}">

				<option value="${jet.tailNumber}">${jet.manufacturer} ${jet.model}</option>
			</c:forEach> 
		</datalist><br />

      <label for="manufacturer">Manufacturer:</label>
      <input type="text" name="manufacturer">
      <br>
      <label for="model">Model:</label >
      <input type="text" name="model">
      <br>
      <label for="speed">Speed:</label >
      <input type="text" name="speed" >
      <br>
       <label for="range">Range:</label>
      <input type="text" name="range" >
      <br>
       <label for="price">price:</label>
      <input type="text" name="price" >
      <br>
       <label for="fuelCapacity">Fuel Capacity:</label>
      <input type="text" name="fuelCapacity" >
      <br>
      <input type="submit" value="Submit"> <input type="reset">
      </form>
	</form>
	</fieldset>
</body>
</html>



<!-- <fieldset> -->
<!-- 	<legend>Update Aircraft</legend> -->
<%-- 	<img src="${fleet.get(keys[0]).photo}" />	<br/> --%>

<!-- 		<input type="text" id="ajax" list="json-datalist" name="update" placeholder="Enter/Select Tail Number" > -->
<!-- 		<datalist id="json-datalist">  -->
<%-- 			<c:forEach var="jet" items="${sessionScope.fleet.values()}"> --%>
<%-- 				<option value="${jet.tailNumber}">${jet.manufacturer} ${jet.model} ${jet.pilot}</option> --%>
<%-- 			</c:forEach>  --%>
<!-- 		</datalist> -->
<!--  	<form action="UpdateJet.do" method="POST"> -->
<!--       <label for="manufacturer">Manufacturer:</label> -->
<!--       <input type="text" name="manufacturer" maxlength="30" > -->
<!--       <br> -->
<!--       <label for="model">Model:</label > -->
<!--       <input type="text" name="model" maxlength="30" > -->
<!--       <br> -->
<!--       <label for="speed">Speed:</label > -->
<!--       <input type="text" name="speed" > -->
<!--       <br> -->
<!--        <label for="range">Range:</label> -->
<!--       <input type="text" name="range" > -->
<!--       <br> -->
<!--        <label for="price">price:</label> -->
<!--       <input type="text" name="price" > -->
<!--       <br> -->
<!--        <label for="fuelCapacity">Fuel Capacity:</label> -->
<!--       <input type="text" name="fuelCapacity" > -->
<!--       <br> -->
<!--       <input type="submit" value="Submit"> <input type="reset"> -->
<!--       </form> -->
<!-- 	</fieldset> -->