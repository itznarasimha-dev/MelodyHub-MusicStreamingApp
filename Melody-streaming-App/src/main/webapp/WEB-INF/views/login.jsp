<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h2>Login</h2>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<form action="/MusicPlayingApplicattion/user/login" method="post">

    <p>Email:
        <input type="email" name="email">
    </p>

    <p>Password:
        <input type="password" name="password">
    </p>

    <button type="submit">Login</button>

</form>

<p><a href="/MusicPlayingApplicattion/user/register">Create a new account</a></p>
