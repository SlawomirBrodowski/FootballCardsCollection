/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collection.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import com.collection.model.CardItem;
import javax.servlet.*;
import com.collection.model.CARDCollection;
/**
 *
 * @author Slawomir Brodowski
 * 
 */
public class ListCollectionServlet extends HttpServlet {

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
        ServletContext context = getServletContext();
        PrintWriter out = response.getWriter();
        CARDCollection collection = (CARDCollection)context.getAttribute("collection");
        List cardsList=collection.getCardCollection();
        //List cardsList = (List)context.getAttribute("cardsList");
        try {

           // cardsList.add(new CardItem("Arthur Masuaku", "Olympiacos FC", "74", "72", "70", "Fifa 365"));
           // cardsList.add(new CardItem("Fernando Muslera", "Galatasaray AS", "79", "66", "46", "Fifa 365"));
           // cardsList.add(new CardItem("Matija Nastasic", "FC Schalke 04", "81", "65", "60", "Fifa 365"));
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Kolekcja kart pilkarskich</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align='center'>Obecnie posiadasz nastepujace karty w twojej kolekcji: (ilosc: " +cardsList.size() +")</h1>");
            out.println("<h1 align='center'>Lista Kart: </h1>");
            out.println("<table width='70%' align='center' border='1' cellspacing='1' cellpadding='10'>");
            out.println("<tr>");
            out.println(" <th>Pilkarz</th>");
            out.println(" <th>Klub</th>");
            out.println(" <th>Obrona punkty</th>");
            out.println(" <th>Kontrola punkty</th>");
            out.println(" <th>Atak punkty</th>");
            out.println(" <th>Nazwa ligi</th>");
            out.println("</tr>");
            Iterator it = cardsList.iterator();
            while (it.hasNext()) {
                CardItem item = (CardItem) it.next();
                out.println("<tr>");
                out.println(" <td>" + item.getPlayerName() + "</td>");
                out.println(" <td>" + item.getClubName() + "</td>");
                out.println(" <td>" + item.getDefencePowerPoints() + "</td>");
                out.println(" <td>" + item.getControlPowerPoints() + "</td>");
                out.println(" <td>" + item.getAttackPowerPoints() + "</td>");
                out.println(" <td>" + item.getLeague()+ "</td>");
                out.println("</tr>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
