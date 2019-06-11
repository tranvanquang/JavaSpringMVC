<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <jsp:include page="include/side-bar-guest.jsp" />

    <div class="main-panel">
		<jsp:include page="include/nav-01.jsp" />

        <div class="content">
            <div class="container-fluid">

            	<div class="row">
            		<nav aria-label="breadcrumb">
					  <ol class="breadcrumb">
					    <li class="breadcrumb-item"><a href="#">Guest management</a></li>
					    <li class="breadcrumb-item active" aria-current="page">Guest list</li>
					  </ol>
					</nav>
            	</div>
                <div class="row">
                    <div class="col-md-8">
                    <h2 class="roomId">Guest List</h2>
                    <table class="table table-striped">
					  <thead>
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Name</th>
					      <th scope="col">idNumber</th>
					      <th scope="col">phoneNumber</th>
					      <th scope="col">room</th>
					      <th scope="col">checkinDate</th>
					      <th scope="col">checkoutDate</th>
					      <th scope="col">Edit</th>
					      <th scope="col">Delete</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<c:if test="${not empty listGuest }">
					  		<c:forEach varStatus="loop" var="guest" items="${listGuest }">
					  		
					  			<tr>
					      			<th scope="row">${loop.count}</th>

					     			  <td>${guest.name }</td>
					     			  <td>${guest.idNumber }</td>
					    			  <td>${guest.phoneNumber }</td>
					    			  <td>${guest.room }</td>
					    			  <td>${guest.checkinDate }</td>
					    			  <td>${guest.checkoutDate }</td>
					      			<td><a href="<c:url value="/guest/update-guest/${guest.id }" />">Edit</a></td>
					      			<td><a href="<c:url value="/guest/delete-guest/${guest.id }" />">Delete</a></td>
					   		 </tr>
					  		</c:forEach>
					  		
					  	</c:if>
					    
					    		<tr>
					    			<td colspan="5">
					    				<a href="<c:url value="/guest/add-guest"/>"> + Add guest</a>
					    			</td>
					    		</tr>
					  </tbody>
					</table>
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
