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
 *
 * @author Niels
 */
public class TruckCrane extends Node{
    
    public AssetManager assetManager;
    
    Truck[] truck;
    AGV[] agv;

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
    private MotionPath mpLift;
    private MotionEvent meTCrane;
    private MotionEvent meTCHook;
    private MotionEvent meTCLift;
    
    public Vector3f craneLoc = truckCraneNode.getLocalTranslation();
    public Vector3f hookLoc = craneHook.getLocalTranslation();
    
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
        
        truckCraneNode.attachChild(craneLift);
        truckCraneNode.attachChild(craneBase);
        truckCraneNode.attachChild(craneHook);
        
        /*
         * Rotate crane
         */

        truckCraneNode.rotate(0, FastMath.PI / 2, 0);
    }

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
    
    public static boolean busy = false;
    public static boolean loaded = false;
    
    public static Float precision(int decimalPlace, Float d) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    public static int yolo = 0;
    public static int craneID = 0;
    
    public void update(float tpf){
        
        float craneHookPos = precision(2, craneHook.getLocalTranslation().y);
        float truckCranePos = precision(2, truckCraneNode.getLocalTranslation().z);
        
//        System.out.println("TruckCrane  "+ truckCranePos);
//        System.out.println("CraneHook  " + craneHookPos);
        
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
                    //Truck, crane, container
                    cranepos = 2;
//                    busy = false;
                }
                break;
            case 2:
                // MOVE HOOK DOWN
                if (truckCranePos == 24.0f && craneHookPos == 0.0f){
//                    busy = true;
                    moveHook(-0.6f);
                }
                else if (craneHookPos == -0.6f && busy !=false){
                    truckToCrane(Main.truck[yolo], Main.truckCrane[yolo], Main.container[yolo]);
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
                    craneToAgv(Main.agv[0], Main.truckCrane[yolo], Main.container[yolo]);
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
    /*
     * From truck to crane
     */
    
    public void truckToCrane(Truck truck, TruckCrane crane, Container container){
        truck.truck.detachChild(container.contNode);
        crane.craneHook.attachChild(container.contNode);
        container.contNode.setLocalTranslation(0, 0.8f, 0);
    }
    
    public void craneToAgv(AGV agv, TruckCrane truckCrane, Container container){
        truckCrane.craneHook.detachChild(container.contNode);
        agv.agv.attachChild(container.contNode);
        container.contNode.setLocalTranslation(0,0.35f,0);
    }
    
    public void agvToCrane(AGV agv, TruckCrane truckCrane, Container container){
        agv.agv.detachChild(container.contNode);
        truckCrane.craneHook.attachChild(container.contNode);
        container.contNode.setLocalTranslation(0,0.4f,0);
    }
    
    public void craneToTruck(Truck truck, TruckCrane truckCrane, Container container){
        truckCrane.craneHook.detachChild(container.contNode);
        truck.truck.attachChild(container.contNode);
        container.contNode.setLocalTranslation(0,0.4f,0);
    }
}