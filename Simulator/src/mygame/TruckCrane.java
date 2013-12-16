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
 * @author Johan
 */
public class TruckCrane extends Node {

    public AssetManager assetManager;
    private Node rootNode;
    Node craneLift = new Node();
    private MotionPath mpBase;
    private MotionPath mpHook;
    private MotionEvent meTCrane;
    private MotionEvent meTCHook;
    
    private float X = 0;//69.5f;
    private float Y = 0;
    private float Z = 0;//24f;
    
    
    private int location;
    private boolean moving = false;
    private float baseSpeed = 1.0f;

    public TruckCrane(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public void createTruckCrane(int id) {
        /*
         * Creates a new cranelift for trucks
         */
        
        Spatial TCraneLift = assetManager.loadModel("Models/Storagecrane/scraneLift.j3o");
        Spatial TCraneBase = assetManager.loadModel("Models/Storagecrane/scraneBase.j3o");
        Spatial TCraneHook = assetManager.loadModel("Models/Storagecrane/scraneHook.j3o");
        
        Vector3f Position = new Vector3f(X,Y,Z);
        
        TCraneBase.setLocalTranslation(Position);
        TCraneLift.setLocalTranslation(new Vector3f(Position.x, Position.y - 0.25f, Position.z));
        TCraneHook.setLocalTranslation(new Vector3f(Position.x, Position.y - 0.27f, Position.z));
        
        craneLift.attachChild(TCraneLift);
        craneLift.attachChild(TCraneBase);
        craneLift.attachChild(TCraneHook);
        
        craneLift.rotate(0, FastMath.PI/2, 0);
    }

    public void moveBase(float X, float Y, float Z) {
        //get id crane
        mpBase = new MotionPath();
        mpBase.addWayPoint(new Vector3f(X,Y,Z));
        mpBase.addWayPoint(new Vector3f(X,Y,Z+2));

        meTCrane = new MotionEvent(craneLift, mpBase);
        mpBase.setCurveTension(0f);
        meTCrane.setSpeed(baseSpeed);
        meTCrane.play();
        
    }

    public void moveHook() {
        
        
         mpHook = new MotionPath();
         mpHook.addWayPoint(new Vector3f(craneLift.getLocalTranslation().x, craneLift.getLocalTranslation().y, craneLift.getLocalTranslation().z));
         mpHook.addWayPoint(new Vector3f(craneLift.getLocalTranslation().x, craneLift.getLocalTranslation().y - 0.15f, craneLift.getLocalTranslation().z));
            
         meTCHook = new MotionEvent(craneLift, mpHook);
         mpHook.setCurveTension(0f);
         meTCHook.setSpeed(baseSpeed);
         meTCHook.play();
    }
}
