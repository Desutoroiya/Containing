/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.cinematic.MotionPath;
import com.jme3.cinematic.events.MotionEvent;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;



/**
 *
 * @author Ivar
 */
public class ShipCrane extends Node{
    
    private Node rootNode;
    Node shipCrane = new Node();
    public AssetManager assetManager;
    private MotionPath shipBase;
    private MotionPath shipHook;
    private MotionPath shipLift;
    private MotionEvent meShipCrane;
    private MotionEvent meShipHook;
    private MotionEvent meShipLift;
    public float x = 0f;
    public float y = 0;
    public float z = 0f;
    Vector3f Position = new Vector3f(x, y, z);
    private float baseSpeed = 1.0f;
    
    public ShipCrane(AssetManager assetManager) {
        this.assetManager = assetManager;
        this.rootNode = rootNode;
    }
    
    public void createShipCrane(){
        Spatial ShipCraneLift = assetManager.loadModel("Models/Shipcrane/craneLift.j3o");
        Spatial ShipCraneBase = assetManager.loadModel("Models/Shipcrane/craneBase.j3o");
        Spatial ShipCraneHook = assetManager.loadModel("Models/Shipcrane/craneHook.j3o");
        
        shipCrane.attachChild(ShipCraneLift);
        shipCrane.attachChild(ShipCraneBase);
        shipCrane.attachChild(ShipCraneHook);
    }
}
