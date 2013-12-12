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
public class TrainCrane extends Node{
    private Node rootNode;
    public AssetManager assetManager;
    private MotionPath trainBase;
    private MotionEvent motionControl;
    public boolean loaded = false;
    
    
    public TrainCrane(AssetManager assetManager){
        this.assetManager = assetManager;
        this.rootNode = rootNode;
    }
    
    public void createTrainCrane(){
    Spatial TrainCraneLift = assetManager.loadModel("Models/scraneLift.j3o");
       this.attachChild(TrainCraneLift);
       Spatial TrainCraneBase = assetManager.loadModel("Models/scraneBase.j3o");
       this.attachChild(TrainCraneBase);
       
       this.setLocalTranslation(69.5f,0,24f);
       this.rotate(0,1.5707f,0);
       rootNode.attachChild(this);
    }
    
    public void moveBase(){
        
        trainBase = new MotionPath();
        trainBase.addWayPoint(new Vector3f (0,0,0));
        trainBase.addWayPoint(new Vector3f (0,5,0));
    }
}
