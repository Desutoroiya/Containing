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
        Spatial ShipCraneLift = assetManager.loadModel("Models/Shipcrane/craneLift.j3o");
        Spatial ShipCraneBase = assetManager.loadModel("Models/Shipcrane/craneBase.j3o");
        Spatial ShipCraneHook = assetManager.loadModel("Models/Shipcrane/craneHook.j3o");

        shipCraneLift.attachChild(ShipCraneLift);
        shipCraneBase.attachChild(ShipCraneBase);
        shipCraneHook.attachChild(ShipCraneHook);

        shipCrane.attachChild(shipCraneLift);
        shipCrane.attachChild(shipCraneBase);
        shipCrane.attachChild(shipCraneHook);


    }

    public void moveBase(float x, float y, float z) {

        mpshipBase = new MotionPath();
        mpshipBase.addWayPoint(new Vector3f(x, y, z));
        mpshipBase.addWayPoint(new Vector3f(x, y, z + 3));
        mpshipBase.setCycle(true);

        meShipCrane = new MotionEvent(shipCrane, mpshipBase);
        mpshipBase.setCurveTension(0f);
        meShipCrane.setSpeed(baseSpeed * 0.005f);
        meShipCrane.play();
    }

    public void moveHook() {
        mpshipHook = new MotionPath();
        mpshipHook.addWayPoint(new Vector3f(Position));
        mpshipHook.addWayPoint(new Vector3f(Position.x, Position.y - 0.5f, Position.z));
        mpshipHook.setCycle(true);

        meShipHook = new MotionEvent(shipCraneHook, mpshipHook);
        mpshipHook.setCurveTension(0f);
        meShipHook.setSpeed(baseSpeed * 0.01f);
        meShipHook.play();
    }

    public void moveLift() {
        mpshipLift = new MotionPath();
        mpshipLift.addWayPoint(new Vector3f(Position));
        mpshipLift.addWayPoint(new Vector3f(Position.x + 6f, Position.y, Position.z));
        mpshipLift.setCycle(true);

        meShipLift = new MotionEvent(shipCraneLift, mpshipLift);
        mpshipLift.setCurveTension(0f);
        meShipLift.setSpeed(baseSpeed * 0.01f);
        meShipLift.play();


        mpshipHook = new MotionPath();
        mpshipHook.addWayPoint(new Vector3f(Position));
        mpshipHook.addWayPoint(new Vector3f(Position.x + 6f, Position.y, Position.z));
        mpshipHook.setCycle(true);


        meShipHook = new MotionEvent(shipCraneHook, mpshipHook);
        mpshipHook.setCurveTension(0f);
        meShipHook.setSpeed(baseSpeed * 0.01f);
        meShipHook.play();
    }
}
