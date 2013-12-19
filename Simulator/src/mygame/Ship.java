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
    AssetManager assetManager;
    Node rootNode;
    Node ship = new Node();
    
    
    public Ship(AssetManager assetManager, Node rootNode){
        this.assetManager = assetManager;
        this.rootNode = rootNode;
    }
    public void createShip(){
        Spatial shipSpat = assetManager.loadModel("Models/ship.j3o");
        shipSpat.rotate(0, FastMath.PI * 1.5f, 0);
        ship.attachChild(shipSpat);
    }

    public boolean Checkloaded() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void move() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
