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
public class Truck extends Node implements VehController  {
    private AssetManager assetManager;
    
    public Truck(AssetManager assetManager){
        this.assetManager = assetManager;
    }
    
    public void move(){
        
    }

    public boolean Checkloaded() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void CreateTruck(){
        Spatial Cart = assetManager.loadModel("Models/Truck/truckCart.j3o");
        Spatial Truck = assetManager.loadModel("Models/Truck/truckMachine.j3o");
        this.attachChild(Cart);
        this.attachChild(Truck);
        Cart.setLocalTranslation(0,0, 0);
        Truck.setLocalTranslation(0,0f,0);
        
    }
}
