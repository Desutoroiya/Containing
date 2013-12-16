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
    private AssetManager assetManager;
    public Barge(AssetManager assetManager){
        this.assetManager = assetManager;
    }
    public void createBarge(){
        Spatial barge = assetManager.loadModel("Models/bargeship.j3o");
        this.attachChild(barge);
        barge.rotate(0, FastMath.PI / 2, 0);
        
    }

    public boolean Checkloaded() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void move() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
