<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.List" %>
   <%@ page import="model.Userdb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style>
    body { font-family: Arial; background-color: #f4f6f9; padding: 30px; }
    table { width: 100%; border-collapse: collapse; background: #fff; box-shadow: 0 2px 6px rgba(0,0,0,0.15);}
    th, td { padding: 12px 15px; border-bottom: 1px solid #ddd; text-align: left; }
    th { background-color: #007bff; color: white; }
    .delete-btn { padding: 6px 10px; background-color: #dc3545; color: white; border: none; border-radius: 4px; cursor: pointer; }
    .delete-btn:hover { background-color: #c82333; }
</style>

</head>
<body>


<h2>User List</h2>
<table>
    <thead>
        <tr>
            <th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>Gender</th><th>Action</th>
        </tr>
    </thead>
    <tbody>
  
   
   <%
    List<Userdb> users=(List<Userdb>)request.getAttribute("userList");
   
   if(users!=null){
	   
	   for(Userdb user:users){
		   %>
		   <tr>
            <td><%=user.getId() %></td>
            <td><%=user.getName() %></td>
            <td><%=user.getMail() %>></td>
            <td><%=user.getPhone() %>></td>
            <td><%=user.getGender() %>></td>
            <td>
                <form action="deleteUser" method="post">
                    <input type="hidden" name="id" value="<%= user.getId()%>"/>
                    <input type="submit" value="Delete" class="delete-btn"/>
                </form>
            </td>
        </tr>
		   
		   <%
	   }
	   
   }
    
    %>
        
      
       
    </tbody>
</table>

</body>
</html>