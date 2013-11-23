/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import FileHandler.ContentReader;
import Http.HttpConnection;

/**
 *
 * @author HenryHo
 */
public class Main {

    static final String url = "http://localhost:8080/Tute1-HelloWorld/welcome.htm";

    public static void main(String[] args) {
        
        ContentReader reader = new ContentReader();
        String input = reader.getInput();
        String dataString = reader.readFile(input);
        
        HttpConnection con = new HttpConnection(dataString, Main.url);
        con.sendPostRequest();
    }
}
