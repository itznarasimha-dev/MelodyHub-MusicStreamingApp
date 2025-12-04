<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2>Your Playlists</h2>

<a href="/MusicPlayingApplicattion/playlist/create">Create Playlist</a>

<ul>
<c:forEach var="p" items="${playLists}">
    <li>
        ${p.name}
        <a href="/MusicPlayingApplicattion/playlist/${p.id}">View</a>
    </li>
</c:forEach>
</ul>
