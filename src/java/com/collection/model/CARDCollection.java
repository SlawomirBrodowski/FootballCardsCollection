package com.collection.model;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class CARDCollection {

    private File collectionFile;
    private List cardCollection;
    private List leagueList;

   public CARDCollection(String dataDirectory) {
      
        // Initialize data directory and collection file
        this.collectionFile = new File(dataDirectory,"my-collection.txt");
      
        this.cardCollection = new ArrayList();
        readFile();
        
        this.leagueList = new ArrayList();
        this.leagueList.add("FIFA 365");
        this.leagueList.add("UEFA CHAMPIONS");
        this.leagueList.add("EKSTRAKLASA");

    }

    public List getCardCollection() {
        return cardCollection;
    }

    public CardItem addCARD(String playerName, String clubName, String defencePowerPoints, String controlPowerPoints, String attackPowerPoints, String league) {
        CardItem item = new CardItem(playerName, clubName, defencePowerPoints, controlPowerPoints, attackPowerPoints, league);
        cardCollection.add(item);
        appendToFile(item);
        return item;
    }

    public List getLeagueList() {
        return leagueList;
    }

    public void addLeague(String new_league) {
        if (!leagueList.contains(new_league)) {
            leagueList.add(new_league);
        }
    }

    private void readFile() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(collectionFile));
            String line;

            // Read every dvd entry in the file
            while ((line = reader.readLine()) != null) {
                String[] elements = line.split("\\|");

                // Extract the data fields for the record
                String playerName = elements[0];
                String clubName = elements[1];
                String defencePowerPoints = elements[2];
                String controlPowerPoints = elements[3];
                String attackPowerPoints = elements[4];
                String league = elements[5];

                // Add the new League item to the set
                CardItem item = new CardItem(playerName, clubName, defencePowerPoints, controlPowerPoints, attackPowerPoints, league);
                cardCollection.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                }
            }
        }
    }

    private void appendToFile(CardItem item) {
        PrintWriter collectionWriter = null;
        try {
            // Open a writer stream and mark it to append the new data
            collectionWriter = new PrintWriter(new FileWriter(collectionFile, true));

            collectionWriter.print(item.getPlayerName());
            collectionWriter.print('|' + item.getClubName());
            collectionWriter.print('|' + item.getDefencePowerPoints());
            collectionWriter.print('|' + item.getControlPowerPoints());
            collectionWriter.print('|' + item.getAttackPowerPoints());
            collectionWriter.print('|' + item.getLeague());
           
            collectionWriter.println();

        } catch (Exception e) {
            throw new RuntimeException(e);

            // Clean up IO resources
        } finally {
            if (collectionWriter != null) {
                try {
                    collectionWriter.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
    }

}
