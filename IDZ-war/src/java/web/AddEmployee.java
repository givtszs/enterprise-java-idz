/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.AcademicDegreeEntity;
import ejb.AcademicDegreeEntityFacade;
import ejb.AcademicRankEntity;
import ejb.AcademicRankEntityFacade;
import ejb.ContractInfoEntity;
import ejb.EmployeeEntity;
import ejb.EmployeeEntityFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
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

    @EJB
    private AcademicDegreeEntityFacade academicDegreeEntityFacade;

    @EJB
    private AcademicRankEntityFacade academicRankEntityFacade;

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
        List<AcademicDegreeEntity> degrees = academicDegreeEntityFacade.findAll();
        request.setAttribute("degrees", degrees);
        logger.info("Found " + degrees.size() + " degree entries");

        List<AcademicRankEntity> ranks = academicRankEntityFacade.findAll();
        request.setAttribute("ranks", ranks);
        logger.info("Found " + ranks.size() + " rank entries");

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
        String academicDegreeStr = request.getParameter("academicDegree");
        String academicRankStr = request.getParameter("academicRank");

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

        AcademicDegreeEntity degree = null;
        if (academicDegreeStr.length() > 0) {
            degree = academicDegreeEntityFacade.find(Long.parseLong(academicDegreeStr));
        }

        AcademicRankEntity rank = null;
        if (academicRankStr.length() > 0) {
            rank = academicRankEntityFacade.find(Long.parseLong(academicRankStr));
        }

        ContractInfoEntity contractInfo;
        try {
            contractInfo = processContractInfoData(request);    
        } catch (ParseException e) {
            contractInfo = null;
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
        entity.setAcademicDegree(degree);
        entity.setAcademicRank(rank);
        entity.setContractInfo(contractInfo);

        employeeEntityFacade.create(entity);

        logger.info("Entity should be persisted");

        response.sendRedirect(request.getContextPath() + "/ListEmployees");
    }

    private ContractInfoEntity processContractInfoData(HttpServletRequest request) throws ParseException {
        String hiringDate = request.getParameter("hiringDate");
        String contractStartDateString = request.getParameter("contractStartDate");
        String contractEndDateString = request.getParameter("contractEndDate");
        String prevVacationStartDateString = request.getParameter("prevVacationStartDate");
        String prevVacationEndDateString = request.getParameter("prevVacationEndDate");
        String nextVacationStartDateString = request.getParameter("nextVacationStartDate");
        String nextVacationEndDateString = request.getParameter("nextVacationEndDate");

        // Define the DateTimeFormatter to match the datetime-local format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ContractInfoEntity contractInfo = new ContractInfoEntity();

        if (hiringDate != null && !hiringDate.isEmpty()) {
            contractInfo.setHiringDate(hiringDate);
        }
        
        if (contractStartDateString != null && !contractStartDateString.isEmpty()) {
            contractInfo.setContractStartDate(dateFormat.parse(contractStartDateString));
        }
        
        if (contractEndDateString != null && !contractEndDateString.isEmpty()) {
            contractInfo.setContractEndDate(dateFormat.parse(contractEndDateString));
        }
        
        if (prevVacationStartDateString != null && !prevVacationStartDateString.isEmpty()) {
            contractInfo.setPrevVacationStartDate(dateFormat.parse(prevVacationStartDateString));
        }
        
        if (prevVacationEndDateString != null && !prevVacationEndDateString.isEmpty()) {
            contractInfo.setPrevVacationEndDate(dateFormat.parse(prevVacationEndDateString));
        }
        
        if (nextVacationStartDateString != null && !nextVacationStartDateString.isEmpty()) {
            contractInfo.setNextVacationStartDate(dateFormat.parse(nextVacationStartDateString));
        }
        
        if (nextVacationEndDateString != null && !nextVacationEndDateString.isEmpty()) {
            contractInfo.setNextVacationEndDate(dateFormat.parse(nextVacationEndDateString));
        }
        
        return contractInfo;
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
