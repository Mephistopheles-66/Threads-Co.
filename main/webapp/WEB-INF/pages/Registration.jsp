<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/Registration.css">

</head>
<body>
 <a href="<%= request.getContextPath() %>/pages/home.jsp"><div class="logo">Threads & Co.</div></a>

<div class="container">
    <h1>Register</h1><img src="">
    <form>

        <div class="form-row">
            <div class="form-group">
                <label>First Name:</label>
                <input type="text" name="firstName">
            </div>
            <div class="form-group">
                <label>Last Name:</label>
                <input type="text" name="lastName">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>Username:</label>
                <input type="text" name="username">
            </div>
            <div class="form-group">
                <label>Date of Birth:</label>
                <input type="date" name="birthday">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>Gender:</label>
                <select name="gender">
                    <option value="" disabled selected>Select Gender</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                </select>
            </div>
            <div class="form-group">
                <label>Phone Number:</label>
                <input type="tel" name="phone">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>Email:</label>
                <input type="email" name="Email">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>Password:</label>
                <input type="password" name="password" >
            </div>
            <div class="form-group">
                <label>Retype Password:</label>
                <input type="password" name="confirmPassword" >
            </div>
        </div>

        <button type="submit" class="submit-btn">Submit</button>
    </form>
</div>
</body>
</html>
