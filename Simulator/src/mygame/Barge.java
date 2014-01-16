/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.math.FastMath;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Enzo van Kessel
 */
public class Barge extends Node implements VehController{
    AssetManager assetManager;
    Node barge = new Node();

    public Barge(AssetManager assetManager){
        this.assetManager = assetManager;
    }
    
    /*
     * Creates/loads a bargeship
     */
    public void createBarge(){
        Spatial bargeSpat = assetManager.loadModel("Models/bargeship.j3o");
        barge.attachChild(bargeSpat);
        barge.rotate(0, FastMath.PI / 2, 0);
        
    }
    
    /*
     * chekc if bargeship is loaded
     */
    public boolean Checkloaded() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /*
     * moves bargeship to a certain location
     */
    public void move() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
