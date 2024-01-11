<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2" width="70%" cellpadding="2">  
<tr><th>Account No. </th><th>Name</th><th>Balance in Rs. </th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="acc" items="${alist}">   
   <tr>  
   <td>${acc.aid}</td>  
   <td>${acc.customer}</td>  
   <td>${acc.balance}</td>  

   <td><a href="editacc/${acc.aid}">Edit</a></td>  
   <td><a href="deleteacc/${acc.aid}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="accform">Add New Account</a>  
</body>
</html>