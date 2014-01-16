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
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * class.StoreCrane
 * @author Ivar
 */
public class StoreCrane extends Node {
    /*
     * Declaring values used in StoreCrane
     */

    Spatial StoreCraneLift;
    Spatial StoreCraneBase;
    Spatial StoreCraneHook;
    
    private Node rootNode;
    
    Node storageCrane = new Node();
    Node storageCraneLift = new Node();
    Node storageCraneBase = new Node();
    Node storageCraneHook = new Node();
    
    /**
     * assetmanager
     */
    public AssetManager assetManager;
    
    private MotionPath storeBase;
    private MotionPath storeHook;
    private MotionPath storeLift;
    
    private MotionEvent meStoreCrane;
    private MotionEvent meStoreHook;
    private MotionEvent meStoreLift;
    
    private float baseSpeed = 1.0f;
    
    private ArrayList<Boolean> avgBuffer = new ArrayList<Boolean>();
    

    /**
     * StoreCrane
     * @param assetManager
     */
    public StoreCrane(AssetManager assetManager) {
        this.assetManager = assetManager;
        this.rootNode = rootNode;
    }
    
    /**
     * Create a storecrane
     */
    public void createStoreCrane() {
        StoreCraneLift = assetManager.loadModel("Models/Storagecrane/scraneLift.j3o");
        StoreCraneBase = assetManager.loadModel("Models/Storagecrane/scraneBase.j3o");
        StoreCraneHook = assetManager.loadModel("Models/Storagecrane/scraneHook.j3o");

        storageCraneLift.attachChild(StoreCraneLift);
        storageCraneBase.attachChild(StoreCraneBase);
        storageCraneHook.attachChild(StoreCraneHook);

        storageCrane.attachChild(storageCraneLift);
        storageCrane.attachChild(storageCraneBase);
        storageCrane.attachChild(storageCraneHook);

        storageCrane.rotate(0, FastMath.PI / 2, 0);
        avgBuffer.add(true);
        avgBuffer.add(false);
        avgBuffer.add(false);
        avgBuffer.add(false);
        System.out.println(avgBuffer);
        
    }
    
    
    /**
     * LocalTranslations for the nodes of the storageCrane
     */
    public Vector3f locationBase = storageCrane.getLocalTranslation();
    /**
     * LocalTranslations for the nodes of the storageCrane
     */
    public Vector3f locationLift = storageCraneLift.getLocalTranslation();  
    /**
     * LocalTranslations for the nodes of the storageCrane
     */
    public Vector3f locationHook = storageCraneHook.getLocalTranslation();
    
    /**
     * Moves the base on the z axis by value zmove
     * @param zmove
     */
    public void moveBase(float zmove) {
        storeBase = new MotionPath();
        storeBase.addWayPoint(locationBase);
        storeBase.addWayPoint(new Vector3f(locationBase.x, locationBase.y, locationBase.z + zmove));
        storeBase.setCycle(false);

        meStoreCrane = new MotionEvent(storageCrane, storeBase);
        storeBase.setCurveTension(0f);
        meStoreCrane.setSpeed(baseSpeed);
        meStoreCrane.play();
    }

    /**
     * Moves the hook on the y axis by value ymove
     * @param ymove
     */
    public void moveHook(float ymove) {
        storeHook = new MotionPath();
        storeHook.addWayPoint(new Vector3f(locationHook));
        storeHook.addWayPoint(new Vector3f(locationHook.x, locationHook.y + ymove, locationHook.z));
        storeHook.setCycle(false);

        meStoreHook = new MotionEvent(storageCraneHook, storeHook);
        storeHook.setCurveTension(0f);
        meStoreHook.setSpeed(baseSpeed);
        meStoreHook.play();
    }

    /**
     * Move the lift on the z axis by value xmove
     * @param zmove
     */
    public void moveLift(float zmove) {
        storeLift = new MotionPath();
        storeLift.addWayPoint(locationLift);
        storeLift.addWayPoint(new Vector3f(locationLift.x, locationLift.y, locationLift.z + zmove));

        meStoreLift = new MotionEvent(storageCraneLift, storeLift);
        storeLift.setCurveTension(0f);
        meStoreLift.setSpeed(baseSpeed);
        meStoreLift.play();

        storeHook = new MotionPath();
        storeHook.addWayPoint(locationLift);
        storeHook.addWayPoint(new Vector3f(locationLift.x , locationLift.y, locationLift.z + zmove));

        meStoreHook = new MotionEvent(storageCraneHook, storeHook);
        storeHook.setCurveTension(0f);
        meStoreHook.setSpeed(baseSpeed);
        meStoreHook.play();
    }

    private int cranepos = 1;
    private boolean busy = false;
        
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
     * Update function that moves the cranes in the right sequence
     * @param tpf
     */
    public void update(float tpf){
        
        float craneBasePos = precision(2, storageCrane.getLocalTranslation().z);
        float craneLiftPos = precision(2, storageCraneLift.getLocalTranslation().z);
        float craneHookPos = precision(2, storageCraneHook.getLocalTranslation().y);
        System.out.println("LiftPosition:   " + craneLiftPos);
        System.out.println("BasePosition:   " + craneBasePos);
        System.out.println("HookPosition:   " + craneHookPos);
        
        switch (cranepos){
            //Default state van storagecrane boven parkeerplaatsen
            case 0:
            //doe niks
                break;
                
            //Checken of er een agv, waar deze staat, move lift en hook.
            case 1:
                if (craneLiftPos == 0.0f)
                {
                    busy = true;
                    moveLift(-0.75f);
                    //moveHook(0.75f);
                }
                else if (craneLiftPos == -0.75f && busy != false)
                {
                    cranepos = 2;
                    busy = false;
                }
                
                break;
                
            //Hook omlaag
            case 2:
                if (craneHookPos == 0.0f)
                {
                    busy = true;
                    moveHook(-1.6f);
                }
                else if (craneHookPos == -1.6f && busy != false)
                {
                    cranepos = 3;
                    busy = false;
                }
                break;
              
            //hook omhoog
            case 3:
                if (craneHookPos == -1.6f)
                {
                    busy = true;
                    moveHook(+1.6f);
                }
                else if (craneHookPos == 0.0f && busy != false)
                {
                    cranepos = 4;
                    busy = false;
                }                
                break;
                
            //Base verplaatsen boven opslagpositie
            case 4:
                if (craneBasePos == 18.0f)
                {
                    busy = true;
                    moveBase(-2);
                }
                else if (craneBasePos == 16.0f && busy != false)
                {
                    cranepos = 5;
                    busy = false;
                }
                break;
                
            //Hook naar beneden
            case 5:
                if (craneHookPos == 0.0f)
                {
                    busy = true;
                    moveHook(-1.6f);
                }
                else if (craneHookPos == -1.6f && busy != false)
                {
                    cranepos = 6;
                    busy = false;
                }
                break;
                
            // hook omhoog en lift naar center position
            case 6:
                 if (craneHookPos == -1.6f)
                {
                    busy = true;
                    moveHook(+1.6f);
                }
                else if (craneHookPos == 0.0f && busy != false)
                {
                    cranepos = 7;
                    busy = false;
                }
                break;
            //Base verplaatsen naar standaar positie
            case 7:
                 if (craneBasePos == 16.0f && craneLiftPos == -0.75)
                {
                    busy = true;
                    moveBase(+2);
                    moveLift(+0.75f);
                }
                else if (craneBasePos == 18.0f && craneLiftPos == 0.0f && busy != false)
                {
                    cranepos = 1;
                    busy = false;
                }
                break;
        }
    }  
}
