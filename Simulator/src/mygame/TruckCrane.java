package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.cinematic.MotionPath;
import com.jme3.cinematic.events.MotionEvent;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.math.BigDecimal;
import java.text.DecimalFormat;

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
    public float Y = 0f;
    public float Z = 0f;
    
    Vector3f Position = new Vector3f(X, Y, Z);
    private float baseSpeed = 1.0f;

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
        
        /*
         * Create seperate nodes for each spatial
         */

        craneLift.attachChild(TCraneLift);
        craneBase.attachChild(TCraneBase);
        craneHook.attachChild(TCraneHook);
        
        /*
         * Create one node for the entire crane
         */
        
        truckCrane.attachChild(craneLift);
        truckCrane.attachChild(craneBase);
        truckCrane.attachChild(craneHook);
        
        /*
         * Rotate crane
         */

        truckCrane.rotate(0, FastMath.PI / 2, 0);
    }
    
    public Vector3f location = truckCrane.getLocalTranslation();
    public Vector3f position = craneHook.getLocalTranslation();

    public void moveBase(float zmove) {
        mpBase = new MotionPath();
        mpBase.addWayPoint(location);
        mpBase.addWayPoint(new Vector3f(location.x, location.y, location.z + zmove));
        mpBase.setCycle(false);
        
        meTCrane = new MotionEvent(truckCrane, mpBase);
        mpBase.setCurveTension(0f);
        meTCrane.setSpeed(baseSpeed*2);
        meTCrane.play();
    }

    public void moveHook(float ymove) {
        mpHook = new MotionPath();
                
        mpHook.addWayPoint(position);
        mpHook.addWayPoint(new Vector3f(position.x, position.y + ymove, position.z));
        mpHook.setCycle(false);
        
        meTCHook = new MotionEvent(craneHook, mpHook);
        mpHook.setCurveTension(0f);
        meTCHook.setSpeed(baseSpeed*20);
        meTCHook.play();
    }
    
    public float z;
    public float y;
    
    private int cranepos = 1;
    private boolean busy = false;
    
    public static Float precision(int decimalPlace, Float d) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    
    public void update(float tpf){
        
        float truckCraneF = truckCrane.getLocalTranslation().z;
        float truckCranePos = precision(2,truckCraneF);
        
        float craneHookF = craneHook.getLocalTranslation().y;
        float craneHookPos = precision(2, craneHookF);
        
        System.out.println("TruckCrane  "+ truckCranePos);
        System.out.println("CraneHook  " + craneHookPos);
        
        switch (cranepos){
            case 0:
            //doe niks
                break;
                
            case 1:
                // MOVE NAAR TRUCK
                if (truckCranePos == 22.0f){
                    busy = true;
                    moveBase(2);
                }
                else if (truckCranePos == 24.0f && busy != false){
                    cranepos = 2;
                    busy = false;
                }
                break;
            case 2:
                // MOVE HOOK DOWN
                if (truckCranePos == 24.0f && craneHookPos == 0.0f){
                    busy = true;
                    moveHook(-0.8f);
                }
                else if (craneHookPos == -0.8f && busy !=false){
                    cranepos = 3;
                    busy = false;
                }
                break;
            case 3:
                // MOVE HOOK UP
                if (truckCranePos == 24.0f && craneHookPos == -0.8f){
                    busy = true;
                    moveHook(0.8f);
                }
                else if (craneHookPos == 0.0f && busy !=false){
                    cranepos = 4;
                    busy = false;
                }
                break;
            case 4:
                // RIJD KRAAN
                if (truckCranePos == 24.0f && craneHookPos == 0.0f){
                    busy = true;
                    moveBase(-2);
                }
                else if (truckCranePos == 22.0f && busy != false){
                    cranepos = 5;
                    busy = false;
                }
                break;
            case 5:
                // MOVE HOOK DOWN
                if (truckCranePos == 22.0f && craneHookPos == 0.0f){
                    busy = true;
                    moveHook(-0.8f);
                }
                else if (craneHookPos == -0.8f && busy !=false){
                    cranepos = 6;
                    busy = false;
                }
                break;
            case 6:
                // MOVE HOOK UP
                if (truckCranePos == 22.0f && craneHookPos == -0.8f){
                    busy = true;
                    moveHook(0.8f);
                }
                else if (craneHookPos == 0.0f && busy !=false){
                    cranepos = 0;
                    busy = false;
                }
                break;
        }
    }
    
    public void loadContainer(){
        
    }
}