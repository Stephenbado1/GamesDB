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
    private String pName;
    private String pCountry;

    public Publisher(String pName, String pCountry) {
        this.pName = pName;
        this.pCountry = pCountry;
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
    @Override
    public String toString() {
        return getpName();
    }
}

