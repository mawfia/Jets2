<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Welcome to the Hanger</title>
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
	<a href="hmenu1.do?data=" >Hanger</a><br />
	<a href="pmenu1.jsp?">Barracks</a>
	<div class="container">
		<c:choose>
			<c:when test="${! empty images}">
				<img src="${images[2]}" />
			</c:when>
		<c:otherwise>
			<img src="${iDAO[0]}"/>
		</c:otherwise>
	</c:choose>
	</div>
	<form action="route.do" method="GET" class="center">
	<input type="text" name="username" value="" placeholder="Username"/>
	<input type="text" name="data" value="" placeholder="Password"/><br /> <input
			type="submit" value="Submit" id="login"/><input type="reset" id="login"><br />
	</form>
</body>
</html>