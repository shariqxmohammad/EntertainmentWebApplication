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
            <img src="resources/images/books.jpg" class="center-block img-responsive"/>  
            <br>                   
            <table class="zebra-style" id="dtable">
              <thead>
                <tr>
                  <th scope="col">
                    
                  <th scope="col">Title</th>
                  <th scope="col">Author</th>
                  <th scope="col">#</th>
                </tr>
              </thead>
              <tbody>              
                <c:forEach var="book" items="${books}">
                  <tr>
                    <td> <input type="checkbox" class="checkbox" name="selectedItems" 
                    	value="<c:out value="${book.booksKey}"/>"/></td>
                    <td><c:out value="${book.title}"/></td>
                    <td><c:out value="${book.author}"/></td>
                    <td><c:out value="${book.booksKey}"/></td>
                  </tr>
                </c:forEach>
              <tfoot>
                <tr>
                  <!--<th colspan="2"><a href="javascript:;" class="btn btn-default deleteall" title="dtable">Delete Selected Items</a></th>-->
                  <th colspan="2"><span href="javascript:;" id= "formsubmit" class="btn btn-default deleteall" title="dtable">Delete Selected Items</span></th>
                  <th colspan="2"><span href="javascript:;" id= "formsubmit" class="btn btn-default addall" title="dtable">Add Item(s)</span></th>
               <!-- 	<th colspan="2"><span href="javascript:;" id = "formsubmit" class="btn btn-default" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo" title="dtable">Add Book(s)</button></span>
               	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h2 class="modal-title" id="exampleModalLabel"><p class="text-muted">Add Book</p></h2>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="control-label"><p class="text-muted">Title:</p></label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="control-label" ><p class="text-muted">Author:</p></label>
             <input type="text" class="form-control" id="recipient-name">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="addToDatabase()">Add to Database!</button>
      </div>
    </div>
  </div>
</div> -->
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