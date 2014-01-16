/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 * class.TrainWagon
 * @author Enzo van Kessel
 */
public class TrainWagon extends Node implements VehController {
    
    /*
     * Declaring values that are used in TrainWagon
     */
    
    Node trainwagon = new Node();
    boolean loaded= true;
    private AssetManager assetManager;
    private Spatial container;
   
    
    /**
     * TrainWagon
     * @param assetManager
     */
    public TrainWagon(AssetManager assetManager) {
        this.assetManager = assetManager;
        
    }
    
    /**
     * checks if train is loaded, returns bool loaded
     * @return
     */
    public boolean Checkloaded() {
        return loaded;
    }

    /**
     * moves the train
     */
    public void move() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * gets the position of the train
     * @return
     */
    public Vector3f getPosition(){
        return this.getLocalTranslation();
    }
        
    /**
     * Creates a trainwagon
     */
    public void CreateWagon(){
        Spatial trainCart = assetManager.loadModel("Models/Train/trainCart.j3o");
        trainwagon.attachChild(trainCart);
        trainwagon.setLocalTranslation(0, 0, 0);
    }
    
    /**
     * attaches container to trainwagon
     */
    public void attachContainer(){
        container = assetManager.loadModel("Models/container.j3o");
        trainwagon.attachChild(container);
        container.setLocalTranslation(0, 0.1f, 0);
        container.rotate(0, FastMath.HALF_PI, 0);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.randomColor());
        container.setMaterial(mat);
    }
    
    /**
     * detaches container
     */
    public void detachContainer(){
         container.removeFromParent();
    }
    }

