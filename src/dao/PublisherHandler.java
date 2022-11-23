/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bo.Publisher;
import java.util.ArrayList;
import java.util.List;
import utils.SQLUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stephenbadeaux
 */
public class PublisherHandler {
    private SQLUtil SQLUtil;

    public PublisherHandler() {
        SQLUtil = new SQLUtil();
        
    }
    public List<Publisher> getPublisher(){
        List<Publisher> results = new ArrayList<Publisher>();
        String cmd = "select name, country from Publisher;";
        ResultSet rs = SQLUtil.executeQuery(cmd);
        try {
            while (rs.next()){
                String pName = rs.getString("name");
                String pCountry = rs.getString("country");
                Publisher p = new Publisher(pName, pCountry);
                results.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublisherHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
    
}
