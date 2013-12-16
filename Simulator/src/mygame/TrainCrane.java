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
        this.attachChild(TrainCraneLift);
        Spatial TrainCraneBase = assetManager.loadModel("Models/Traincrane/trainCraneBase.j3o");
        this.attachChild(TrainCraneBase);
        Spatial TrainCraneHook = assetManager.loadModel("Models/Traincrane/trainCraneHook.j3o");
        this.attachChild(TrainCraneHook);

        //this.setLocalTranslation(-63, 0.1f, -28);
        this.rotate(0, 1.5707f, 0);

        TrainCraneLift.rotate(0, FastMath.PI / 2, 0);
        TrainCraneBase.rotate(0, FastMath.PI / 2, 0);
        TrainCraneHook.rotate(0, FastMath.PI / 2, 0);
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
