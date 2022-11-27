/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
/**
 *
 * @author stephenbadeaux
 */
public class SQLUtil {
    private Connection con;
    private Statement stm;

    public SQLUtil() {
        String url = "jdbc:mysql://localhost:8889/Game?allowMultiQueries=false";
        String username = "root";
        String password = "root";
        
        try {
            con = DriverManager.getConnection(url, username, password);
            stm = con.createStatement();//PreparedStatement
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnection(){
        return con;
    }
    public Statement getStatement(){
        return stm;
    }
    public void closeConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
        }
    }
    @Override
    protected void finalize() throws Throwable {
        closeConnection(); 
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
    public int executeUpdate(String cmd){
        try {
            return this.stm.executeUpdate(cmd);
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public ResultSet executeQuery(String cmd){
        try {
            return this.stm.executeQuery(cmd);
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }
} 