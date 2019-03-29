<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	Welcome ${user}
	<c:forEach items="${products}" var="product">
		<div style="width:30%;height:auto;float:left;margin:1.3%;border-style:solid;border-colour:green;border-radius:5px;border-width:1px">
			<h1>${product.name}</h1>
			<img alt="Oh dear. Could not load image." src="${product.imageURL}" style="width:50%;height:auto">
			<p>${product.description}</p>
		</div>
	</c:forEach>
	
</body>
</html>