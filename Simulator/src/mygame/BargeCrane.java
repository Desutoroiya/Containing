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
 * class.BargeCrane
 * @author Ivar
 */
public class BargeCrane extends Node {

    Spatial BargeCraneLift;
    Spatial BargeCraneBase;
    Spatial BargeCraneHook;
    private Node rootNode;
    Node bargeCrane = new Node();
    Node bargeCraneLift = new Node();
    Node bargeCraneBase = new Node();
    Node bargeCraneHook = new Node();
    /**
     * assetmanager
     */
    public AssetManager assetManager;
    private MotionPath bargeBase;
    private MotionPath bargeHook;
    private MotionPath bargeLift;
    private MotionEvent meBargeCrane;
    private MotionEvent meBargeHook;
    private MotionEvent meBargeLift;
    /**
     * variable x for vector3f position
     */
    public float x = 0f;
    /**
     * variable y for vector3f position
     */
    public float y = 0;
    /**
     * variable z for vector3f position
     */
    public float z = 0f;
    Vector3f Position = new Vector3f(x, y, z);
    private float baseSpeed = 1.0f;

    /**
     * Bargecrane
     * @param assetManager
     */
    public BargeCrane(AssetManager assetManager) {
        this.assetManager = assetManager;
        this.rootNode = rootNode;
    }

    /**
     * creates/loads a bargecrane
     */
    public void createBargeCrane() {
        BargeCraneLift = assetManager.loadModel("Models/Bargecrane/bargeCraneLift.j3o");
        BargeCraneBase = assetManager.loadModel("Models/Bargecrane/bargeCraneBase.j3o");
        BargeCraneHook = assetManager.loadModel("Models/Bargecrane/bargeCraneHook.j3o");

        bargeCraneLift.attachChild(BargeCraneLift);
        bargeCraneBase.attachChild(BargeCraneBase);
        bargeCraneHook.attachChild(BargeCraneHook);

        bargeCrane.attachChild(bargeCraneLift);
        bargeCrane.attachChild(bargeCraneBase);
        bargeCrane.attachChild(bargeCraneHook);

        bargeCrane.rotate(0, 1.5707f, 0);
    }
    /**
     * gets location of the bargecrane
     */
    public Vector3f locationBase = bargeCrane.getLocalTranslation();
    /**
     * gets location of the hook
     */
    public Vector3f positionHook = bargeCraneHook.getLocalTranslation();
    /**
     * gets location of the lift
     */
    public Vector3f positionLift = bargeCraneLift.getLocalTranslation();

    /*
     * Move the base of a bargecrane to a given location
     */
    /**
     * Move the base of the bargecrane on the x axis by value xmove
     * @param xmove 
     */
    public void moveBase(float xmove) {

        bargeBase = new MotionPath();
        bargeBase.addWayPoint(new Vector3f(locationBase));
        bargeBase.addWayPoint(new Vector3f(locationBase.x + xmove, locationBase.y, locationBase.z));

        meBargeCrane = new MotionEvent(bargeCrane, bargeBase);
        bargeBase.setCurveTension(0f);
        meBargeCrane.setSpeed(baseSpeed * 0.2f);
        meBargeCrane.play();
    }

    /**
     * moves the hook of the bargecrane on the y axis by value ymove
     * @param ymove
     */
    public void moveHook(float ymove) {
        bargeHook = new MotionPath();

        bargeHook.addWayPoint(new Vector3f(positionHook));
        bargeHook.addWayPoint(new Vector3f(positionHook.x, positionHook.y + ymove, positionHook.z));
        bargeHook.setCycle(false);

        meBargeHook = new MotionEvent(bargeCraneHook, bargeHook);
        bargeHook.setCurveTension(0f);
        meBargeHook.setSpeed(baseSpeed * 0.2f);
        meBargeHook.play();
    }
    
    /**
     * moves the lift and hook on the x axis by value xmove
     * @param xmove
     */
    public void moveLift(float xmove) {
        bargeLift = new MotionPath();
        bargeLift.addWayPoint(new Vector3f(positionLift));
        bargeLift.addWayPoint(new Vector3f(positionLift.x + xmove, positionLift.y, positionLift.z));
        bargeLift.setCycle(false);

        meBargeLift = new MotionEvent(bargeCraneLift, bargeLift);
        bargeLift.setCurveTension(0f);
        meBargeLift.setSpeed(baseSpeed * 0.2f);
        meBargeLift.play();

        bargeHook = new MotionPath();
        bargeHook.addWayPoint(new Vector3f(positionHook));
        bargeHook.addWayPoint(new Vector3f(positionHook.x + xmove, positionHook.y, positionHook.z));
        bargeHook.setCycle(false);

        meBargeHook = new MotionEvent(bargeCraneHook, bargeHook);
        bargeHook.setCurveTension(0f);
        meBargeHook.setSpeed(baseSpeed * 0.2f);
        meBargeHook.play();
    }
    
    private int cranepos = 1;
    private boolean busy = false;

    /**
     * method which rounds floats to two decimals
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
     * updates position of each element of the crane
     * @param tpf
     */
    public void update(float tpf) {
        float bargeCranePos = precision(2, bargeCrane.getLocalTranslation().x);
        float bargecraneHookPos = precision(2, bargeCraneHook.getLocalTranslation().y);
        float bargecraneLiftpos = precision(2, bargeCraneLift.getLocalTranslation().x);


        System.out.println("BARGECranepos  " + bargeCranePos);
        System.out.println("BARGEliftpos  " + bargecraneLiftpos);
        System.out.println("BARGEHookpos  " + bargecraneHookPos);

        switch (cranepos) {
            case 0:
                //doe niks
                break;

            case 1:
                // MOVE BASE
                if (bargeCranePos == -64.0f) {
                    busy = true;
                    moveBase(4);
                } else if (bargeCranePos == -60.0f && busy != false) {

                    cranepos = 2;
                    busy = false;
                }
                break;
            case 2:
                // MOVE HOOK DOWN
                if (bargeCranePos == -60.0f && bargecraneHookPos == 0.0f && bargecraneLiftpos == 0.0f) {
                    busy = true;
                    moveHook(-2f);
                } else if (bargecraneHookPos == -2f && busy != false) {

                    cranepos = 3;
                    busy = false;
                }
                break;
            case 3:
                // MOVE HOOK UP
                if (bargeCranePos == -60.0f && bargecraneHookPos == -2f) {
                    busy = true;
                    moveHook(2f);
                } else if (bargecraneHookPos == 0.0f && busy != false) {
                    cranepos = 4;
                    busy = false;
                }
                break;
            case 4:
                // MOVE LIFT TO AGF
                if (bargeCranePos == -60.0f && bargecraneLiftpos == 0.0f) {
                    busy = true;
                    moveLift(6);
                } else if (bargecraneLiftpos == 6.0f) {
                    cranepos = 5;
                    busy = false;
                }
                break;
            case 5:
                // MOVE HOOK DOWN
                if (bargeCranePos == -60.0f && bargecraneHookPos == 0.0f) {
                    busy = true;
                    moveHook(-1.5f);
                } else if (bargecraneHookPos == -1.5f && busy != false) {
                    cranepos = 6;
                    busy = false;
                }
                break;
            case 6:
                // MOVE HOOK UP
                if (bargeCranePos == -60.0f && bargecraneHookPos == -1.5f) {
                    busy = true;
                    moveHook(1.5f);
                } else if (bargecraneHookPos == 0.0f && busy != false) {
                    cranepos = 7;
                    busy = false;
                }
                break;
            case 7:
                // MOVE LIFT TO BARGE
                if (bargeCranePos == -60.0f && bargecraneHookPos == 0.0f && bargecraneLiftpos == 6.0f) {
                    busy = true;
                    moveLift(-6f);
                } else if (bargecraneLiftpos == 0.0f && busy != false) {
                    cranepos = 8;
                    busy = false;
                }
                break;
            case 8:
                // RIJD KRAAN
                if (bargeCranePos == -60.0f && bargecraneHookPos == 0.0f) {
                    busy = true;
                    moveBase(-4);
                } else if (bargeCranePos == -64.0f && busy != false) {
                    cranepos = 0;
                    busy = false;
                }
                break;

        }
    }
}
