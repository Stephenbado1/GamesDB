/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.Vector;
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

    public Game(String gameName, String pubName, String releaseDate, int score, double price, int cId, int stfId) {
        this.gameName = gameName;
        this.pubName = pubName;
        this.releaseDate = releaseDate;
        this.score = score;
    }
    public Vector getRow(){
        Vector vec = new Vector();
        vec.add(this.gameName);
        vec.add(this.pubName);
        vec.add(this.releaseDate);
        vec.add(this.score);
        
        return vec;
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
}