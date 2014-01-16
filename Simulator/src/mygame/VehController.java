/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

/**
 *
 * @author Enzo van Kessel
 */

/*
 * Interface for vehicles
 */
public interface  VehController {
    /**
     * checks if vehicle is loaded
     * @return
     */
    public boolean Checkloaded();
    /**
     * moves vehicle
     */
    public void move();
}
