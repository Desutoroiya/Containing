package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.cinematic.MotionPath;
import com.jme3.cinematic.events.MotionEvent;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.math.BigDecimal;

/**
 * class.TruckCrane
 * @author Niels
 */
public class TruckCrane extends Node{
    
    /*
     * Declaring values needed in TruckCrane
     */
    
    /**
     * assetmanager
     */
    public AssetManager assetManager;
    
    Truck[] truck;
    AGV[] agv;

    /**
     * cranepos, used in switchcase to determine location (and case)
     */
    public int cranepos = 0;
    
    Spatial TCraneLift;
    Spatial TCraneBase;
    Spatial TCraneHook;
    
    Node truckCraneNode = new Node();
    
    Node craneLift = new Node();
    Node craneHook = new Node();
    Node craneBase = new Node();
    
    private MotionPath mpBase;
    private MotionPath mpHook;
    private MotionEvent meTCrane;
    private MotionEvent meTCHook;
    
    /**
     * gets the localtranslation for the truckcrane
     */
    public Vector3f craneLoc = truckCraneNode.getLocalTranslation();
    /**
     * gets the localtranslation for the hook of the truckcrane
     */
    public Vector3f hookLoc = craneHook.getLocalTranslation();
    
    private float baseSpeed = 1.0f;

    /**
     * TruckCrane
     * @param assetManager
     */
    public TruckCrane(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    /**
     * Creates a new cranelift for trucks
     */
    public void createTruckCrane() {
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
        
        truckCraneNode.attachChild(craneLift);
        truckCraneNode.attachChild(craneBase);
        truckCraneNode.attachChild(craneHook);
        
        /*
         * Rotate crane
         */

        truckCraneNode.rotate(0, FastMath.PI / 2, 0);
    }

    /**
     * Moves base on the z axis by value zmove
     * @param zmove
     */
    public void moveBase(float zmove) {
        mpBase = new MotionPath();
        mpBase.addWayPoint(craneLoc);
        mpBase.addWayPoint(new Vector3f(craneLoc.x, craneLoc.y, craneLoc.z + zmove));
        mpBase.setCycle(false);
        
        meTCrane = new MotionEvent(truckCraneNode, mpBase);
        mpBase.setCurveTension(0f);
        meTCrane.setSpeed(baseSpeed*2);
        meTCrane.play();
    }

    /**
     * Moves the hook on the y axis by value ymove
     * @param ymove
     */
    public void moveHook(float ymove) {
        mpHook = new MotionPath();
                
        mpHook.addWayPoint(hookLoc);
        mpHook.addWayPoint(new Vector3f(hookLoc.x, hookLoc.y + ymove, hookLoc.z));
        mpHook.setCycle(false);
        
        meTCHook = new MotionEvent(craneHook, mpHook);
        mpHook.setCurveTension(0f);
        meTCHook.setSpeed(baseSpeed*10);
        meTCHook.play();
    }
    
    /**
     * Method precision to round floats to two decimals to eliminate misstakes
     * @param decimalPlace
     * @param d
     * @return
     */
    public static Float precision(int decimalPlace, Float d) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    
    /**
     * Here the update variables are stored
     */
    public static int localID = 0;
    /**
     * Here the update variables are stored
     */
    public static int craneID = 0;
    
    /**
     * bool busy, = true when crane in motion
     */
    public static boolean busy = false;
    /**
     * bool loaded, true when a container is loaded onto it
     */
    public static boolean loaded = false;
    
    /**
     * Update function that moves the cranes in the right sequence
     * @param tpf
     */
    public void update(float tpf){
        
        float craneHookPos = precision(2, craneHook.getLocalTranslation().y);
        float truckCranePos = precision(2, truckCraneNode.getLocalTranslation().z);
        
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
                    moveHook(-0.6f);
                }
                else if (craneHookPos == -0.6f && busy !=false){
                    truckToCrane(Main.truck[localID], Main.truckCrane[localID], Main.container[localID]);
                    cranepos = 3;
                    busy = false;
                    loaded = true;
                }
                break;
            case 3:
                // MOVE HOOK UP
                if (truckCranePos == 24.0f && craneHookPos == -0.6f){
                    busy = true;
                    moveHook(0.6f);
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
                    moveHook(-0.6f);
                }
                else if (craneHookPos == -0.6f && busy !=false){
                    craneToAgv(Main.agv[0], Main.truckCrane[localID], Main.container[localID]);
                    cranepos = 6;
                    busy = false;
                }
                break;
            case 6:
                // MOVE HOOK UP
                if (truckCranePos == 22.0f && craneHookPos == -0.6f){
                    busy = true;
                    moveHook(0.6f);
                }
                else if (craneHookPos == 0.0f && busy !=false){
                    cranepos = 0;
                    busy = false;
                }
                break;
        }
    }
    
    /**
     * Function that moves container from Truck to Crane
     * @param truck
     * @param crane
     * @param container
     */
    public void truckToCrane(Truck truck, TruckCrane crane, Container container){
        truck.truck.detachChild(container.contNode);
        crane.craneHook.attachChild(container.contNode);
        container.contNode.setLocalTranslation(0, 0.8f, 0);
    }
    
    /**
     * Function that moves container from crane to AGV
     * @param agv
     * @param truckCrane
     * @param container
     */
    public void craneToAgv(AGV agv, TruckCrane truckCrane, Container container){
        truckCrane.craneHook.detachChild(container.contNode);
        agv.agv.attachChild(container.contNode);
        container.contNode.setLocalTranslation(0,0.35f,0);
    }
    
    /**
     * Function that moves container from AGV to crane
     * @param agv
     * @param truckCrane
     * @param container
     */
    public void agvToCrane(AGV agv, TruckCrane truckCrane, Container container){
        agv.agv.detachChild(container.contNode);
        truckCrane.craneHook.attachChild(container.contNode);
        container.contNode.setLocalTranslation(0,0.4f,0);
    }
    
    /**
     * Function that moves container from crane to truck
     * @param truck
     * @param truckCrane
     * @param container
     */
    public void craneToTruck(Truck truck, TruckCrane truckCrane, Container container){
        truckCrane.craneHook.detachChild(container.contNode);
        truck.truck.attachChild(container.contNode);
        container.contNode.setLocalTranslation(0,0.4f,0);
    }
}