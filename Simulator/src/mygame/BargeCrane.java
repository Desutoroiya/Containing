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
    Node bargeCrane = new Node();
    public AssetManager assetManager;
    //private MotionPath ShipBase;
    //private MotionEvent meShipCrane;
    //private float baseSpeed = 1.0f;
    
    public BargeCrane(AssetManager assetManager) {
        this.assetManager = assetManager;
        this.rootNode = rootNode;
    }
    
    public void createBargeCrane(){
        Spatial BargeCraneLift = assetManager.loadModel("Models/Bargecrane/bargeCraneLift.j3o");
        Spatial BargeCraneBase = assetManager.loadModel("Models/Bargecrane/bargeCraneBase.j3o");
        Spatial BargeCraneHook = assetManager.loadModel("Models/Bargecrane/bargeCraneHook.j3o");
        
        bargeCrane.attachChild(BargeCraneLift);
        bargeCrane.attachChild(BargeCraneBase);
        bargeCrane.attachChild(BargeCraneHook);
        
        bargeCrane.rotate(0, 1.5707f, 0);
    }
}
