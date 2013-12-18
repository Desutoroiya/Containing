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
 *
 * @author Enzo van Kessel
 */
public class TrainWagon extends Node implements VehController {
    boolean loaded= true;
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
        trainCart.setLocalTranslation(0, 0, 0);
        if(loaded){
            Spatial container = assetManager.loadModel("Models/container.j3o");
            this.attachChild(container);
            container.setLocalTranslation(0, 0.1f, 0);
            container.rotate(0,FastMath.HALF_PI,0);
             Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
             mat.setColor("Color", ColorRGBA.randomColor());
        container.setMaterial(mat);
        }
        }
    }

