/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Base64;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author William Pearce
 */
public class PasswordHasher {
    public static String hashPassword(String password) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] mdRet = md.digest(password.getBytes());
            result = Base64.getEncoder().encodeToString(mdRet);
        } catch(NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordHasher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}