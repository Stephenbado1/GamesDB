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
public class Staff {
    private int stfId;
    private String stfName;    

    public Staff(int stfId, String stfName) {
        this.stfId = stfId;
        this.stfName = stfName;
    }
    public int getstfId() {
        return stfId;
    }
    public void setstfId(int stfId) {
        this.stfId = stfId;
    }
    public String getstfName() {
        return stfName;
    }
    public void setstfName(String stfName) {
        this.stfName = stfName;
    }
}
