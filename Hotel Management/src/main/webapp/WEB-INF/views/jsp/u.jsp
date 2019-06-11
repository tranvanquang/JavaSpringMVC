<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>
   <body>
      <table>
         <tr>
            <td>Favorite Web Frameworks</td>
            <td> <% String[] favoriteFrameworks = (String[])request.getAttribute("favoriteFrameworks");
            for(String framework: favoriteFrameworks) {
               out.println(framework);
            }
            %></td>
         </tr>     	  
      </table>  
   </body>
</html>