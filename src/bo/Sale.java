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
public class Sale {
    private int sId;
    private int quantity;

    public Sale(int sId, int quantity) {
        this.sId = sId;
        this.quantity = quantity;
    }
    public int getsId() {
        return sId;
    }
    public void setsId(int sId) {
        this.sId = sId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
