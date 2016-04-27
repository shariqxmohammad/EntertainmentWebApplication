<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Database Project</title>	
	
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
  <spring:url value="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" var="bootstrap"/>
  <spring:url value="/webjars/jquery/1.11.1/jquery.min.js" var="jquery"/>
  <spring:url value="/webjars/bootstrap/3.2.0/js/bootstrap.min.js" var="bootstrapJS"/>
  
  <link href="${bootstrap}" rel="stylesheet"/>
</head>

<body>			
  <div class="container">
    Success<br/>
    
    <table class="table">
      <thead>
        <tr>
          <th>Movie</th>
          <th>Rating</th>
          <th>#</th>
        </tr>
      </thead>
      <c:forEach var="book" items="${books}">
      <tr>
        <td>${book.title} </td>
        <td>${book.author}</td>
        <td>${book.booksKey}</td>
      </tr>
      </c:forEach>
    </table>
  </div>
  
   
  <script src="${jquery}"></script>
  <script src="${bootstrapJS}"></script>		
</body>
</html>