/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collection.model;

/**
 *
 * @author Slawomir Brodowski
 */
public class CardItem implements java.io.Serializable{
    private String playerName;
    private String clubName;
    private String defencePowerPoints;
    private String controlPowerPoints;
    private String attackPowerPoints;
    private String league;

    public CardItem(String playerName, String clubName, String defencePowerPoints, String controlPowerPoints, String attackPowerPoints, String league) {
        this.playerName = playerName;
        this.clubName = clubName;
        this.defencePowerPoints = defencePowerPoints;
        this.controlPowerPoints = controlPowerPoints;
        this.attackPowerPoints = attackPowerPoints;
        this.league = league;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getClubName() {
        return clubName;
    }

    public String getDefencePowerPoints() {
        return defencePowerPoints;
    }

    public String getControlPowerPoints() {
        return controlPowerPoints;
    }

    public String getAttackPowerPoints() {
        return attackPowerPoints;
    }

    public String getLeague() {
        return league;
    }
    
    
    
    
}
