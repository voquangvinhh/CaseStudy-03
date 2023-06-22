<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/18/2023
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new Staff</title>
  <style>
      .message{
          color: green;
      }
  </style>
</head>
<body>
<a href="/staff"></a>
<h1>Create new Staff</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>za
<p>
    <a href="/staff">Back to Staff List</a>
</p>
<h2>
    <a href="/staff?action=staff">List All Staff</a>
</h2>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Student</h2>
            </caption>
            <tr>
                <th>Student Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Email address:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Date of Birth:</th>
                <td>
                    <input type="text" name="locallDate" id="date" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Phone Number:</th>
                <td>
                    <input type="text" name="phonenumber" id="phone" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Class:</th>
                <td>
                    <input type="text" name="classroom" id="classroom" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<%--<form  method="post">--%>
<%--    <fieldset>--%>
<%--        <legend>Staff information</legend>--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <td>Name: </td>--%>
<%--                <td><input type="text" name="name" id="name"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Birthday: </td>--%>
<%--                <td><input type="text" name="birthday" id="birthday"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Sex: </td>--%>
<%--                <td><input type="text" name="sex" id="sex"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Phone: </td>--%>
<%--                <td><input type="text" name="phonenumber" id="phonenumber"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Email: </td>--%>
<%--                <td><input type="text" name="email" id="email"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Address: </td>--%>
<%--                <td><input type="text" name="address" id="address"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td></td>--%>
<%--                <td><input type="submit" value="Save"></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </fieldset>--%>
<%--</form>--%>
</body>
</html>
