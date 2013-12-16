/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.cinematic.MotionPath;
import com.jme3.cinematic.events.MotionEvent;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Ivar
 */
public class BargeCrane extends Node{
    
    private Node rootNode;
    public AssetManager assetManager;
    //private MotionPath ShipBase;
    //private MotionEvent meShipCrane;
    //private Vector3f firstpoint = new Vector3f(0, 0, 0);
    //private Vector3f secondpoint = new Vector3f(0, 5, 0);
    //private int location;
    //private boolean moving = false;
    //private float baseSpeed = 1.0f;
    
    public BargeCrane(AssetManager assetManager) {
        this.assetManager = assetManager;
        this.rootNode = rootNode;
    }
    
    public void createBargeCrane(){
        Spatial BargeCraneLift = assetManager.loadModel("Models/Shipcrane/craneLift.j3o");
        this.attachChild(BargeCraneLift);
        Spatial BargeCraneBase = assetManager.loadModel("Models/Shipcrane/craneBase.j3o");
        this.attachChild(BargeCraneBase);
        Spatial BargeCraneHook = assetManager.loadModel("Models/Shipcrane/craneHook.j3o");
        this.attachChild(BargeCraneHook);
        
        this.setLocalTranslation(0,0,0);
        this.rotate(0, 1.5707f, 0);
    }
}
