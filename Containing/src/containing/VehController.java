/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Niels Riemersma
 */
public interface VehController {
    /*
     * Create a boolean to check if vehicle is loaded
     */
    public boolean Loaded = true;
        
    /*
     * Create method move to let vehicles move around the scene
     * //FROM XYZ(1) TO XYZ(2)
     */
    public void move(float x1, float y1, float z1, float x2, float y2, float y3);
}
