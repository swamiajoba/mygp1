<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>Error Page</h1>
  <p>Application has encountered an error. Please contact support on ...</p>

  
  <h2>  Failed URL: ${url}</h2>
   <h2> Exception:  ${exception.message} </h2>
        <c:forEach items="${exception.stackTrace}" var="ste">    ${ste} 
    </c:forEach>
  
</body>
</html>