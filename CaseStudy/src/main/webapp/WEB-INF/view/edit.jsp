<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/13/2023
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Staff Management Application</title>
</head>
<body>
<a href="/staff">Back To Home Page</a>
<center>
    <h1>Staff Management</h1>
    <h2>
        <a href="staff?action=staff">List All Staff</a>
    </h2>
    <c:if test="${message != null}">
        <h1>Update succesfully</h1>
    </c:if>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Staff
                </h2>
            </caption>
            <c:if test="${staff != null}">
                <input type="hidden" name="id" value="<c:out value='${staff.id}' />"/>
            </c:if>
            <tr>
                <th>Staff Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${staff.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="text" name="birthday" size="45"
                           value="<c:out value='${staff.birthday}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Sex:</th>
                <td>
                    <input type="text" name="sex" size="45"
                           value="<c:out value='${staff.sex}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Phone number:</th>
                <td>
                    <input type="text" name="phonenumber" size="45"
                           value="<c:out value='${staff.phoneNumber}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${staff.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${staff.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
