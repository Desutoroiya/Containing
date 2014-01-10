package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.cinematic.MotionPath;
import com.jme3.cinematic.MotionPathListener;
import com.jme3.cinematic.events.MotionEvent;
import com.jme3.cinematic.events.MotionTrack;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Johan
 */
public class TruckCrane extends Node{

    public AssetManager assetManager;
    
    Spatial TCraneLift;
    Spatial TCraneBase;
    Spatial TCraneHook;
    
    Node truckCrane = new Node();
    
    Node craneLift = new Node();
    Node craneHook = new Node();
    Node craneBase = new Node();
    
    private MotionPath mpBase;
    private MotionPath mpHook;
    private MotionPath mpLift;
    private MotionEvent meTCrane;
    private MotionEvent meTCHook;
    private MotionEvent meTCLift;
    
    public float X = 0f;
    public float Y = 0;
    public float Z = 0f;
    
    private int status = 0;
    
    Vector3f Position = new Vector3f(X, Y, Z);
    private float baseSpeed = 1.0f;
    
    private boolean busy = true;
    
    private boolean setBusy(){
        return this.busy = busy;
    }
    
    private boolean getBusy(){
        return this.busy = busy;
    }

    public TruckCrane(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public void createTruckCrane() {
        /*
         * Creates a new cranelift for trucks
         */
        TCraneLift = assetManager.loadModel("Models/Truckcrane/truckCraneLift.j3o");
        TCraneBase = assetManager.loadModel("Models/Truckcrane/truckCraneBase.j3o");
        TCraneHook = assetManager.loadModel("Models/Truckcrane/truckCraneHook.j3o");

        craneLift.attachChild(TCraneLift);
        craneBase.attachChild(TCraneBase);
        craneHook.attachChild(TCraneHook);
        
        truckCrane.attachChild(craneLift);
        truckCrane.attachChild(craneBase);
        truckCrane.attachChild(craneHook);

        truckCrane.rotate(0, FastMath.PI / 2, 0);
    }

    public void moveBase(Vector3f location, float zmove) {
        mpBase = new MotionPath();
        mpBase.addWayPoint(location);
        mpBase.addWayPoint(new Vector3f(location.x, location.y, location.z + zmove));
        mpBase.setCycle(false);
        
        meTCrane = new MotionEvent(truckCrane, mpBase);
        mpBase.setCurveTension(0f);
        meTCrane.setSpeed(baseSpeed);
        meTCrane.play();
    }

    public void moveHook(float ymove) {
        mpHook = new MotionPath();
        
        mpHook.addWayPoint(new Vector3f(Position));
        mpHook.addWayPoint(new Vector3f(Position.x, Position.y + ymove, Position.z));
        mpHook.setCycle(false);
        
        meTCHook = new MotionEvent(craneHook, mpHook);
        mpHook.setCurveTension(0f);
        meTCHook.setSpeed(baseSpeed);
        meTCHook.play();
    }
    
    public void unload(TruckCrane truckcrane){
        final MotionPath unload = new MotionPath();
        unload.addListener(new MotionPathListener(){
            public void onWayPointReach(MotionPath unload, int wayPointIndex){
                if (unload.getNbWayPoints() == wayPointIndex + 1){
                    System.out.println("hoi");
                }
            }
        });
        MotionEvent unload1 = new MotionEvent(truckCrane, unload);
        
        unload.addWayPoint(truckcrane.truckCrane.getLocalTranslation());
        unload.addWayPoint(new Vector3f(truckcrane.truckCrane.getLocalTranslation().x,truckcrane.truckCrane.getLocalTranslation().y,truckcrane.truckCrane.getLocalTranslation().z + 2));
        
        unload.setCycle(false);
        
        
        unload.setCurveTension(0f);
        unload1.setSpeed(baseSpeed);
        unload1.play();        
        
        
        
        
    }
    
    public float z;
    public float y;
    
    private int cranepos;
    
    public void locationInfo(TruckCrane crane){
        z = crane.truckCrane.getLocalTranslation().z;
        y = crane.craneHook.getLocalTranslation().y;
        System.out.println("Z="+z);
        System.out.println("Y="+y);
    }
    
    public void update(float tpf){
        switch (cranepos){
            case 0:
            //doe niks
                break;
                
            case 1:
                //doe dingen
                break;
        }
    }
        /*
         * begin boven agv pos
         * kraan boven truck
         * hook naar beneden
         * detach cont van truck, attach aan container
         * hook naar boven
         * kraan naar agv
         * hook naar beneden
         * detach hook, attach agv
         * hook naar boven
         */
    
    public void loadContainer(){
        
    }
}
