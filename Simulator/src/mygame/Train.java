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
        this.assetManager = assetManager;
    }
    public boolean Checkloaded() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void move() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void createTrain(){
  
       Spatial trainMachine = assetManager.loadModel("Models/Train/trainMachine.j3o");
       this.attachChild(trainMachine);
       trainMachine.setLocalScale(1.5f);
       trainMachine.setLocalTranslation(0.40f, 0, 0);
       
       
       
    }
}
