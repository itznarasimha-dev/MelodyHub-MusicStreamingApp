<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .login-container {
        background: #fff;
        padding: 25px 30px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        width: 320px;
    }
    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }
    label {
        font-weight: bold;
        display: block;
        margin-top: 10px;
    }
    input[type="text"], 
    input[type="password"] {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        border: 1px solid #aaa;
        border-radius: 5px;
    }
    input[type="submit"] {
        width: 100%;
        margin-top: 15px;
        padding: 10px;
        border: none;
        border-radius: 6px;
        background-color: #007bff;
        color: white;
        font-size: 16px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
    .signup-link {
        margin-top: 15px;
        text-align: center;
    }
    .signup-link a {
        color: #007bff;
        text-decoration: none;
    }
    .signup-link a:hover {
        text-decoration: underline;
    }
    .errormsg{
    color:red;
    font-weight:50;
    }
</style>
</head>
<body>

    <div class="login-container">
        <h2>Login</h2>
        <%
        	String errormsg=(String)request.getAttribute("errorMessage");
        	if(errormsg!=null && !errormsg.isEmpty()){
        		%>
        		<p class="errormsg">invalid credentials!! please try again... </p>
        		<% 
 
        	}
        %>
        
        <form action="LoginServlet" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="username" required />
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required />
            
            <input type="submit" value="Login"/>
        </form>
        
        <div class="signup-link">
            New user? <a href="newUser.html">Click here</a>
        </div>
    </div>

</body>
</html>
