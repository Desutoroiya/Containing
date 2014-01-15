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
public class TrainCrane extends Node {

    TrainWagon[] trainWagon;
    
    Spatial TrainCraneLift;
    Spatial TrainCraneBase;
    Spatial TrainCraneHook;
    
    private Node rootNode;
    Node trainCrane = new Node();
    Node traincraneLift = new Node();
    Node traincraneBase = new Node();
    Node traincraneHook = new Node();
    
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
    
    //Vector3f Position = new Vector3f(x, y, z);    
    private float baseSpeed = 1.0f;

    public TrainCrane(AssetManager assetManager, TrainWagon[] trainWagon) {
        this.assetManager = assetManager; 
        this.trainWagon = trainWagon;
        this.rootNode = rootNode;
    }
    
    public void createTrainCrane() {
        TrainCraneLift = assetManager.loadModel("Models/Traincrane/trainCraneLift.j3o");
        TrainCraneBase = assetManager.loadModel("Models/Traincrane/trainCraneBase.j3o");
        TrainCraneHook = assetManager.loadModel("Models/Traincrane/trainCraneHook.j3o");
        
        traincraneLift.attachChild(TrainCraneLift);
        traincraneBase.attachChild(TrainCraneBase);
        traincraneHook.attachChild(TrainCraneHook);
        
        trainCrane.attachChild(traincraneLift);
        trainCrane.attachChild(traincraneBase);
        trainCrane.attachChild(traincraneHook);

    }
    public Vector3f locationBase = trainCrane.getLocalTranslation();
    public Vector3f positionHook = traincraneHook.getLocalTranslation();
    public Vector3f positionLift = traincraneLift.getLocalTranslation();
  
    public void moveBase(float xmove) {
        trainBase = new MotionPath();
        
        trainBase.addWayPoint(locationBase);
        trainBase.addWayPoint(new Vector3f(locationBase.x + xmove, locationBase.y, locationBase.z ));
        trainBase.setCycle(false);
        
        meTrainCrane = new MotionEvent(trainCrane, trainBase);
        trainBase.setCurveTension(0f);
        meTrainCrane.setSpeed(baseSpeed*0.2f);
        meTrainCrane.play();
    }

    public void moveHook(float ymove) {
        trainHook = new MotionPath();
        trainHook.addWayPoint(new Vector3f(positionHook));
        trainHook.addWayPoint(new Vector3f(positionHook.x, positionHook.y + ymove, positionHook.z));

        meTrainHook = new MotionEvent(traincraneHook, trainHook);
        trainHook.setCurveTension(0f);
        meTrainHook.setSpeed(baseSpeed*0.2f);
        meTrainHook.play();
    }

    public void moveLift(float zmove) {
        trainLift = new MotionPath();
        trainLift.addWayPoint(new Vector3f(positionLift));
        trainLift.addWayPoint(new Vector3f(positionLift.x, positionLift.y, positionLift.z + zmove));

        meTrainLift = new MotionEvent(traincraneLift, trainLift);
        trainLift.setCurveTension(0f);
        meTrainLift.setSpeed(baseSpeed*0.2f);
        meTrainLift.play();

        trainHook = new MotionPath();
        trainHook.addWayPoint(new Vector3f(positionLift));
        trainHook.addWayPoint(new Vector3f(positionLift.x, positionLift.y, positionLift.z + zmove));

        meTrainHook = new MotionEvent(traincraneHook, trainHook);
        trainHook.setCurveTension(0f);
        meTrainHook.setSpeed(baseSpeed*0.2f);
        meTrainHook.play();
    }
    
    private int cranepos = 1;
    private boolean busy = false;
    
    public static Float precision(int decimalPlace, Float d) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    
    public void update(float tpf){
        
        float trainCraneF = trainCrane.getLocalTranslation().x;
        float trainCranePos = precision(2,trainCraneF);
        
        float traincraneHookF = traincraneHook.getLocalTranslation().y;
        float traincraneHookPos = precision(2, traincraneHookF);
        
        float traincraneLiftF = traincraneLift.getLocalTranslation().z;
        float traincraneLiftpos = precision(2, traincraneLiftF);
        
        //System.out.println("TrainCrane  " + trainCranePos);
        //System.out.println("TrainCraneHook  " + traincraneHookPos);
        //System.out.println("TrainCraneLift  " + traincraneLiftpos);
        
        switch (cranepos){
            case 0:
            //doe niks
                break;
                
            case 1:
                // MOVE NAAR TRAINWAGON
                if (trainCranePos == -63.0f){
                    busy = true;
                    moveBase(9);
                }
                else if (trainCranePos == -54.0f && busy != false){
                    //Train, crane, container
                    //trainToCrane(train[1], trainList[1], container[2]);
                    cranepos = 2;
                    busy = false;
                }
                break;
            case 2:
                // MOVE LIFT TO TRAIN
                if (trainCranePos == -54.0f && traincraneLiftpos == 0.0f){
                    busy = true;
                    moveLift(-1);
                }
                else if(traincraneLiftpos == -1.0f){
                    cranepos = 3;
                    busy = false;
                }
                break;
            case 3:
                // MOVE HOOK DOWN
                if (trainCranePos == -54.0f && traincraneHookPos == 0.0f && traincraneLiftpos == -1.0f){
                    busy = true;
                    moveHook(-0.8f);
                }
                else if (traincraneHookPos == -0.8f && busy !=false){
                    
                    cranepos = 4;
                    busy = false;
                }
                break;                  
            case 4:
                // MOVE HOOK UP
                if (trainCranePos == -54.0f && traincraneHookPos == -0.8f && traincraneLiftpos == -1.0f){
                    busy = true;
                    moveHook(0.8f);
                }
                else if (traincraneHookPos == 0.0f && busy !=false){
                    cranepos = 5;
                    busy = false;
                }
                break;
            case 5:
                // MOVE LIFT TO AGV
                if (trainCranePos == -54.0f && traincraneHookPos == 0.0f && traincraneLiftpos == -1.0f){
                    busy = true;
                    moveLift(2.5f);                   
                }
                else if (traincraneLiftpos == 1.5f && busy !=false){
                    cranepos = 6;
                    busy = false;
                }
                break;
            case 6:
                // RIJD KRAAN
                if (trainCranePos == -54.0f && traincraneHookPos == 0.0f){
                    busy = true;
                    moveBase(-9);
                }
                else if (trainCranePos == -63.0f && busy != false){
                    cranepos = 7;
                    busy = false;
                }
                break;
            case 7:
                // MOVE HOOK DOWN
                if (trainCranePos == -63.0f && traincraneHookPos == 0.0f){
                    busy = true;
                    moveHook(-0.8f);
                }
                else if (traincraneHookPos == -0.8f && busy !=false){
                    cranepos = 8;
                    busy = false;
                }
                break;
            case 8:
                // MOVE HOOK UP
                if (trainCranePos == -63.0f && traincraneHookPos == -0.8f){
                    busy = true;
                    moveHook(0.8f);
                }
                else if (traincraneHookPos == 0.0f && busy !=false){
                    cranepos = 9;
                    busy = false;
                }
                break;
            case 9:
                // MOVE TO START POSITION
                if (trainCranePos == -63.0f && traincraneHookPos == 0.0f && traincraneLiftpos == 1.5f){
                    busy = true;
                    moveLift(-1.5f);
                }
                else if (traincraneLiftpos == 0.0f && busy != false){
                    cranepos = 0;
                    busy = false;
                }
                break;
        }
    }
//        public void trainToCrane(Train train, TrainCrane trainCrane, Container container){
//        //train.detachChild(container.contNode);
//        trainCrane.attachChild(container.contNode);
//    }
//        public void craneToTrain(Train train, TrainCrane trainCrane, Container container){
//        trainCrane.detachChild(container.contNode);
//        train.attachChild(container.contNode);
//    }
    
//    
//    public void getContainer(int i){
//        moveBase(trainWagon[i].trainwagon.getLocalTranslation().x);
//        if(this.getLocalTranslation().x ==trainWagon[i].trainwagon.getLocalTranslation().x){
//            moveLift();
//            moveHook();
//        }
//    }
}
