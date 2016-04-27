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
  <spring:url value="/webjars/bootstrap-table/1.9.1/dist/bootstrap-table.min.css" var="bootstrapTable"/>
  <spring:url value="/webjars/bootstrap-table/1.9.1/dist/bootstrap-table.min.js" var="bootstrapTableJS"/>  
  <spring:url value="/resources/css/entertainment.css" var="entertainmentCss"/>
  <spring:url value="/resources/js/script.js" var="tableJS"/>
  
  <link href="${bootstrap}" rel="stylesheet"/>
  <link href="${bootstrapTable}" rel="stylesheet"/>
  <link href="${entertainmentCss}" rel="stylesheet"/>
</head>

<body> 
  <div class="site-wrapper">
    <div class="site-wrapper-inner">
      <div class="cover-container">
        <div class="masthead clearfix">
          <div class="inner">
              <nav>
                <ul class="nav masthead-nav">
                  <li class="active"><a href="/DatabaseProject/">Home</a></li>                  
                </ul>
              </nav>
          </div>
        </div>
        <div class="inner cover">
          <div class="entertainmentDisplay"> 
            <img src="resources/images/music.jpg" class="center-block img-responsive"/>  
            <br>          
            <table class="zebra-style" id="dtable">
              <thead>
                <tr>
                  <th scope="col">
                   
                  <th scope="col">Title</th>
                  <th scope="col">Artist</th>
                  <th scope="col">#</th>
                </tr>
              </thead>
              <tbody>              
               <c:forEach var="music" items="${music}">
                  <tr>
                    <td> <input type="checkbox" class="checkbox" /></td>
                    <td>${music.title} </td>
                    <td>${music.artist}</td>
                    <td>${music.musicKey}</td>
                  </tr>
                </c:forEach>
              <tfoot>
                <tr>
                  <!--<th colspan="2"><a href="javascript:;" class="btn btn-default deleteall" title="dtable">Delete Selected Items</a></th>-->
                  <th colspan="2"><span href="javascript:;" id= "formsubmit" class="btn btn-default deleteall" title="dtable">Delete Selected Items</span></th>
                  <th colspan="2"><span href="javascript:;" id= "formsubmit" class="btn btn-default addall" title="dtable">Add Item(s)</span></th>
                   <div>
                  
                   </div>
                </tr>
              </tfoot>
              </tbody>
            </table>           
          </div>
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
  <script src="${bootstrapTableJS}"></script>
  <script src="${tableJS}"></script>		
</body>
</html>