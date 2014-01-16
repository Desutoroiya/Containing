package controller.containing;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Johan
 */
public class Server {
    
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintStream os;
    
    private final int connections = 2;
    private final clientThread[] threads = new clientThread[connections];
    private int port;
    
    public Server(){
       
       /*
        connects to a socket with a given port.
        */ 
        
       port = 6060;
       
       try{
           
           serverSocket = new ServerSocket(port);
           
           
       }catch(IOException ex){
           ex.printStackTrace();
       }
       
       /*
       Creates a new thread if a client connects and the amount connections is lower than 2.
       If 2 clients are already connected, a third will fail to connect
       We chose 2 so we have one for the simulation and the andriod application.
       */
       while(true){
           
           try{
               
               clientSocket = serverSocket.accept();
               int i =0;
               
               for(i = 0; i < connections; i++){
                   
                   if(threads[i] == null){
                       
                       (threads[i] = new clientThread(clientSocket, threads)).start();
                       break;
                   }
                   
               }
               
               if(i == connections){
                   
                   os = new PrintStream(clientSocket.getOutputStream());
                   os.println("All Applications are already Connected.");
                   os.close();
                   clientSocket.close();
                   threads[0].sendDataPackage();
                   
               }
               
           }catch(IOException ex){
               ex.printStackTrace();
           }
           
       }
        
    }
    
}
