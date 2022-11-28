/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bo.Sale;
import bo.SaleItems;
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
public class SaleItemHandler {
    
    private SQLUtil sqlUtil;
    
    public SaleItemHandler() {
        sqlUtil = new SQLUtil();
    }
    public List<SaleItems> loadSaleItems(String keyword){
        List<SaleItems> saleItems = new ArrayList<>();
        String cmdTemplate = "select * from SaleItems where sNo like '%d'";
        String cmd = String.format(cmdTemplate, "%" + keyword + "%");
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while(rs.next()){
                int sNo = rs.getInt("sNo");
                int gID = rs.getInt("gID");
                double sPrice = rs.getDouble("sPrice");
                SaleItems saleItem = new SaleItems(sNo, gID, sPrice);
                saleItems.add(saleItem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaleHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saleItems;
    }
}
