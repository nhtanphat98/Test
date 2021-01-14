/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBUtils.StudentDAO;
import DBUtils.UserDAO;
import phat.dto.StudentDTO;
import phat.dto.StudentErrors;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class StudentManagerServlet extends HttpServlet {

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
        String action = request.getParameter("action");
        String displayView = "StudentList.jsp";
        String formView = "StudentForm.jsp";
        String controllerServlet = "StudentManagerServlet";
        String search = "SearchStudent.jsp";
        String login = "LoginServlet";
        RequestDispatcher rd;

        try {

            if (action == null) {
                ArrayList<StudentDTO> list;
                StudentDAO dao = new StudentDAO();
                list = dao.getAllStudent();
                request.setAttribute("data", list);
                rd = request.getRequestDispatcher(displayView);
                rd.forward(request, response);
            } else if (action.equals("Login")) {
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");
                UserDAO dao = new UserDAO();
                if (dao.checkLogin(username, password)) {
                    response.sendRedirect(controllerServlet);
                } else {
                    response.sendRedirect(login);
                }
            } else if (action.equals("updateForm")) {
                String id = request.getParameter("sid");
                StudentDAO dao = new StudentDAO();
                StudentDTO dto = dao.searchStudent(id);
                request.setAttribute("sObject", dto);
                request.setAttribute("msg", "Update student (Id: " + id + ")");
                request.setAttribute("action", "Update");
                rd = request.getRequestDispatcher(formView);
                rd.forward(request, response);
            } else if (action.equals("Update")) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                int age = Integer.parseInt(request.getParameter("age"));
                String classId = request.getParameter("classId");
                boolean checkErr = false;
                StudentErrors err = new StudentErrors();
                if (id == null) {
                    err.setIdErr("Id cannot empty");
                    checkErr = true;
                }
                if (name.length() < 6) {
                    err.setNameErr("Name cannot < 6 character");
                    checkErr = true;
                }
                if (age < 18) {
                    err.setAgeErr("Age must higher 18");
                    checkErr = true;
                }
                if (classId.length() < 6) {
                    err.setClassIdErr("ClassId can not < 6 character");
                    checkErr = true;
                }
                if (checkErr == true) {
                    request.setAttribute("action", "Update");
                    request.setAttribute("err", err);
                    StudentDTO dto =new StudentDTO(id, name, age, classId);
                    request.setAttribute("sObject", dto);
                    rd = request.getRequestDispatcher(formView);
                    rd.forward(request, response);
                } else {
                    StudentDTO dto = new StudentDTO(id, name, age, classId);
                    StudentDAO dao = new StudentDAO();
                    dao.updateStudent(dto);
                    response.sendRedirect(controllerServlet);
                }
            } else if (action.equals("Delete")) {
                String id = request.getParameter("sid");
                StudentDAO dao = new StudentDAO();
                dao.deleteStudent(id);
                String msg = "Delete Success!";
                response.sendRedirect(controllerServlet);
            } else if (action.equals("newForm")) {
                StudentDTO dto = new StudentDTO("", "", 0, "");
                request.setAttribute("sObject", dto);
                request.setAttribute("msg", "Add A New Student");
                request.setAttribute("action", "New");
                rd = request.getRequestDispatcher(formView);
                rd.forward(request, response);
            } else if (action.equals("New")) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                int age = Integer.parseInt(request.getParameter("age"));
                String classId = request.getParameter("classId");
                boolean checkErr = false;
                StudentErrors err = new StudentErrors();
                if (id == null) {
                    err.setIdErr("Id cannot empty");
                    checkErr = true;
                }
                if (name.length() < 6) {
                    err.setNameErr("Name cannot < 6 character");
                    checkErr = true;
                }
                if (age < 18) {
                    err.setAgeErr("Age must higher 18");
                    checkErr = true;
                }
                if (classId.length() < 6) {
                    err.setClassIdErr("ClassId can not < 6 character");
                    checkErr = true;
                }
                if (checkErr == true) {
                    request.setAttribute("action", "New");
                    request.setAttribute("err", err);
                    rd = request.getRequestDispatcher(formView);
                    rd.forward(request, response);
                } else {
                    StudentDTO dto = new StudentDTO(id, name, age, classId);
                    StudentDAO dao = new StudentDAO();
                    dao.insertStudent(dto);
                    response.sendRedirect(controllerServlet);
                }
            } else if (action.equals("Search")) {
                String id = request.getParameter("txtSearchById");
                StudentDAO dao = new StudentDAO();
                StudentDTO dto;
                dto = dao.searchStudent(id);
                request.setAttribute("sObject", dto);
                request.setAttribute("msg", "Search Student ID: " + id);
                rd = request.getRequestDispatcher(search);
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
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
        processRequest(request, response);
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
