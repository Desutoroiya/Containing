/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package containing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Fons
 */
public class Server_client 
{
    public static void main(String[] args)
    {
        try
        {
            Socket sock = new Socket("localhost", 9999);
            PrintStream pr = new PrintStream(sock.getOutputStream());
            
            System.out.print("Enter something: ");
            
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader ed = new BufferedReader(rd);
            
            String temp = ed.readLine();
            pr.println(temp);
        }
        catch(Exception e)
        {

        }
    }
}
