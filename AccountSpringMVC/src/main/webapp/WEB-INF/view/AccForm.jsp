<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>Add New Account</h1>  
       <form:form method="post" action="save" modelAttribute="acc">    
        <table >    
         <tr>    
          <td>Account Number : </td>   
          <td><form:input path="aid"  /> <form:errors path="aid" cssStyle="color:red"/></td>  
         </tr>    
         <tr>    
          <td>Customer Name :</td>    
          <td><form:input path="customer" /><form:errors path="customer" cssStyle="color:red"/></td>  
         </tr>   
         <tr>    
          <td>Balance :</td>    
          <td><form:input path="balance" /><form:errors path="balance" cssStyle="color:red"/></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    

</body>
</html>