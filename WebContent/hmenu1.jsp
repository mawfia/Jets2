<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Hanger</title>
</head>
<body>
	<p>${images[0]}</p>
	<a href="route.do?data=frog" >Main Menu</a><br />
	<a href="pmenu1.jsp" >Barracks</a>
	

	<fieldset>
	<legend>View Fleet</legend>
	<c:choose>
		<c:when test="${ empty key }">
       		<img src="${fleet.get(keys[0]).photo}" />
    	</c:when>
    	<c:otherwise>
			<img src="${sessionScope.fleet.get(keys[key]).photo}" />    
		</c:otherwise>
	</c:choose>
	<form action="hmenu1.do" method="POST">
		<input type="text" id="ajax" list="json-datalist" name="browsers2" placeholder="Select Aircraft" title="Aircraft Tail Number">
		<datalist id="json-datalist"> 
			<c:forEach var="jet" items="${sessionScope.fleet.values()}">

				<option value="${jet.tailNumber}">${jet.manufacturer} ${jet.model}</option>
			</c:forEach> 
		</datalist>
		<button name="navigation" value="-1">Previous</button>
		<button name="navigation" value="0">Home</button>
		<button name="navigation" value="1">Next</button>
		<input type="submit" value="Select" name="browsers4" autofocus>
		<button name="operation" value="1">Update</button>
		<button name="operation" value="2">Add</button>
		<button name="operation" value="3">Remove</button>
	</form>
	</fieldset>
<br />

	<fieldset>
		<legend>Fleet Sort/Search Options</legend>
		<form action="hmenu2.do" method="POST">
			<select name="sort">
				<option value="0">Alphabetical (Ascending Order)</option>
				<option value="1">Alphabetical (Descending Order)</option>
				<option value="2">Top Speed (Descending Order)</option>
				<option value="3">Max Range (Descending Order)</option>
				<option value="4">MSRP (Descending Order)</option>
				<option value="5">Fuel Capacity (Descending Order)</option>
				<option value="6">Pilot</option>
			</select><br /> <input type="submit" value="Sort">
		</form>

		<form action="hmenu2.do" method="POST">
			Search Fleet:<input type="text" name="search" placeholder="Input Text" required> 
			<input type="submit" value="Search"> <input type="reset"><br />
			<input type="checkbox" name="input" value="7" > Manufacturer 
			<input type="checkbox" name="input" value="8" > Model
			<input type="checkbox" name="input" value="9" > Speed 
			<input type="checkbox" name="input" value="10" > Range
			<input type="checkbox" name="input" value="11" > Fuel Capacity
			<input type="checkbox" name="input" value="12" > Pilot
		</form>
	</fieldset>

</body>
</html>