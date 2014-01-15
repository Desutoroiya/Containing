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
import java.math.BigDecimal;

/**
 *
 * @author Ivar
 */
public class ShipCrane extends Node {

    Spatial ShipCraneLift;
    Spatial ShipCraneBase;
    Spatial ShipCraneHook;
    private Node rootNode;
    Node shipCrane = new Node();
    Node shipCraneLift = new Node();
    Node shipCraneBase = new Node();
    Node shipCraneHook = new Node();
    public AssetManager assetManager;
    private MotionPath mpshipBase;
    private MotionPath mpshipHook;
    private MotionPath mpshipLift;
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

    public void createShipCrane() {
        ShipCraneLift = assetManager.loadModel("Models/Shipcrane/craneLift.j3o");
        ShipCraneBase = assetManager.loadModel("Models/Shipcrane/craneBase.j3o");
        ShipCraneHook = assetManager.loadModel("Models/Shipcrane/craneHook.j3o");

        shipCraneLift.attachChild(ShipCraneLift);
        shipCraneBase.attachChild(ShipCraneBase);
        shipCraneHook.attachChild(ShipCraneHook);

        shipCrane.attachChild(shipCraneLift);
        shipCrane.attachChild(shipCraneBase);
        shipCrane.attachChild(shipCraneHook);


    }
    
    public Vector3f location = shipCrane.getLocalTranslation();
    public Vector3f position = shipCraneHook.getLocalTranslation();

    public void moveBase(float zmove) {

        mpshipBase = new MotionPath();
        mpshipBase.addWayPoint(new Vector3f(location));
        mpshipBase.addWayPoint(new Vector3f(location.x, location.y, location.z + zmove));
        mpshipBase.setCycle(false);

        meShipCrane = new MotionEvent(shipCrane, mpshipBase);
        mpshipBase.setCurveTension(0f);
        meShipCrane.setSpeed(baseSpeed*0.2f);
        meShipCrane.play();
    }

    public void moveHook(float ymove) {
        mpshipHook = new MotionPath();
        mpshipHook.addWayPoint(position);
        mpshipHook.addWayPoint(new Vector3f(position.x, position.y + ymove, position.z));
        mpshipHook.setCycle(false);

        meShipHook = new MotionEvent(shipCraneHook, mpshipHook);
        mpshipHook.setCurveTension(0f);
        meShipHook.setSpeed(baseSpeed* 0.2f);
        meShipHook.play();
    }

    public void moveLift(float xmove) {
        mpshipLift = new MotionPath();
        mpshipLift.addWayPoint(new Vector3f(position));
        mpshipLift.addWayPoint(new Vector3f(position.x + xmove, position.y, position.z));
        mpshipLift.setCycle(true);

        meShipLift = new MotionEvent(shipCraneLift, mpshipLift);
        mpshipLift.setCurveTension(0f);
        meShipLift.setSpeed(baseSpeed * 0.2f);
        meShipLift.play();


        mpshipHook = new MotionPath();
        mpshipHook.addWayPoint(new Vector3f(position));
        mpshipHook.addWayPoint(new Vector3f(position.x + xmove, position.y, position.z));
        mpshipHook.setCycle(true);


        meShipHook = new MotionEvent(shipCraneHook, mpshipHook);
        mpshipHook.setCurveTension(0f);
        meShipHook.setSpeed(baseSpeed * 0.2f);
        meShipHook.play();
    }
    public float Z;
    public float Y;
    
    private int cranepos = 1;
    private boolean busy = false;
    
    public static Float precision(int decimalPlace, Float d) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    
    public void update(float tpf){
        
        float shipCraneF = shipCrane.getLocalTranslation().z;
        float shipCranePos = precision(2,shipCraneF);
        
        float shipcraneHookF = shipCraneHook.getLocalTranslation().y;
        float shipcraneHookPos = precision(2, shipcraneHookF);
        
        //System.out.println("ShipCrane  "+ shipCranePos);
        //System.out.println("ShipCraneHook  " + shipcraneHookPos);
        
        switch (cranepos){
            case 0:
            //doe niks
                break;
                
            case 1:
                // MOVE NAAR TRUCK
                if (shipCranePos == -24.0f){
                    busy = true;
                    moveBase(3);
                }
                else if (shipCranePos == -21.0f && busy != false){
                    cranepos = 2;
                    busy = false;
                }
                break;
            case 2:
                // MOVE HOOK DOWN
                if (shipCranePos == -21.0f && shipcraneHookPos == 0.0f){
                    busy = true;
                    moveHook(-4f);
                }
                else if (shipcraneHookPos == -4f && busy !=false){
                    cranepos = 3;
                    busy = false;
                }
                break;
            case 3:
                // MOVE HOOK UP
                if (shipCranePos == -21.0f && shipcraneHookPos == -4f){
                    busy = true;
                    moveHook(4f);
                }
                else if (shipcraneHookPos == 0.0f && busy !=false){
                    cranepos = 4;
                    busy = false;
                }
                break;
            case 4:
                // RIJD KRAAN
                if (shipCranePos == -21.0f && shipcraneHookPos == 0.0f){
                    busy = true;
                    moveBase(-3);
                }
                else if (shipCranePos == -24.0f && busy != false){
                    cranepos = 5;
                    busy = false;
                }
                break;
            case 5:
                // MOVE HOOK DOWN
                if (shipCranePos == -24.0f && shipcraneHookPos == 0.0f){
                    busy = true;
                    moveHook(-4f);
                }
                else if (shipcraneHookPos == -4f && busy !=false){
                    cranepos = 6;
                    busy = false;
                }
                break;
            case 6:
                // MOVE HOOK UP
                if (shipCranePos == -24.0f && shipcraneHookPos == -4f){
                    busy = true;
                    moveHook(4f);
                }
                else if (shipcraneHookPos == 0.0f && busy !=false){
                    cranepos = 0;
                    busy = false;
                }
                break;
        }
    }
}
