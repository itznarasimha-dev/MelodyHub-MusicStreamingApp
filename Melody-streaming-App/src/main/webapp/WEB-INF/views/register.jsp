<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<h2>Register</h2>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<form action="/MusicPlayingApplicattion/user/register" method="post">

    <p>Name:
        <input type="text" name="name">
    </p>

    <p>Email:
        <input type="email" name="email">
    </p>

    <p>Password:
        <input type="password" name="passwordHash">
    </p>

    <button type="submit">Register</button>

</form>
