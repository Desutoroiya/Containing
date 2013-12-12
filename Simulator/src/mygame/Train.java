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
public class Train extends Node implements VehController {
    private AssetManager assetManager;

    public Train(AssetManager assetManager){
        
    }
    public boolean Checkloaded() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void move() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void createTrain(){
       Spatial train = assetManager.loadModel("Models/Train.j3o");
       this.attachChild(train);
       
    }
}
