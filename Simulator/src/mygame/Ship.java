/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 * class.Ship
 * @author Enzo van Kessel
 */
public class Ship extends Node {
    
    /*
     * Declaring values used in StoreCrane
     */
    
    AssetManager assetManager;
    Node rootNode;
    
    Node ship = new Node();
    
    
    /**
     * Ship
     * @param assetManager
     * @param rootNode
     */
    public Ship(AssetManager assetManager, Node rootNode){
        this.assetManager = assetManager;
        this.rootNode = rootNode;
    }
        
    /**
     * Create ship
     */
    public void createShip(){
        Spatial shipSpat = assetManager.loadModel("Models/ship.j3o");
        shipSpat.rotate(0, FastMath.PI * 1.5f, 0);
        ship.attachChild(shipSpat);
    }

    /**
     * check loaded
     * @return
     */
    public boolean Checkloaded() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * move ship
     */
    public void move() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
