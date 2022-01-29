<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
    <title>List Customers</title>
<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <!-- reference our style sheet -->

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <form:form action="searchCoustomer" method="get">
           Search customers  <input type="text" name="theSearchField">
            <input type="submit" value="Search" class="add-button" >



        </form:form>

        </br> </br>

        <input type="button" value="Add costumer"
        onclick="window.location.href='showFormForAdd'; return false;"
              class="add-button"
        />

        <!--  add our html table here -->

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th> Action</th>
            </tr>

            <!-- loop over and print our customers -->
            <c:forEach var="tempCustomer" items="${customers}">
<c:url var="updateLink" value="/customer/showFormForUpdate">
<c:param name="customerId" value="${tempCustomer.id}" /> </c:url>
                <c:url var="deleteLink" value="/customer/showFormForDelete">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>
                <tr>
                    <td> ${tempCustomer.firstName} </td>
                    <td> ${tempCustomer.lastName} </td>
                    <td> ${tempCustomer.email} </td>
                    <td> <a href="${updateLink}">Update</a>
                    |
                    <a href="${deleteLink}">Delete</a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>

