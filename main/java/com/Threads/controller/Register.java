package com.Threads.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Register
 */
@WebServlet(urlPatterns = { "/Registration" })
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Register() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/Registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String validationMessage = validateRegistrationForm(request);
            if (validationMessage != null) {
                handleError(request, response, validationMessage);
                return;
            }

            // If validation is successful, you can save the user to database here.
            // Example (pseudo-code):
            // StudentModel student = new StudentModel(...);
            // studentDAO.save(student);

            handleSuccess(request, response, "Registration successful!", "/WEB-INF/pages/success.jsp");
        } catch (Exception e) {
            handleError(request, response, "An error occurred during registration. Please try again.");
        }
    }

    private String validateRegistrationForm(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        String retypePassword = request.getParameter("retypePassword");

        if (firstName == null || firstName.isEmpty()) return "First name is required.";
        if (lastName == null || lastName.isEmpty()) return "Last name is required.";
        if (username == null || username.isEmpty()) return "Username is required.";
        if (dob == null || dob.isEmpty()) return "Date of birth is required.";
        if (gender == null || gender.isEmpty()) return "Gender is required.";
        if (email == null || email.isEmpty()) return "Email is required.";
        if (phoneNumber == null || phoneNumber.isEmpty()) return "Phone number is required.";
        if (password == null || password.isEmpty()) return "Password is required.";
        if (retypePassword == null || retypePassword.isEmpty()) return "Please retype the password.";
        if (!password.equals(retypePassword)) return "Passwords do not match.";

        // Add more checks if needed (email format, password strength, etc.)
        return null;
    }

    private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
            throws ServletException, IOException {
        req.setAttribute("success", message);
        req.getRequestDispatcher(redirectPage).forward(req, resp);
    }

    private void handleError(HttpServletRequest req, HttpServletResponse resp, String message)
            throws ServletException, IOException {
        req.setAttribute("error", message);

        // Preserve form data
        req.setAttribute("firstName", req.getParameter("firstName"));
        req.setAttribute("lastName", req.getParameter("lastName"));
        req.setAttribute("username", req.getParameter("username"));
        req.setAttribute("dob", req.getParameter("dob"));
        req.setAttribute("gender", req.getParameter("gender"));
        req.setAttribute("email", req.getParameter("email"));
        req.setAttribute("phoneNumber", req.getParameter("phoneNumber"));

        req.getRequestDispatcher("/WEB-INF/pages/Registration.jsp").forward(req, resp);
    }
}
