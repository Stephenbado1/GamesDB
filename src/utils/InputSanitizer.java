/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author bill
 */
public class InputSanitizer {
    public static String sanitize(String input) {
        String sanitized = input.replace(" ", "").replace("\\", "")
                .replace("'", "").replace("\"", "").replace(";", "");
        return sanitized;
    }
}
