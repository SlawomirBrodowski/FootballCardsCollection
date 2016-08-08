/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collection.controller;

import com.collection.model.CardItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import com.collection.model.CARDCollection;
/**
 *
 * @author Slawomir Brodowski
 */
public class AddCardServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   // protected void processRequest(HttpServletRequest request, HttpServletResponse response)
       //     throws ServletException, IOException {
      //  response.setContentType("text/html;charset=UTF-8");
       // try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
      //      out.println("<!DOCTYPE html>");
      //      out.println("<html>");
      //      out.println("<head>");
      ////      out.println("<title>Servlet AddCardServlet</title>");
      //      out.println("</head>");
      //      out.println("<body>");
      //      out.println("<h1>Servlet AddCardServlet at " + request.getContextPath() + "</h1>");
      //      out.println("</body>");
      //      out.println("</html>");
      //  }
  //  }

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
       // processRequest(request, response);
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
        List errorsMsgs = new ArrayList();
        try {

            String playerName = request.getParameter("playerName");
            String clubName = request.getParameter("clubName");
            String defencePowerPoints = request.getParameter("defencePowerPoints");
            String controlPowerPoints = request.getParameter("controlPowerPoints");
            String attackPowerPoints = request.getParameter("attackPowerPoints");
            String league = request.getParameter("league");

            //weryfikacja formy
            if (playerName == null || playerName.trim().length() == 0) {
                errorsMsgs.add("Prosze wypelnic pole Pilkarz");
            }
            if (clubName == null || clubName.trim().length() == 0) {
                errorsMsgs.add("Prosze wypelnic pole Klub");
            }
            if (defencePowerPoints == null || defencePowerPoints.trim().length() == 0) {
                errorsMsgs.add("Prosze wypelnic pole Obrona punkty");
            } else if (!defencePowerPoints.trim().matches("\\d\\d")) {
                errorsMsgs.add("Wprowadz wartosc Obrona punkty-zakres 10-99");
            }
            if (controlPowerPoints == null || controlPowerPoints.trim().length() == 0) {
                errorsMsgs.add("Prosze wypelnic pole Kontrola punkty");
            } else if (!controlPowerPoints.trim().matches("\\d\\d")) {
                errorsMsgs.add("Wprowadz wartosc Kontrola punkty-zakres 10-99");
            }
            if (attackPowerPoints == null || attackPowerPoints.trim().length() == 0) {
                errorsMsgs.add("Prosze wypelnic pole Atak punkty");
            } else if (!attackPowerPoints.trim().matches("\\d\\d")) {
                errorsMsgs.add("Wprowadz wartosc Atak punkty-zakres 10-99");
            }
            if (!errorsMsgs.isEmpty()) {
                request.setAttribute("errorsMsgs", errorsMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/add_card.view");
                view.forward(request, response);
                return;
            }
            //CardItem item = new CardItem(playerName, clubName, defencePowerPoints, controlPowerPoints, attackPowerPoints, league);
            ServletContext context= getServletContext();
            //List cardsList = (List)context.getAttribute("cardsList");
            //cardsList.add(item);
            CARDCollection model = (CARDCollection)context.getAttribute("collection");
            CardItem item = model.addCARD(playerName, clubName, defencePowerPoints, controlPowerPoints, attackPowerPoints, league);
            
            request.setAttribute("cardItem", item);
            RequestDispatcher view = request.getRequestDispatcher("/success.view");
            view.forward(request, response);

        } catch (RuntimeException e) {
            errorsMsgs.add("Nieoczekiwan Blad: " + e.getMessage());
            request.setAttribute("errorsMsgs", errorsMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/add_card.view");
            view.forward(request, response);
        }
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
