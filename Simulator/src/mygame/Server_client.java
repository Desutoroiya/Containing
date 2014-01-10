/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fons
 */
public class Server_client implements Runnable
{
    
    private static Socket clientSocket;
    private static PrintStream os;
    private static DataInputStream is;
    private static BufferedReader inputLine;
    
    private static boolean open = true;
    private static String hostname;
    private static int port;
    private static String sendMessage;
    private static String recievedMessage;
    public static List<String> log = new ArrayList<String>();
    
    public static void client(){
        
        hostname = "localhost";
        port = 6060;
        try {
            
            clientSocket = new Socket(hostname, port);
            inputLine = new BufferedReader(new InputStreamReader(System.in));
            os = new PrintStream(clientSocket.getOutputStream());
            is = new DataInputStream(clientSocket.getInputStream());
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        if(clientSocket != null && os != null && is != null){
            
            try{
                
               new Thread(new Server_client()).start();
               os.println("Ready");
               
               while(open){
                   
                   os.println(inputLine.readLine());
                   
               }
              os.close();
              is.close();
              clientSocket.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    
    public void run(){
        
        try{
            
            while(true){
                
               recievedMessage = is.readLine();
               System.out.println(recievedMessage);
               
               if(recievedMessage.equals("Vrachtauto")){
                   
                   
                   
               }
               
               log.add(recievedMessage);
               
               //System.out.println(log);
      
            }
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
}
