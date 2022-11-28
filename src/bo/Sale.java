/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author stephenbadeaux
 */
public class Sale {
    private int sNo;
    private int gID;
    private Date saleDate;
    private String sRegion;
    private int sId;

    public Sale(int sNo, int gID, Date saleDate, String sRegion, int sId) {
        this.sNo = sNo;
        this.gID = gID;
        this.saleDate = saleDate;
        this.sRegion = sRegion;
        this.sId = sId;
    }
    public Vector getRow(){
        Vector vec = new Vector();
        vec.add(this.sNo);
        vec.add(this.saleDate);
        vec.add(this.sRegion);
        vec.add(this.sId);
        return vec;
    }
    public int getsNo() {
        return sNo;
    }
    public void setsNo(int sNo) {
        this.sNo = sNo;
    }
    public int getgID() {
        return gID;
    }
    public void setgID(int gID) {
        this.gID = gID;
    }
    public Date getSaleDate() {
        return saleDate;
    }
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
    public String getsRegion() {
        return sRegion;
    }
    public void setsRegion(String sRegion) {
        this.sRegion = sRegion;
    }
    public int getssId() {
        return sId;
    }
    public void setsId(int sId) {
        this.sId = sId;
    }

    @Override
    public String toString() {
        return getsRegion(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
