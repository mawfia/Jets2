<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<form action="UpdateJet.do" method="POST">
		Manufacturer:<br>   <input type="text" name="manufacturer" ><br>   
		Model:<br>   <input type="text" name="model" ><br>
		Speed:<br>   <input type="text" name="speed" ><br>
		Range:<br>   <input type="text" name="range" ><br>
		Price:<br>   <input type="text" name="price" ><br>
		Fuel Capacity:<br>   <input type="text" name="fuelCapacity" placeholder="(In pounds)"><br>
		<input list="browsers1" name="browsers2" placeholder="???" pattern="\w" title="1-2 digits"><br />
		<datalist id="browsers3"> 
			<c:forEach var="jet" items="${fleet}">

				<option value="${jet.manufacturer}">${jet.model},${jet.pilot}</option>
			</c:forEach> 
		</datalist>
		<input type="submit" value="Update" name="browsers4" autofocus> 
		<input type="reset">
	</form>
	</fieldset>

</body>
</html>