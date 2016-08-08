/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collection.web;

import com.collection.model.CardItem;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import  com.collection.model.CARDCollection;
/**
 * Web application lifecycle listener.
 *
 * @author Slawomir Brodowski
 */
public class InitializeCollection implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //poprzednie cwiczenia
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //List cardsList = new ArrayList();
        //cardsList.add(new CardItem("Robert Lewandowski", "Bayern", "99", "99", "99", "Fifa 365"));
        //cardsList.add(new CardItem("Arthur Masuaku", "Olympiacos FC", "74", "72", "70", "Fifa 365"));
        //cardsList.add(new CardItem("Fernando Muslera", "Galatasaray AS", "79", "66", "46", "Fifa 365"));
        //cardsList.add(new CardItem("Matija Nastasic", "FC Schalke 04", "81", "65", "60", "Fifa 365"));
        ServletContext context = sce.getServletContext();
        String dataDirectory = context.getInitParameter("data-directory");
        if (dataDirectory!=null){
            CARDCollection collection = new CARDCollection(dataDirectory);
            context.setAttribute("collection", collection);
            context.log("The Cards collection has been created");}
        else{
            context.log("The 'data-directory' context parameter was not set");
        }
        //String collectionFile = context.getInitParameter("collection-file");
        //String inputFileName = context.getRealPath(collectionFile);
        //FileInputStream fis = null;
        //BufferedReader reader = null;
        //try {
            //fis = new FileInputStream(inputFileName);
            //reader = new BufferedReader(new InputStreamReader(fis));
           // String line;

           // while ((line = reader.readLine()) != null) {
              //  String[] elements = line.split("\\|");
             //   String playerName = elements[0];
             //   String clubName = elements[1];
              //  String defencePowerPoints = elements[2];
              //  String controlPowerPoints = elements[3];
              //  String attackPowerPoints = elements[4];
              //  String league = elements[5];

              //  CardItem item = new CardItem(playerName, clubName, defencePowerPoints, controlPowerPoints, attackPowerPoints, league);
                //cardsList.add(item);

            }

           // context.setAttribute("cardsList", cardsList);
            //context.log("The Cards collection has been loaded from: " + collectionFile);
     //   } catch (Exception e) {
          //  context.log("Exception occured while processin the Cards collection file", e);
       // } finally {
         //   if (fis != null) {
             //   try {
             //       fis.close();
            //    } catch (Exception e) {
            //    }
            //    if (reader != null) {
              //      try {
                  //      reader.close();
                 //   } catch (Exception e) {
                 //   }

               // }
          //  }
      //  }
  //  }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
