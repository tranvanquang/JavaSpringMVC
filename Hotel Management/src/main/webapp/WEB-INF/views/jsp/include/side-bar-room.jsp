<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri = "http://www.springframework.org/security/tags"%>
<div class="sidebar" data-color="purple" data-image="assets/img/sidebar-5.jpg">
    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="" class="simple-text">
                    <strong>NHÍ ÓC CHÓ</strong> Hotel
                </a>
            </div>

            <ul class="nav">
            	<sec:authorize access="hasRole('ROLE_ADMIN')"> 
            	<li>
                    <a href="<c:url value="/bookingroom/" />">
                        <i class="fas fa-hotel"></i>
                        <p>Home</p>
                    </a>
                </li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">        
                <li class="active">
                    <a href="<c:url value="/bookingroom/" />">
                        <i class="fas fa-hotel"></i>
                        <p>Room Management</p>
                    </a>
                </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')"> 
                <li>
                    <a href="<c:url value="/services-list/" />">
                        <i class="fas fa-tasks"></i>
                        <p>Service Management</p>
                    </a>
                </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')"> 
                <li>
                    <a href="<c:url value="/room-booked-list/" />">
                        <i class="fas fa-tasks"></i>
                        <p>Service Room</p>
                    </a>
                </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')"> 
                <li>
                    <a href="<c:url value="/guest-list/" />">
                        <i class="fas fa-tasks"></i>
                        <p>Guest Management</p>
                    </a>
                </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN')"> 
                <li>
                    <a href="<c:url value="/bill-list/" />">
                        <i class="fas fa-tasks"></i>
                        <p>Bill management</p>
                    </a>
                </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN')"> 
                <li>
                    <a href="<c:url value="/sales-report-list/" />">
                        <i class="fas fa-tasks"></i>
                        <p>Sales report</p>
                    </a>
                </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')"> 
                <li>
                    <a href="<c:url value="/sales-report-list/" />">
                        <i class="fas fa-tasks"></i>
                        <p>Contact</p>
                    </a>
                </li>
                </sec:authorize>
            </ul>
    	</div>
    </div>