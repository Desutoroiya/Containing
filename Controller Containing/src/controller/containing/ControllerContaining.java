/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.containing;

/**
 *
 * @author Ivar
 */
public class ControllerContaining{
    /**
     * @param args the command line arguments
     */
    static MainFrame frame;
    
    public static void main(String[] args) {
        
        frame = new MainFrame();
        frame.setVisible(true);
        Server server = new Server();
        
    }
}
