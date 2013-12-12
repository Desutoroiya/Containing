package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.cinematic.MotionPath;
import com.jme3.cinematic.events.MotionEvent;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Johan
 */
public class TruckCrane extends Node {

    public AssetManager assetManager;
    private Node rootNode;
    private MotionPath mpBase;
    private MotionPath mpHook;
    private MotionEvent meTCrane;
    private MotionEvent meTCHook;
    private float X = 69.5f;
    private float Y = 0;
    private float Z = 24f;
    private Vector3f baseP1 = new Vector3f(X, Y, Z);
    private Vector3f baseP2 = new Vector3f(X, Y, Z - 2);
    private int location;
    private boolean moving = false;
    private float baseSpeed = 1.0f;

    public TruckCrane(AssetManager assetManager) {
        this.assetManager = assetManager;
        this.rootNode = rootNode;
    }

    public void createTruckCrane() {
        /*
         * Creates a new cranelift for trucks
         */
        Spatial TCraneLift = assetManager.loadModel("Models/Storagecrane/scraneLift.j3o");
        this.attachChild(TCraneLift);
        Spatial TCraneBase = assetManager.loadModel("Models/Storagecrane/scraneBase.j3o");
        
        for(int i = 0; i < 19; i++){
            this.setLocalTranslation(X, Y, Z);
            this.rotate(0, 1.5707f, 0);
            X -= 3;
        }
        this.attachChild(TCraneBase);
    }

    public void moveBase() {
        mpBase = new MotionPath();
        mpBase.addWayPoint(new Vector3f(baseP1));
        mpBase.addWayPoint(new Vector3f(baseP2));

        meTCrane = new MotionEvent(this, mpBase);
        mpBase.setCurveTension(0f);
        meTCrane.setSpeed(baseSpeed);
        meTCrane.play();
    }

    public void moveHook(boolean moving) {
        if (moving == false) {
            mpHook = new MotionPath();
            mpHook.addWayPoint(new Vector3f(baseP2.x, 5, baseP2.z));
            mpHook.addWayPoint(new Vector3f(baseP2.x, 0, baseP2.z));
        } else {
            //Movement in progress, pls wait
        }
    }
}
