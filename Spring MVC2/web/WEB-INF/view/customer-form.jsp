<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <tile>
        Save Customer
    </tile>

    <link type="text/css"
    rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>

</head>




<body>
<div id="wrapper">
    <div id="header">
        <h2>Customer Relationship Manager</h2>
    </div>
</div>


<div id = container>
<h3> Save customer </h3>
    </br> </br>
 <form:form action="saveCustomer" modelAttribute="customer" method="post">
    <form:hidden path="id"></form:hidden>

     <table>
         <tbody>
         <tr>
             <td><label>Firsr name:</label></td>
             <td><form:input path="firstName"/></td>
         </tr>
         <tr>
             <td><label>Last name:</label></td>
             <td><form:input path="lastName"/></td>
         </tr>
         <tr>
             <td><label>Email:</label></td>
             <td><form:input path="email"/></td>
         </tr>
         <tr>
             <td> </td>
             <td> <input type="submit" value="Save" class="save"></td>
         </tr>
         </tbody>
     </table>
 </form:form>

    <div style="clear; both;"></div>
    <a href="${pageContext.request.contextPath}/customer/list">List of Customers</a>




</div>

</body>
</html>