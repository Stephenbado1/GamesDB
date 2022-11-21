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
public class Publisher {
    private int cId;
    private String pName;
    private String pCountry;

    public Publisher(int cId, String pName, String pCountry) {
        this.cId = cId;
        this.pName = pName;
        this.pCountry = pCountry;
    }
    public int getcId() {
        return cId;
    }
    public void setcId(int cId) {
        this.cId = cId;
    }
    public String getpName() {
        return pName;
    }
    public void setpName(String pName) {
        this.pName = pName;
    }
    public String getpCountry() {
        return pCountry;
    }
    public void setpCountry(String pCountry) {
        this.pCountry = pCountry;
    }
}

