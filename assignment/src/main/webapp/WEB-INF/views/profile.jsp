<%@page import="com.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-pzjw8UHM9L1k8sE4N1hEaLgPZ4wq6viVRAcfJMWO5C8ZLP5bsMf2+0DKTEQC6ZyF" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>User Profile</h2>
    <%-- <h3>Welcome, <%= request.getSession().getAttribute("user").getFirstname() %></h3> --%>
  <%--   <form action="/profile" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email"
                   value="<%= request.getSession().getAttribute("user").getEmail() %>" required>
        </div>
        <div class="form-group">
            <label for="mobile">Mobile:</label>
            <input type="text" class="form-control" id="mobile" name="mobile"
                   value="<%= request.getSession().getAttribute("user").getMobile() %>" required>
        </div>
        <div class="form-group">
            <label for="profilePic">Profile Picture:</label>
            <input type="file" class="form-control-file" id="profilePic" name="file" accept="image/*">
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form> --%>
</div>
</body>
</html>
