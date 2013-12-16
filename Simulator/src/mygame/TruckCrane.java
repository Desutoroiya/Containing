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
 * @author Johan
 */
public class TruckCrane extends Node {

    public AssetManager assetManager;
    Node craneLift = new Node();
    private MotionPath mpBase;
    private MotionPath mpHook;
    private MotionPath mpLift;
    private MotionEvent meTCrane;
    private MotionEvent meTCHook;
    private MotionEvent meTCLift;
    public float X = 0f;
    public float Y = 0;
    public float Z = 0f;
    Vector3f Position = new Vector3f(X, Y, Z);
    private float baseSpeed = 1.0f;

    public TruckCrane(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public void createTruckCrane() {
        /*
         * Creates a new cranelift for trucks
         */
        Spatial TCraneLift = assetManager.loadModel("Models/Storagecrane/scraneLift.j3o");
        Spatial TCraneBase = assetManager.loadModel("Models/Storagecrane/scraneBase.j3o");
        Spatial TCraneHook = assetManager.loadModel("Models/Storagecrane/scraneHook.j3o");

        TCraneBase.setLocalTranslation(Position);
        TCraneLift.setLocalTranslation(new Vector3f(Position.x, Position.y - 0.25f, Position.z));
        TCraneHook.setLocalTranslation(new Vector3f(Position.x, Position.y - 0.27f, Position.z));

        craneLift.attachChild(TCraneLift);
        craneLift.attachChild(TCraneBase);
        craneLift.attachChild(TCraneHook);

        craneLift.rotate(0, FastMath.PI / 2, 0);
    }

    public void moveBase(float X, float Y, float Z) {

        mpBase = new MotionPath();
        mpBase.addWayPoint(new Vector3f(X, Y, Z));
        mpBase.addWayPoint(new Vector3f(X, Y, Z + 2));

        meTCrane = new MotionEvent(craneLift, mpBase);
        mpBase.setCurveTension(0f);
        meTCrane.setSpeed(baseSpeed);
        meTCrane.play();

    }

    public void moveHook() {
        Spatial deHook = craneLift.getChild(2);
        mpHook = new MotionPath();
        mpHook.addWayPoint(new Vector3f(Position));
        mpHook.addWayPoint(new Vector3f(Position.x, Position.y - 0.5f, Position.z));

        meTCHook = new MotionEvent(deHook, mpHook);
        mpHook.setCurveTension(0f);
        meTCHook.setSpeed(baseSpeed);
        meTCHook.play();
    }

    public void moveLift() {
        Spatial deLift = craneLift.getChild(0);
        mpLift = new MotionPath();
        mpLift.addWayPoint(new Vector3f(Position));
        mpLift.addWayPoint(new Vector3f(Position.x, Position.y, Position.z + 0.75f));
        mpLift.addWayPoint(new Vector3f(Position.x, Position.y, Position.z - 0.75f));
        mpLift.addWayPoint(new Vector3f(Position));

        meTCLift = new MotionEvent(deLift, mpLift);
        mpLift.setCurveTension(0f);
        meTCLift.setSpeed(baseSpeed);
        meTCLift.play();

        Spatial deHook = craneLift.getChild(2);
        mpHook = new MotionPath();
        mpHook.addWayPoint(new Vector3f(Position));
        mpHook.addWayPoint(new Vector3f(Position.x, Position.y, Position.z + 0.75f));
        mpHook.addWayPoint(new Vector3f(Position.x, Position.y, Position.z - 0.75f));
        mpHook.addWayPoint(new Vector3f(Position));

        meTCHook = new MotionEvent(deHook, mpHook);
        mpHook.setCurveTension(0f);
        meTCHook.setSpeed(baseSpeed);
        meTCHook.play();
    }
}
