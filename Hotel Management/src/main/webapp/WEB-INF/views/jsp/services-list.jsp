<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec" uri = "http://www.springframework.org/security/tags"%>
<html>
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="<c:url value="/resources/images/icon-title-bar.png" />">

	<title>Management Hotel</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />

    <link href="<c:url value="/resources/css/light-bootstrap-dashboard.css" />" rel="stylesheet"/>
	
    <link href="<c:url value="/resources/css/demo.css" />" rel="stylesheet" />
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" 
    			integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<style>
	.wrap-input100 {
    margin-bottom: 10px;
}

input[type="radio"] {
    margin-left: 20px;
    margin-top: 15px;
}
.display-none {
	display: none;
}
</style>
<body>

<div class="wrapper">
    <jsp:include page="include/side-bar-service.jsp" />

    <div class="main-panel">
		<jsp:include page="include/nav-01.jsp" />

        <div class="content">
            <div class="container-fluid">

            	<div class="row">
            		<nav aria-label="breadcrumb">
					  <ol class="breadcrumb">
					    <li class="breadcrumb-item"><a href="#">Service management</a></li>
					    <li class="breadcrumb-item active" aria-current="page">Service list</li>
					  </ol>
					</nav>
            	</div>
                <div class="row">
                    <div class="col-md-8">
                    <h2 class="roomId">Services List</h2>
                    <table class="table table-striped">
					  <thead>
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Name service</th>
					      <th scope="col">Price</th>
					      <sec:authorize access="hasRole('ROLE_ADMIN')">
					      <th scope="col">Edit</th>
					      <th scope="col">Delete</th>
					      </sec:authorize>
					    </tr>
					  </thead>
					  <tbody>
					  	<c:if test="${not empty listService }">
					  		<c:forEach varStatus="loop" var="service" items="${listService }">
					  		
					  			<tr>
					      			<th scope="row">${loop.count}</th>
					     			  <td>${service.name }</td>
					    			  <td>${service.price }</td>
					    			  
					    			  <sec:authorize access="hasRole('ROLE_ADMIN')">      
					      			  <td><a href="<c:url value="/service/update-service/${service.id }" />">Edit</a></td>
					      			  <td><a href="<c:url value="/service/delete-service/${service.id }" />">Delete</a></td>
					      			  </sec:authorize>
					   		 </tr>
					  		</c:forEach>
					  		
					  	</c:if>
					    		<sec:authorize access="hasAnyRole('ROLE_ADMIN')"> 
					    		<tr>
					    			<td colspan="5">
					    				<a href="<c:url value="/service/add-service"/>"> + Add service</a>
					    			</td>
					    		</tr>
					    		</sec:authorize>
					  </tbody>
					</table>
                    </div>
                    <div class="col-md-4">
                        <jsp:include page="include/card-user.jsp" />
                    </div>

                </div>
            </div>
        </div>


        <footer class="footer">
            
        </footer>

    </div>
</div>


</body>
    <script src="<c:url value="/resources/js/jquery.3.2.1.min.js" />" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script src="<c:url value="/resources/js/demo.js" />"></script>
	<script src="<c:url value="/resources/js/script.js" />"></script>

</html>
