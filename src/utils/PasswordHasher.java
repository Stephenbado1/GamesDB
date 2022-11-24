/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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