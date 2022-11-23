/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.Date;
import java.util.Vector;
import javax.print.attribute.standard.PrinterName;

/**
 * TESTING PUSH FROM BRYAN
 * @author stephenbadeaux
 */
public class Game {
    private int gId;
    private String gameName;
    private String pubName;
    private Date releaseDate;
    private int score;

    public Game(int gId, String gameName, String pubName, Date releaseDate, int score) {
        this.gId = gId;
        this.gameName = gameName;
        this.pubName = pubName;
        this.releaseDate = releaseDate;
        this.score = score;
    }
    public Vector getRow(){
        Vector vec = new Vector();
        vec.add(this.gId);
        vec.add(this.gameName);
        vec.add(this.pubName);
        vec.add(this.releaseDate);
        vec.add(this.score);
        
        return vec;
    }
    public int getgId() {
        return gId;
    }
    public void setgId(int gId) {
        this.gId = gId;
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
    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}