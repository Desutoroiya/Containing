/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Enzo van Kessel
 */
public class Barge extends Node implements VehController{
    private AssetManager assetManager;
    public Barge(AssetManager assetManager){
        this.assetManager = assetManager;
    }
    public void createBarge(){
        Spatial barge = assetManager.loadModel("Models/ship.j3o");
        this.attachChild(barge);
        this.scale(0.5f, 1, 1);
        
    }

    public boolean Checkloaded() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void move() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
