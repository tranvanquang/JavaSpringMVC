<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	.f-s-20 {
		font-size: 20px;
		font-weight: bold;
	}
	.maintenance {
		background : yellow;
	}
</style>
<body>

<div class="wrapper">
    <jsp:include page="include/side-bar-room.jsp" />

    <div class="main-panel">
		<jsp:include page="include/nav-01.jsp" />

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="wrap-list-rooms">
                            <div class="kind-of-room">
                                <div class="single-bed select-type-room">Single Room</div>
                                <div class="couple-bed">Douple Room</div>
                            </div>
                            <div class="wrap-rooms">
                                <div class="single-bed-rooms-list">
                                	<c:set var = "single" value="single"/>
                                    <c:if test="${not empty listRoom}">
                                    	<c:forEach var="room" items="${ listRoom}">
                                    		<c:if test="${ room.standard eq single}">
                                    			<a href="<c:url value="/room/${room.name }" />"><div class="room ${ room.status}">${ room.name}</div></a>
                                    		</c:if>
                                    		
                                    	
                                    	</c:forEach>
                                    </c:if>
										<a href="<c:url value="/service/add-service"/>">
											<div class="room">+</div>
										 </a>	
                                </div>
                                <div class="couple-bed-rooms-list display-none">
                                	<c:set var="douple" value="douple"/>
                                    <c:if test="${not empty listRoom}">
                                    	<c:forEach var="room" items="${ listRoom}">
                                    		<c:if test="${ room.standard eq douple}">
                                    			<a href="<c:url value="/room/${room.name }" />"><div class="room ${ room.status}">${ room.name}</div></a>
                                    		</c:if>
                                    		
                                    	
                                    	</c:forEach>
                                    </c:if>
                                    	<a href="<c:url value="/add-douple-room"/>">
											<div class="room">+</div>
										 </a>	
	
                                </div>
                            </div>
                        </div>
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

	<script src="<c:url value="/resources/js/demo.js" />"></script>
	<script src="<c:url value="/resources/js/script.js" />"></script>

</html>
