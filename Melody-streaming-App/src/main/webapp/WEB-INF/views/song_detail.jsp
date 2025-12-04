<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2>${song.title}</h2>
<p>Artist: ${song.artist}</p>
<p>Album: ${song.album}</p>
<p>Genre: ${song.genre}</p>

<img src="${pageContext.request.contextPath}${song.coverPath}" alt="cover" width="200">

<audio controls>
    <source src="${pageContext.request.contextPath}${song.filePath}" type="audio/mpeg">
</audio>

<form action="${pageContext.request.contextPath}/favorite/add/${song.id}" method="post">
    <button type="submit">Add to Favorites</button>
</form>
