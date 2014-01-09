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
    Node bargeCraneLift = new Node();
    Node bargeCraneBase = new Node();
    Node bargeCraneHook = new Node();
    
    public AssetManager assetManager;
    private MotionPath bargeBase;
    private MotionPath bargeHook;
    private MotionPath bargeLift;
    private MotionEvent meBargeCrane;
    private MotionEvent meBargeHook;
    private MotionEvent meBargeLift;
    public float x = 0f;
    public float y = 0;
    public float z = 0f;
    Vector3f Position = new Vector3f(x, y, z);
    private float baseSpeed = 1.0f;
    
    public BargeCrane(AssetManager assetManager) {
        this.assetManager = assetManager;
        this.rootNode = rootNode;
    }
    
    public void createBargeCrane(){
        Spatial BargeCraneLift = assetManager.loadModel("Models/Bargecrane/bargeCraneLift.j3o");
        Spatial BargeCraneBase = assetManager.loadModel("Models/Bargecrane/bargeCraneBase.j3o");
        Spatial BargeCraneHook = assetManager.loadModel("Models/Bargecrane/bargeCraneHook.j3o");
        
        bargeCraneLift.attachChild(BargeCraneLift);
        bargeCraneBase.attachChild(BargeCraneBase);
        bargeCraneHook.attachChild(BargeCraneHook);
        
        bargeCrane.attachChild(BargeCraneLift);
        bargeCrane.attachChild(BargeCraneBase);
        bargeCrane.attachChild(BargeCraneHook);
        
        bargeCrane.rotate(0, 1.5707f, 0);
    }
     public void moveBase(float x, float y, float z) {

        bargeBase = new MotionPath();
        for (int i = 0; i < 50; i++){
        bargeBase.addWayPoint(new Vector3f(x, y, z));
        bargeBase.addWayPoint(new Vector3f(x + 5, y, z));
        }
        meBargeCrane = new MotionEvent(bargeCrane, bargeBase);
        bargeBase.setCurveTension(0f);
        meBargeCrane.setSpeed(baseSpeed * 0.005f);
        meBargeCrane.play();
    }

    public void moveHook() {
        Spatial destoreHook = bargeCrane.getChild(2);
        bargeHook = new MotionPath();
        
        bargeHook.addWayPoint(new Vector3f(Position));
        bargeHook.addWayPoint(new Vector3f(Position.x, Position.y - 0.5f, Position.z));
        bargeHook.setCycle(true);
    
        meBargeHook = new MotionEvent(destoreHook, bargeHook);
        bargeHook.setCurveTension(0f);
        meBargeHook.setSpeed(baseSpeed * 0.01f);
        meBargeHook.play();
    }

    public void moveLift() {
        Spatial destoreLift = bargeCrane.getChild(0);
        bargeLift = new MotionPath();
        
        bargeLift.addWayPoint(new Vector3f(Position));      
        bargeLift.addWayPoint(new Vector3f(Position.x + 6f, Position.y, Position.z));   
        bargeLift.setCycle(true);
        
        meBargeLift = new MotionEvent(destoreLift, bargeLift);
        bargeLift.setCurveTension(0f);
        meBargeLift.setSpeed(baseSpeed * 0.01f);
        meBargeLift.play();

        Spatial destoreHook = bargeCrane.getChild(2);
        bargeHook = new MotionPath();
        
        bargeHook.addWayPoint(new Vector3f(Position));
        bargeHook.addWayPoint(new Vector3f(Position.x + 6f, Position.y, Position.z));
        bargeHook.setCycle(true);
        
        meBargeHook = new MotionEvent(destoreHook, bargeHook);
        bargeHook.setCurveTension(0f);
        meBargeHook.setSpeed(baseSpeed * 0.01f);
        meBargeHook.play();
    }
}
