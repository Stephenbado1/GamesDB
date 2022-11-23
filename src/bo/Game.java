/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import javax.print.attribute.standard.PrinterName;

/**
 * TESTING PUSH FROM BRYAN
 * @author stephenbadeaux
 */
public class Game {
    private String gameName;
    private String pubName;
    private String releaseDate;
    private int score;
    private double price;
    private int cId;
    private int stfId;

    public Game(String gameName, String pubName, String releaseDate, int score, double price, int cId, int stfId) {
        this.gameName = gameName;
        this.pubName = pubName;
        this.releaseDate = releaseDate;
        this.score = score;
        this.price = price;
        this.cId = cId;
        this.stfId = stfId;
    }
    public String getGameName() {
        return gameName;
    }
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
    public String getPubName() {
        return pubName;
    }
    public void setPubName(String pubName) {
        this.pubName = pubName;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getcId() {
        return cId;
    }
    public void setcId(int cId) {
        this.cId = cId;
    }
    public int getStfId() {
        return stfId;
    }
    public void setStfId(int stfId) {
        this.stfId = stfId;
    }
}