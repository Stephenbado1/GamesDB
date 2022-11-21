/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

/**
 *
 * @author stephenbadeaux
 */
public class Game {
    private int gId;
    private String gName;
    private String releaseDate;
    private int score;
    private double price;
    private int cId;
    private int stfId;

    public Game(int gId, String gName, String releaseDate, int score, double price, int cId, int stfId) {
        this.gId = gId;
        this.gName = gName;
        this.releaseDate = releaseDate;
        this.score = score;
        this.price = price;
        this.cId = cId;
        this.stfId = stfId;
    }
    public int getgId() {
        return gId;
    }
    public void setgId(int gId) {
        this.gId = gId;
    }
    public String getgName() {
        return gName;
    }
    public void setgName(String gName) {
        this.gName = gName;
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
