<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Aircraft from Inventory</title>
<link rel="stylesheet" type="text/css" href="hmenu1.css">
</head>
<body>
	<p>${images[0]}</p> 
	<a href="route.do?data=" >Main Menu</a><br />
	<a href="hmenu1.do" >Hanger</a><br />
	
	<fieldset>
	<legend>Remove Aircraft</legend>
	<c:choose>
		<c:when test="${ empty remove }">
       		<img src="${fleet.get(keys[0]).photo}" /><br />
    	</c:when>
    	<c:otherwise>
			<img src="${sessionScope.fleet.get(remove.tailNumber).photo}" /> <br />   
		</c:otherwise>
	</c:choose> 
	<form action="RemoveJet.do" method="POST">
		<input type="text" id="ajax" list="json-datalist" name="browsers2" placeholder="Select Aircraft" title="1-2 digits" size="40" value="${remove.tailNumber}">
		<datalist id="json-datalist"> 
			<c:forEach var="jet" items="${sessionScope.fleet.values()}">

				<option value="${jet.tailNumber} ${jet.manufacturer} ${jet.model}"></option>
			</c:forEach> 
		</datalist><button name="Select" value="true">Select</button><br />

      <input type="submit" value="Submit"> <input type="reset">
      </form>
	</form>
	</fieldset>
</body>
</html>