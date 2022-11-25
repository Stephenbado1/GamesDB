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
public class Staff {
    private int stfId;
    private String stfName;    
    private int stfPerms;

    public Staff(int stfId, String stfName, int stfPerms) {
        this.stfId = stfId;
        this.stfName = stfName;
        this.stfPerms = stfPerms;
    }
    public Vector getRow() {
        Vector vec = new Vector();
        vec.add(this.stfId);
        vec.add(this.stfName);
        vec.add(this.stfPerms);
        
        return vec;
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
    public int getstfPerms() {
        return stfPerms;
    }
    public void setstfPerms(int perms) {
        this.stfPerms = perms;
    }
}
