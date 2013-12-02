/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ivar de Lange
 */
public interface CraneController {
    
    /*
     * Het bewegen van de grijphaak op de horizontale as
     */
    public void moveCraneHor();
    
    int x = 0;
    
    /*
     * Het bewegen van de grijphaak op de verticale as
     */    
    public void  moveCraneVer();
    
    int z = 0;
    
    /*
     * Het neerzetten van de container
     */    
    public void dropC();
    
    /*
     * Het optillen van de container
     */
    public void pickupC();

}
