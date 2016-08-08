/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collection.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Slawomir Brodowski
 * 
 */
public class AddCardFormservlet extends HttpServlet {

    private String[] leagues = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void init() throws ServletException {
        String league_list = getInitParameter("league-list");
        if (league_list == null) {
            league_list = "FIFA 365,CHAMPIONSHIP,EURO";
        }
        leagues = league_list.split(",");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Dodaj karte(servlet)</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align='center'>Dodaj karte</h1>");
            
            List errorsMsgs = (List) request.getAttribute("errorsMsgs");
            if (errorsMsgs != null) {
                out.println("<h2><font color='red'>Blad</h2>");
                out.println("Prosze naprawic nastepujace bledy: ");
                out.println("<ul>");
                Iterator items = errorsMsgs.iterator();
                while (items.hasNext()) {
                    String message = (String) items.next();
                    out.println("<li>" + message + "</li>");
                }
                out.println("</ul>");
                out.println("</font><p>");
            }
            String playerName = request.getParameter("playerName");
            String clubName = request.getParameter("clubName");
            String defencePowerPoints = request.getParameter("defencePowerPoints");
            String controlPowerPoints = request.getParameter("controlPowerPoints");
            String attackPowerPoints = request.getParameter("attackPowerPoints");
            String paramLeague = request.getParameter("league");
            out.println("<form action='add_card.do' method='POST'>");
            out.println("<table width='50%' cellspacing='2' cellpadding='10'>");
            out.println("<tr><td width='30%'>Pilkarz(Imie i nazwisko):</td><td><input type='text' name='playerName'");
            if (playerName == null) {
                playerName = "";
            }
            out.println("value='" + playerName + "'>");
            out.println("</td></tr>");
            out.println("<tr><td width='30%'>Klub(Nazwa klubu):</td><td><input type='text' name='clubName'");
            if (clubName == null) {
                clubName = "";
            }
            out.println("value='" + clubName + "'>");
            out.println("</td></tr>");
            out.println("<tr><td width='30%'>Obrona punkty(wpisz numer z karty):</td><td><input type='text' name='defencePowerPoints'");
            if (defencePowerPoints == null) {
                defencePowerPoints = "";
            }
            out.println("value='" + defencePowerPoints + "'>");
            out.println("</td></tr>");
            out.println("<tr><td width='30%'>Kontrola punkty(wpisz numer z karty):</td><td><input type='text' name='controlPowerPoints'");
            if (controlPowerPoints == null) {
                controlPowerPoints = "";
            }
            out.println("value='" + controlPowerPoints + "'>");
            out.println("</td></tr>");
            out.println("<tr><td width='30%'>Atak punkty(wpisz numer z karty)</td><td><input type='text' name='attackPowerPoints'");
            if (attackPowerPoints == null) {
                attackPowerPoints = "";
            }
            out.println("value='" + attackPowerPoints + "'>");
            out.println("</td></tr>");
            out.println("<tr><td width='30%'>Liga: </td>");
            out.println("<td><select name='league'>");

            for (int i = 0; i < leagues.length; i++) {
                out.print("<option value='" + leagues[i] + "'>" + leagues[i] + "</option>");
            }
            
 
            out.println("</select>");
            out.println("</td></tr>");
            out.println("<tr><td><input type='submit' value='Dodaj Karte'></td></tr>");
            out.println("</table>");
            out.println("</form> ");
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
