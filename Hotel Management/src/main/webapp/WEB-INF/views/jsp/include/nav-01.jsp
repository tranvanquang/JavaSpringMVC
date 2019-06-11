<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri = "http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Application - Hotel Management</a>
                </div>
                <div class="collapse navbar-collapse">
                   

                    <ul class="nav navbar-nav navbar-right">
                    
                    <sec:authorize access="hasRole('ROLE_ADMIN')">         
                    	<li>
                           <a href="">
                               <p>Admin</p>
                            </a>
                        </li> 
                     </sec:authorize>
                   		 <li>
                           <a href="">
                               <p>Language</p>
                            </a>
                        </li>  
                        <li>
                           	<a href="">
                               	<p>Account</p>
                            </a>
                        </li>
                        <li>
                            <a href="/Hotel-Management/logout">
                                <p>Log out</p>
                            </a>
                        </li>
						<li class="separator hidden-lg hidden-md"></li>
                    </ul>
                </div>
            </div>
        </nav>