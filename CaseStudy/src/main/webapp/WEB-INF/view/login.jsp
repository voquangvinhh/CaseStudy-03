<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/15/2023
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
<%--  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">--%>
<style>
  .login{
    width: 300px;
    height: 300px;
    border: 1px solid gray;
    border-radius: 10px;
    text-align: center;
  }
  h2{
    color: #868787;
    font-family: sans-serif;
  }
  .login input{
    width: 200px;
    height: 40px;
    margin-bottom: 10px;
    border-radius: 5px;
    border: 1px solid grey;
    padding-left: 20px;
  }
  .login button{
    width: 220px;
    height: 40px;
    margin-bottom: 10px;
    border-radius: 5px;
    border: none;
      background-color: #45a049;
      color: white;
  }
  .login button:hover{
      font-size: 15px;
  }

</style>
</head>
<body>
<div class="login" >
  <h2> Member Login</h2>
  <input type="text" name="" placeholder="username">
  <input type="password" name="" placeholder="password">
  <button>Login</button>
</div>

</body>
</html>
