/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Enzo van Kessel
 */
public class TrainWagon extends Node implements VehController {
    boolean loaded;
    private AssetManager assetManager;
    public TrainWagon(AssetManager assetManager) {
        this.assetManager = assetManager;
    }
    
    
    public boolean Checkloaded() {
        return loaded;
    }

    public void move() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public Vector3f getPosition(){
        return this.getLocalTranslation();
    }
    
    public void CreateWagon(){
        
        Spatial trainCart = assetManager.loadModel("Models/Train/trainCart.j3o");
        this.attachChild(trainCart);
        trainCart.setLocalTranslation(1.43f, 0, 0);
        }
    }

