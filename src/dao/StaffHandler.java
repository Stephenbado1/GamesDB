/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bo.Staff;
import java.util.ArrayList;
import java.util.List;
import utils.SQLUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.PasswordHasher;
import utils.InputSanitizer;
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
        username = InputSanitizer.sanitize(username);
        Staff stf = null;
        try {
            String cmd = String.format("Select staffID, staffName, staffPerms from Staff where staffUN = '%s' and staffPW = '%s';", username, passwordHash);
            ResultSet rs = sqlUtil.executeQuery(cmd);
            if (rs.next()){
                //Get info
                int stfId = rs.getInt("staffID");
                String stfName = rs.getString("staffName");
                int stfPerms = rs.getInt("staffPerms");
                stf = new Staff(stfId, stfName, stfPerms);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stf;
    }
    private int getUnusedID() {
        int i = 0;
        String cmdTemplate = "SELECT * FROM Staff WHERE staffID = %d";
        try {
            while(sqlUtil.executeQuery(String.format(cmdTemplate, i)).next()) {
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public int addStaff(String name, String username, String password, int perms) {
        int staffID = getUnusedID();
        username = InputSanitizer.sanitize(username);
        password = PasswordHasher.hashPassword(password);
        String cmdTemplate = "INSERT INTO Staff(staffID, staffName, staffUN, staffPW, staffPerms) VALUES('%d', '%s', '%s', '%s', '%d')";
        String cmd = String.format(cmdTemplate, staffID, name, username, password, perms);
        return sqlUtil.executeUpdate(cmd);
    }
    public int deleteStaff(int stfID) {
        String cmdTemplate = "delete from Staff where staffID = %d";
        String cmd = String.format(cmdTemplate, stfID);
        return sqlUtil.executeUpdate(cmd);
    }
    public int updateStaff(int id, String name, String username, String password, int perms) {
        username = InputSanitizer.sanitize(username);
        password = PasswordHasher.hashPassword(password);
        String cmdTemplate = "UPDATE Staff SET staffName = '%s', staffUN = '%s', staffPW = '%s', staffPerms = %d WHERE staffID = %d;";
        String cmd = String.format(cmdTemplate, name, username, password, perms, id);
        return sqlUtil.executeUpdate(cmd);
    }
    public List<Staff> loadStaff(String keyword) {
        List<Staff> staffList = new ArrayList<>();
        String cmdTemplate = "SELECT staffID, staffName, staffPerms FROM Staff WHERE staffName LIKE '%s'";
        String cmd = String.format(cmdTemplate, "%" + keyword + "%");
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while(rs.next()) {
                int staffID = rs.getInt("staffID");
                String staffName = rs.getString("staffName");
                int staffPerms = rs.getInt("staffPerms");
                Staff staff = new Staff(staffID, staffName, staffPerms);
                staffList.add(staff);
            }
        } catch(SQLException ex) {
            Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staffList;
    }
}