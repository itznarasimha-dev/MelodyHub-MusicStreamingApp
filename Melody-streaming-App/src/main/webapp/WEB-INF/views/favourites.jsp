<%@ include file="header.jsp" %>

<h2>Your Favorite Songs</h2>

<ul>
<c:forEach var="fav" items="${favourite}">
    <li>
        ${fav.song.title}

        <form method="post" action="/MusicPlayingApplicattion/favourites/remove/${fav.song.id}">
            <button type="submit">Remove</button>
        </form>
    </li>
</c:forEach>
</ul>
