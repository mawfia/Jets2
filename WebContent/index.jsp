<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Welcome to the Hanger</title>
</head>
<body>
	<a href="hmenu1.do?index=1">Hanger</a><br />
	<a href="pmenu1.jsp?">Barracks</a>

	<c:choose>
		<c:when test="${! empty images}">
			<p>${images[0]}</p>
		</c:when>
		<c:otherwise>
			<p>${iDAO[0]}</p>

		</c:otherwise>
	</c:choose>

	<form action="route.do" method="GET">
		<input type="text" name="data" value="${result}" /><br /> <input
			type="submit" value="Submit" /><br />
	</form>
</body>
</html>