package controller.containing;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Johan
 */
class clientThread extends Thread {

    private DataInputStream is;
    private PrintStream os;
    private BufferedReader inputLine;
    private Socket clientSocket;

    private String recievedMessage;
    private final clientThread[] threads;
    private boolean open = true;
    int count = 0;
    int kraanID = 0;
    private int connections;
    XMLreader xml = new XMLreader();

    public clientThread(Socket clientSocket, clientThread[] threads) {

        this.clientSocket = clientSocket;
        this.threads = threads;
        this.connections = threads.length;
    }

    public void run() {

        int connections = this.connections;
        clientThread[] threads = this.threads;

        try {
            
            /*
            Creates in input and output stream, so messages can be send and recieved.
            */

            is = new DataInputStream(clientSocket.getInputStream());
            os = new PrintStream(clientSocket.getOutputStream());

            
            while (true) {

                String line = is.readLine();
                
                /*
                A client recieves Ready from the server, and can start sending data.
                */

                if (line.equals("Ready")) {
                    
                    sendDataPackage();
                    
                }

                recievedMessage = is.readLine();
                System.out.println(recievedMessage);

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void sendDataPackage() {
        
        /*
        This reads the list of created containers and if the vehicle is a truck it wil give a crane ID.
        If it's not a truck it wil only give the vehicle and container id.
        This information is then send to the simulation.
        */

        ArrayList<String> vrachtautoParkeerplaats = new ArrayList<>();

        xml.XMLreader();
        for (Container _container : xml._containerList) {

            if (_container.getVervoerder().equals("vrachtauto")) {

                count = vrachtautoParkeerplaats.indexOf("closed");
                if (count == -1) {

                    count = 0;
                }
                vrachtautoParkeerplaats.add(kraanID, "closed");

                if (count == 0) {

                    kraanID++;

                }
                os.println(kraanID);
                

            }
            os.println(_container.getVervoerder());
            os.println(_container.getID());

        }

    }
}
