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
public class Ship extends Node implements VehController {
    private AssetManager assetManager;
    
    public Ship(AssetManager assetManager){
        this.assetManager = assetManager;
    }
    public void createShip(){
        Spatial ship = assetManager.loadModel("Models/ship.j3o");
        this.attachChild(ship);
        ship.rotate(0, FastMath.PI * 1.5f, 0);
    }

    public boolean Checkloaded() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void move() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
