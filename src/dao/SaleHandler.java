/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bo.Sale;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.SQLUtil;

/**
 *
 * @author stephenbadeaux
 */
public class SaleHandler {
    
    private SQLUtil sqlUtil;
    
    public SaleHandler() {
        sqlUtil = new SQLUtil();
        
    }
    public int addSale(int saleDate, String sRegion, int staffID){
        String cmdTemplate = "insert into Sale(saleDate, sRegion, staffID) values('%d', '%s', '%d')";
        String cmd = String.format(cmdTemplate, saleDate, sRegion, staffID);
        return sqlUtil.executeUpdate(cmd);
    }
    public int deleteSale(int sNo){
        String cmdTemplate = "delete from Sale where sNo = %d";
        String cmd = String.format(cmdTemplate, sNo);
        return sqlUtil.executeUpdate(cmd);
    }
    public List<Sale> getSales(){
        List<Sale> results = new ArrayList<>();
        String cmd = "Select * from Sale;";
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while(rs.next()){
                int sNo = rs.getInt("sNo");
                Date saleDate = rs.getDate("saleDate");
                String sRegion = rs.getString("sRegion");
                int stfId = rs.getInt("staffID");
                Sale s = new Sale(sNo, stfId, saleDate, sRegion, stfId);
                results.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaleHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
    public List<Sale> getSales(String keyword){
        List<Sale> results = new ArrayList<>();
        String cmdTemplate = "Select * from Sale where sNo like '%s'";
        String cmd = String.format(cmdTemplate, "%" + keyword + "%");
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while(rs.next()){
                int sNo = rs.getInt("sNo");
                Date saleDate = rs.getDate("saleDate");
                String sRegion = rs.getString("sRegion");
                int stfId = rs.getInt("staffID");
                Sale s = new Sale(sNo, stfId, saleDate, sRegion, stfId);
                results.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaleHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
}
