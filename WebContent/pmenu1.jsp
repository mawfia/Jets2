<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Barracks</title>
</head>
<body>
	<p>${images[0]}</p>
	<a href="route.do?data=" >Main Menu</a><br />
	<a href="hmenu1.do" >Hanger</a><br />

<form action="pmenu.do" method="POST">
		<input list="browsers" name="browsers" placeholder="???" pattern="\w" title="1-2 digits">
		<datalist id="browsers"> 
			<c:forEach var="pilot" items="${sessionScope.pilots}">

				<option value="${pilot}">${pilot.lastname}, ${pilot.lastname} ${pilot.middlename}</option>
			</c:forEach> 
		</datalist>
		<button name="operation" value="Previous">Previous</button>
		<button name="operation" value="Home">Home</button>
		<button name="operation" value="Next">Next</button>
		<input type="submit" value="Submit" name="browsers" autofocus>
	</form>

<br />

	<fieldset>
		<legend>Flight Crew Sort/Search Options</legend>
		<form action="pmenu.do" method="POST">
			<select name="sort">
				<option value="0">Alphabetical (Ascending Order)</option>
				<option value="1">Alphabetical (Descending Order)</option>
				<option value="2">Age (Descending Order)</option>
				<option value="3">Experience (Descending Order)</option>
			</select><br /> <input type="submit" value="Sort">
		</form>

		<form action="pmenu.do" method="POST">
			Search Roster:<input type="text" name="search" placeholder="Input Text" > 
			<input type="submit" value="Search"> <input type="reset"><br />
			<input type="checkbox" name="input" value="7" > Name 
			<input type="checkbox" name="input" value="8"> Age
			<input type="checkbox" name="input" value="9"> Experience 
		</form>
	</fieldset>

<f:view>

</f:view>
</body>
</html>