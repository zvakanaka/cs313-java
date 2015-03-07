/*
 * Content created by Adam Quinton
 */
package com.adam.talkthread;

import com.adam.talkthread.readwrite.FileServices;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adam
 */
@WebServlet(name = "AddComment", urlPatterns = {"/AddComment"})
public class AddComment extends HttpServlet {

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
        //load list from file
        List <String> commentList = FileServices.readFile("/home/quince/comments.txt");
        
        if (!request.getParameter("comment").isEmpty()) {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
            Date date = new Date();
            String commentTime = dateFormat.format(date);
            String c = request.getSession().getAttribute("username") + ":"
                     + request.getParameter("comment") + ":" + commentTime;       
            //add comm to list
            commentList.add(c);
            //write list to file
            FileServices.writeFile(commentList, "/home/quince/comments.txt");
            request.getSession().setAttribute("commentList", commentList);
            request.getRequestDispatcher("Comments.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("errorMessage", "failure");
            request.setAttribute("errorMessage", "failure");
            request.getRequestDispatcher("Fail_Comment.jsp").forward(request, response);
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
