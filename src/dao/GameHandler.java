/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bo.Game;
import java.util.ArrayList;
import java.util.List;
import utils.SQLUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stephenbadeaux
 */
public class GameHandler {

    private SQLUtil sqlUtil;
    
    public GameHandler() {
        sqlUtil = new SQLUtil();
        
    }
    public int addGame(String gameName, String pubName, int releaseDate, int score){
        String cmdTemplate = "insert into Games(gameName, pubName, releaseDate, score) values('%s', '%s', '%d', '%d')";
        String cmd = String.format(cmdTemplate, gameName, pubName, releaseDate, score);
        return sqlUtil.executeUpdate(cmd);
    }
    public int deleteGame(int gID){
        String cmdTemplate = "delete from Game where sID = %d";
        String cmd = String.format(cmdTemplate, gID);
        return sqlUtil.executeUpdate(cmd);
    }
    public int updateGame(int gID, String gameName, String pubName, int releaseDate, int score){
        String cmdTemplate = "Update Game set gameName = '%s', pubName = '%s', releaseDate = '%d', score = '%d' where gID = %d;";
        String cmd = String.format(cmdTemplate, gameName, pubName, releaseDate, score, gID);
        return sqlUtil.executeUpdate(cmd);
    }
    public List<Game> loadGames(String keyword){
        List<Game> games = new ArrayList<>();
        String cmdTemplate = "Select gID, gameName, pubName, releaseDate, score from Games where gameName like '%s'";
        String cmd = String.format(cmdTemplate, "%" + keyword + "%");
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()){
                //Get info
                int gId = rs.getInt("gID");
                String gameName = rs.getString("gameName");
                String pubName = rs.getString("pubName");
                Date releaseDate = rs.getDate("releaseDate");
                int score = rs.getInt("score");
                Game game = new Game(gId, gameName, pubName, releaseDate, score);
                games.add(game);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return games;
    }
}
