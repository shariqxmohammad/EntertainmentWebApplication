<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Database Project</title>	
	
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
  <spring:url value="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" var="bootstrap"/>
  <spring:url value="/webjars/jquery/1.11.1/jquery.min.js" var="jquery"/>
  <spring:url value="/webjars/bootstrap/3.2.0/js/bootstrap.min.js" var="bootstrapJS"/>
  <spring:url value="/resources/css/index.css" var="indexCss"/>
  
  <link href="${bootstrap}" rel="stylesheet"/>
  <link href="${indexCss}" rel="stylesheet"/>
</head>

<body>	
		
  <!--<div class="container">
    <form action="test" method="post">
      <input type="Submit" name="Submit">
    </form>
  </div>-->
  <div class="site-wrapper">
    <div class="site-wrapper-inner">
      <div class="cover-container">
        <div class="masthead clearfix">
          <div class="inner cover">
            <p class="text-center">MIS 6323.501 - Object Oriented Programming - S16</p>
              <nav>
                
              </nav>
          </div>
        </div>
        
        <div class="inner cover">
          <img src="resources/images/title.jpg" class="center-block img-responsive"/>
          <!-- <img src="resources/images/title.jpg" class="center-block" alt="Responsive image"> -->
          <p class="lead"><em>View or organize your stuff below.</em></p>                  
          <p><form action="books" method="post" ><input type="Submit" value="Books" name="Submit" class="btn btn-lg btn-default"></form></p>
          <p> <form action="movies" method="post" ><input type="Submit" value="Movies" name="Submit" class="btn btn-lg btn-default"> </form></p>
          <p><form action = "music" method = "post"><input type ="Submit" value = "Music" name = "Submit" class ="btn btn-lg btn-default"></form></p>
          <p><form action = "contacts" method = "post"><input type ="Submit" value = "Contact" name = "Submit" class ="btn btn-lg btn-default"></form></p>
        </div>
        
        <div class="mastfoot">
          <div class="inner">
            <p>Created by <a href="http://www.shariqmohammad.com">Shariq Mohammad</a></p>
          </div>
        </div>
      </div>
    </div>
  </div>
    
  <script src="${jquery}"></script>
  <script src="${bootstrapJS}"></script>		
</body>
</html>