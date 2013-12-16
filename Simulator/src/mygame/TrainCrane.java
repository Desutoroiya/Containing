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

/**
 *
 * @author Ivar
 */
public class TrainCrane extends Node {

    private Node rootNode;
    Node trainCrane = new Node();
    public AssetManager assetManager;
    private MotionPath trainBase;
    private MotionEvent meTrainCrane;
    private Vector3f firstpoint = new Vector3f(0, 0, 0);
    private Vector3f secondpoint = new Vector3f(0, 5, 0);
    private int location;
    private boolean moving = false;
    private float baseSpeed = 1.0f;

    public TrainCrane(AssetManager assetManager) {
        this.assetManager = assetManager;
        this.rootNode = rootNode;
    }

    public void createTrainCrane() {
        Spatial TrainCraneLift = assetManager.loadModel("Models/Traincrane/trainCraneLift.j3o");
        Spatial TrainCraneBase = assetManager.loadModel("Models/Traincrane/trainCraneBase.j3o");
        Spatial TrainCraneHook = assetManager.loadModel("Models/Traincrane/trainCraneHook.j3o");
        
        trainCrane.attachChild(TrainCraneLift);
        trainCrane.attachChild(TrainCraneBase);
        trainCrane.attachChild(TrainCraneHook);
    }

    public void moveBase() {

        trainBase = new MotionPath();
        trainBase.addWayPoint(new Vector3f(firstpoint));
        trainBase.addWayPoint(new Vector3f(secondpoint));

        meTrainCrane = new MotionEvent(this, trainBase);
        trainBase.setCurveTension(0f);
        meTrainCrane.setSpeed(baseSpeed);
        meTrainCrane.play();


    }
}
