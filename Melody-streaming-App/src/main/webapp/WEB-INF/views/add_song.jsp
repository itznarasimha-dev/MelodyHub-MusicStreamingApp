<%@ include file="header.jsp" %>

<h2>Add Song</h2>

<form action="/MusicPlayingApplicattion/songs/add" method="post" enctype="multipart/form-data">

    <p>Title: <input type="text" name="title"></p>

    <p>Artist: <input type="text" name="artist"></p>
    
    <p>
    Category : 
    <select name="category.id">
    <c:forEach var="c" items="${categories }">
    <option value="${c.id}">${c.name}</option>
    </c:forEach>
    </select>
    </p>

    <p>Audio File: <input type="file" name="file"></p>

    <p>Cover Image: <input type="file" name="cover"></p>

    <button type="submit">Upload</button>

</form>
