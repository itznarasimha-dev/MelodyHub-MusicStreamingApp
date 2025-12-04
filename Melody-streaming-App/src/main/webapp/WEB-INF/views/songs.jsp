
<%@ include file="header.jsp" %>

<h2>All Songs</h2>

<form action="/MusicPlayingApplicattion/songs/search" method="get">
    <input type="text" name="q" placeholder="Search" value="${query}">
    <button type="submit">Search</button>
</form>

<hr>

<c:forEach var="song" items="${songs}">
    <div>
        <p>Title: ${song.title}</p>
        <p>Artist: ${song.artist}</p>

        <a href="/MusicPlayingApplicattion/songs/${song.id}">Play</a>

      <form action="${pageContext.request.contextPath}/favourites/add/${song.id}" method="post">
            <button type="submit">Add to Favorites</button>
        </form>

        <hr>
    </div>
</c:forEach>
