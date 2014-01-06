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
public class TrainCrane extends Node {

    TrainWagon[] trainWagon;
    private Node rootNode;
    Node trainCrane = new Node();
    public AssetManager assetManager;
    private MotionPath trainBase;
    private MotionPath trainHook;
    private MotionPath trainLift;
    private MotionEvent meTrainCrane;
    private MotionEvent meTrainHook;
    private MotionEvent meTrainLift;
    public float x = 0f;
    public float y = 0;
    public float z = 0f;
    Vector3f Position = new Vector3f(x, y, z);    
    private float baseSpeed = 1.0f;

    public TrainCrane(AssetManager assetManager,TrainWagon[] trainWagon) {
        this.assetManager = assetManager;
        this.rootNode = rootNode;
        this.trainWagon = trainWagon;
        
    }

    public void createTrainCrane() {
        Spatial TrainCraneLift = assetManager.loadModel("Models/Traincrane/trainCraneLift.j3o");
        Spatial TrainCraneBase = assetManager.loadModel("Models/Traincrane/trainCraneBase.j3o");
        Spatial TrainCraneHook = assetManager.loadModel("Models/Traincrane/trainCraneHook.j3o");
        
        trainCrane.attachChild(TrainCraneLift);
        trainCrane.attachChild(TrainCraneBase);
        trainCrane.attachChild(TrainCraneHook);
    }
  
    public void moveBase(float x) {
        
        
        trainBase = new MotionPath();
        
        trainBase.addWayPoint(new Vector3f(trainCrane.getLocalTranslation()));
        trainBase.addWayPoint(new Vector3f(x , trainCrane.getLocalTranslation().y, trainCrane.getLocalTranslation().z));
        trainBase.setCycle(true);
        
        meTrainCrane = new MotionEvent(trainCrane, trainBase);
        trainBase.setCurveTension(0f);
        meTrainCrane.setSpeed(baseSpeed);
        meTrainCrane.play();
        
    }

    public void moveHook() {
        Spatial detrainHook = trainCrane.getChild(2);
        trainHook = new MotionPath();
        trainHook.addWayPoint(new Vector3f(Position));
        trainHook.addWayPoint(new Vector3f(Position.x, Position.y - 0.5f, Position.z));

        meTrainHook = new MotionEvent(detrainHook, trainHook);
        trainHook.setCurveTension(0f);
        meTrainHook.setSpeed(baseSpeed);
        meTrainHook.play();
    }

    public void moveLift() {
        Spatial detrainLift = trainCrane.getChild(0);
        trainLift = new MotionPath();
        trainLift.addWayPoint(new Vector3f(Position));
        trainLift.addWayPoint(new Vector3f(Position.x, Position.y, Position.z + 2f));
        trainLift.addWayPoint(new Vector3f(Position.x, Position.y, Position.z - 2f));
        trainLift.addWayPoint(new Vector3f(Position));

        meTrainLift = new MotionEvent(detrainLift, trainLift);
        trainLift.setCurveTension(0f);
        meTrainLift.setSpeed(baseSpeed);
        meTrainLift.play();

        Spatial detrainHook = trainCrane.getChild(2);
        trainHook = new MotionPath();
        trainHook.addWayPoint(new Vector3f(Position));
        trainHook.addWayPoint(new Vector3f(Position.x, Position.y, Position.z + 2f));
        trainHook.addWayPoint(new Vector3f(Position.x, Position.y, Position.z - 2f));
        trainHook.addWayPoint(new Vector3f(Position));

        meTrainHook = new MotionEvent(detrainHook, trainHook);
        trainHook.setCurveTension(0f);
        meTrainHook.setSpeed(baseSpeed);
        meTrainHook.play();
    }
    public void getContainer(int i){
        moveBase(trainWagon[i].trainwagon.getLocalTranslation().x);
        if(this.getLocalTranslation().x==trainWagon[i].trainwagon.getLocalTranslation().x){
            moveLift();
            moveHook();
        }
    }
}
