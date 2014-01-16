/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.containing;

/**
 * class.ControllerContaining
 * @author Johan
 */
public class ControllerContaining{
    /**
     * @param args the command line arguments
     */
    static MainFrame frame;
    
    /**
     * main entry for the application
     * @param args
     */
    public static void main(String[] args) {
        
        frame = new MainFrame();
        frame.setVisible(true);
        Server server = new Server();
        
    }
}
