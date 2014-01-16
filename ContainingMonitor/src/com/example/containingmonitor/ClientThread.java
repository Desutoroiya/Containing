package com.example.containingmonitor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class ClientThread implements Runnable {
	
	private static Socket socket;
	
	private static int port = 6060;
	private static String hostname = "10.0.2.2";
	public String recievedMessage;
	ArrayList<String> log = new ArrayList<String>();
	
    private static PrintStream os;
    private static DataInputStream is;
    private static BufferedReader inputLine;

	public static void ClientThread(){
		
		try {
			InetAddress serverAddr = InetAddress.getByName(hostname);
			socket = new Socket(serverAddr, port);
            
			inputLine = new BufferedReader(new InputStreamReader(System.in));
            os = new PrintStream(socket.getOutputStream());
            is = new DataInputStream(socket.getInputStream());
            
		} catch (UnknownHostException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		
	}
	
	@Override
	public void run() {
		
        try{
            
            while(true){
                
               recievedMessage = is.readLine();
               System.out.println(recievedMessage);
               
               if(recievedMessage.equals("Vrachtauto")){
                   
                   
                   
               }
               
               log.add(recievedMessage);
               
               System.out.println(log);
      
            }
            
        }catch(IOException ex){
            ex.printStackTrace();
        }

	}

}
