<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Hanger</title>
</head>
<body>
	<p>${images[0]}</p>
	<a href="route.do?data=" >Main Menu</a><br />
	<a href="pmenu1.jsp" >Barracks</a>
	
	<fieldset>
	<legend>View Fleet</legend>
	<form action="hmenu1.do" method="POST">
		<input list="browsers1" name="browsers2" placeholder="???" pattern="\w" title="1-2 digits">
		<datalist id="browsers3"> 
			<c:forEach var="jet" items="${fleet}">

				<option value="${jet.manufacturer}">${jet.model}</option>
			</c:forEach> 
		</datalist>
		<button name="operation" value="Previous">Previous</button>
		<button name="operation" value="Home">Home</button>
		<button name="operation" value="Next">Next</button>
		<input type="submit" value="Select" name="browsers4" autofocus>
		<button name="operation" value="Update">Update</button>
		<button name="operation" value="Add">Add</button>
		<button name="operation" value="Next">Remove</button>
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