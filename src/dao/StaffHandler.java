/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bo.Staff;
import utils.SQLUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.PasswordHasher;
/**
 *
 * @author stephenbadeaux
 */
public class StaffHandler {
    private SQLUtil sqlUtil;
    
    public StaffHandler() {
        sqlUtil = new SQLUtil();
    }
    public Staff login(String username, String password){
        String passwordHash = PasswordHasher.hashPassword(password);
        Staff stf = null;
        try {
            String cmd = String.format("Select staffID, staffName from Staff where staffUN = '%s' and staffPW = '%s';", username, passwordHash);
            ResultSet rs = sqlUtil.executeQuery(cmd);
            if (rs.next()){
                //Get info
                int stfId = rs.getInt("staffID");
                String stfName = rs.getString("staffName");
                stf = new Staff(stfId, stfName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stf;
    }
}