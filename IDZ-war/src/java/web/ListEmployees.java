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
import ejb.EmployeeEntity;
import ejb.EmployeeEntityFacade;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ListEmployees", urlPatterns = {"/ListEmployees"})
public class ListEmployees extends HttpServlet {

    private static Logger logger = Logger.getLogger("ListEmployees.class");

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
            out.println("<title>Servlet ListEmployees</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListEmployees at " + request.getContextPath() + "</h1>");
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
        String academicDegree = request.getParameter("academicDegree");
        String academicRank = request.getParameter("academicRank");

        List<EmployeeEntity> employees;
        try {
            if ((academicDegree != null && !academicDegree.trim().isEmpty())
                    || (academicRank != null && !academicRank.trim().isEmpty())) {
                employees = employeeEntityFacade.findByDegreeAndRank(
                        academicDegree.isEmpty() ? null : academicDegree,
                        academicRank.isEmpty() ? null : academicRank
                );
                logger.info("Filtered employees by degree and rank, found results: " + employees.size());
            } else {
                employees = employeeEntityFacade.findAll();
                logger.info("Found " + employees.size() + " employee entries");
            }
        } catch (Exception e) {
            employees = employeeEntityFacade.findAll();
            logger.info("Found " + employees.size() + " employee entries");
        }

        List<AcademicDegreeEntity> degrees = academicDegreeEntityFacade.findAll();
        logger.info("Found " + degrees.size() + " degree entries");

        List<AcademicRankEntity> ranks = academicRankEntityFacade.findAll();
        logger.info("Found " + ranks.size() + " rank entries");

        request.setAttribute("employees", employees);
        request.setAttribute("degrees", degrees);
        request.setAttribute("ranks", ranks);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ListEmployees.jsp");
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
        processRequest(request, response);
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
