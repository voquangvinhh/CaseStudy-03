<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<a href="/staff">Back To Home Page</a>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/staff?action=create">Add New Staff</a>
    </h2>
</center>
<div style="text-align: center">
    <form action="/staff" method="GET">
        <input type="hidden" name="action" value="searchByCountry">
        <input type="text" name="searchCountry" >
        <button type="submit">search</button>
    </form>
</div>
<div>
    <form action="/staff" method="GET">
        <select>
            <option  name="action" value="sortUp">A-Z</option>
            <option value="sortDown">Z-A</option>
        </select>
        <button type="submit">sort</button>
    </form>
</div>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>

        <tr>
            <th>ID</th>
            <th>Name</th>
<%--            <th>birthday</th>--%>
<%--            <th>Sex</th>--%>
            <th>Phone number</th>
            <th>Email</th>
<%--            <th>Address</th>--%>
            <th>Actions</th>
        </tr>
        <c:forEach var="staff" items="${listStaff}">
            <tr>
                <td><c:out value="${staff.id}"/></td>
                <td><c:out value="${staff.name}"></c:out></td>
<%--                <td><c:out value="${staff.birthday}"></c:out></td>--%>
<%--                <td><c:out value="${staff.sex}"></c:out></td>--%>
                <td><c:out value="${staff.phoneNumber}"/></td>
                <td><c:out value="${staff.email}"/></td>
<%--                <td><c:out value="${staff.address}"/></td>--%>
                <td>
                    <a href="/staff?action=detail&id=${staff.id}">Detail</a>
                    <a href="/staff?action=edit&id=${staff.id}">Edit</a>
                    <a href="/staff?action=delete&id=${staff.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>