/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.Vector;
/**
 *
 * @author stephenbadeaux
 */
public class SaleItems {
    private int sNo;
    private int gID;
    private double sPrice;

    public SaleItems(int sNo, int gID, double sPrice) {
        this.sNo = sNo;
        this.gID = gID;
        this.sPrice = sPrice;
    }
    public Vector getRow(){
        Vector vec = new Vector();
        vec.add(this.sNo);
        vec.add(this.gID);
        vec.add(this.sPrice);
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
    public double getsPrice() {
        return sPrice;
    }
    public void setsPrice(double sPrice) {
        this.sPrice = sPrice;
    }
}

