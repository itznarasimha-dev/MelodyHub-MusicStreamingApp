<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>your playlist - ${playlist.name }</h1>
	
	<ul>
    <c:forEach var="s" items="${songs}">
        <li>
            <strong>${s.title}</strong> — ${s.artist}<br>

            <img alt="cover" src="${s.coverPath}" width="150"><br>

            <audio src="${s.filePath}" controls></audio>
             
        </li>
        <br>
    </c:forEach>
</ul>


</body>
</html>