/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.*;
import java.net.*;
import java.util.*;
 
public class Client {
 
    public static void main(String[] args) {
 
        String host = "127.0.0.1";
        try (Socket socket = new Socket(host,32000)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            String line = null;
            while (!"exit".equalsIgnoreCase(line)) {
                line = scanner.nextLine();
                out.println(line);
                out.flush();
                System.out.println("Server replied: " + in.readLine());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}