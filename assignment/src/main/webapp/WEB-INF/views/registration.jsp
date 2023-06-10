<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-pzjw8UHM9L1k8sE4N1hEaLgPZ4wq6viVRAcfJMWO5C8ZLP5bsMf2+0DKTEQC6ZyF" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>User Registration</h2>
    <form action="/registration" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="firstname">First Name:</label>
            <input type="text" class="form-control" id="firstname" name="firstname" required>
        </div>
        <div class="form-group">
            <label for="lastname">Last Name:</label>
            <input type="text" class="form-control" id="lastname" name="lastname" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="mobile">Mobile:</label>
            <input type="text" class="form-control" id="mobile" name="mobile" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="gender">Gender:</label>
            <select class="form-control" id="gender" name="gender" required>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>
        </div>
        <div class="form-group">
            <label for="profilePic">Profile Picture:</label>
            <input type="file" class="form-control-file" id="profilePic" name="file" accept="image/*">
        </div>
        <button type="submit" class="btn btn-primary">Register</button>
    </form>
</div>
</body>
</html>
