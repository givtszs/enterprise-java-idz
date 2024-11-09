/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.EmployeeEntity;
import ejb.EmployeeEntityFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author John
 */
@WebServlet(name = "AddEmployee", urlPatterns = {"/AddEmployee"})
public class AddEmployee extends HttpServlet {
    private static Logger logger = Logger.getLogger("AddEmployee.class");
    @EJB
    private EmployeeEntityFacade employeeEntityFacade;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddEmployee</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddEmployee at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the JSP page to display the form
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddEmployee.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String position = request.getParameter("position");
        String courses = request.getParameter("courses");
        String academicLoadStr = request.getParameter("academicLoad");
        String researchActivity = request.getParameter("researchActivity");
        String organizationalWork = request.getParameter("organizationalWork");
        String partTimeJob = request.getParameter("partTimeJob");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        String hobby = request.getParameter("hobby");

        StringBuilder errorMessage = new StringBuilder();

        // validate the request parameters
        if (firstName == null || firstName.trim().isEmpty()) {
            errorMessage.append("First Name is required.<br>");
        }
        
        if (middleName == null || middleName.trim().isEmpty()) {
            errorMessage.append("Middle Name is required.<br>");
        }
        
        if (lastName == null || lastName.trim().isEmpty()) {
            errorMessage.append("Last Name is required.<br>");
        }
        
        if (position == null || position.trim().isEmpty()) {
            errorMessage.append("Position is required.<br>");
        }

        int academicLoad = 0;
        try {
            academicLoad = Integer.parseInt(academicLoadStr);
            if (academicLoad <= 0) {
                errorMessage.append("Academic Load must be a positive number.<br>");
            }
        } catch (NumberFormatException e) {
            errorMessage.append("Academic Load is required and must be a valid number.<br>");
        }

        if (email == null || email.trim().isEmpty()) {
            errorMessage.append("Email is required.<br>");
        } else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            errorMessage.append("Invalid email format.<br>");
        }

        if (birthday == null || birthday.trim().isEmpty()) {
            errorMessage.append("Birthday is required.<br>");
        }

        if (sex == null || sex.trim().isEmpty()) {
            errorMessage.append("Sex is required.<br>");
        }

        // Check if any validation errors occurred
        if (errorMessage.length() > 0) {
            // Set error message as request attribute and forward back to form
            request.setAttribute("errorMessage", errorMessage.toString());
            RequestDispatcher dispatcher = request.getRequestDispatcher("AddEmployee.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Proceed to create and persist the entity if validation passed
        EmployeeEntity entity = new EmployeeEntity();
        entity.setFirstName(firstName);
        entity.setMiddleName(middleName);
        entity.setLastName(lastName);
        entity.setPosition(position);
        entity.setCourses(courses);
        entity.setAcademicLoad(academicLoad);
        entity.setResearchActivity(researchActivity);
        entity.setOrganizationalWork(organizationalWork);
        entity.setPartTimeJob(partTimeJob);
        entity.setAddress(address);
        entity.setPhoneNumber(phoneNumber);
        entity.setEmail(email);
        entity.setBirthday(birthday);
        entity.setSex(sex);
        entity.setHobby(hobby);
        
        employeeEntityFacade.create(entity);
        
        logger.info("Entity should be persisted");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListEmployees.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
