/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import utils.SQLUtil;

/**
 *
 * @author stephenbadeaux
 */
public class GameHandler {

    private SQLUtil sqlUtil;
    
    public GameHandler() {
        sqlUtil = new SQLUtil();
        
    }
    public int addGame(String gameName, String pubName, String releaseDate, int score){
        String cmdTemplate = "insert into Games(gameName, pubName, releaseDate, score) values('%s', '%s', '%s', '%f', '%d')";
        String cmd = String.format(cmdTemplate, gameName, pubName, releaseDate, score);
        return sqlUtil.executeUpdate(cmd);
    }
}
