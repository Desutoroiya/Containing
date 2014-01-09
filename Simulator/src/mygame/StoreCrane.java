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
public class StoreCrane extends Node {

    Spatial StoreCraneLift;
    Spatial StoreCraneBase;
    Spatial StoreCraneHook;
    private Node rootNode;
    Node storageCrane = new Node();
    Node storageCraneLift = new Node();
    Node storageCraneBase = new Node();
    Node storageCraneHook = new Node();
    public AssetManager assetManager;
    private MotionPath storeBase;
    private MotionPath storeHook;
    private MotionPath storeLift;
    private MotionEvent meStoreCrane;
    private MotionEvent meStoreHook;
    private MotionEvent meStoreLift;
    public float x = 0f;
    public float y = 0;
    public float z = 0f;
    Vector3f Position = new Vector3f(x, y, z);
    private float baseSpeed = 1.0f;

    public StoreCrane(AssetManager assetManager) {
        this.assetManager = assetManager;
        this.rootNode = rootNode;
    }

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

        storageCrane.rotate(0, 1.5707f, 0);
    }

    public void moveBase(float x, float y, float z) {
        storeBase = new MotionPath();
        storeBase.addWayPoint(new Vector3f(x, y, z));
        storeBase.addWayPoint(new Vector3f(x, y, z - 36));
        storeBase.setCycle(true);

        meStoreCrane = new MotionEvent(storageCrane, storeBase);
        storeBase.setCurveTension(0f);
        meStoreCrane.setSpeed(baseSpeed * 0.2f);
        meStoreCrane.play();
    }

    public void moveHook() {
        storeHook = new MotionPath();
        storeHook.addWayPoint(new Vector3f(Position));
        storeHook.addWayPoint(new Vector3f(Position.x, Position.y - 0.2f, Position.z));
        storeHook.setCycle(true);

        meStoreHook = new MotionEvent(StoreCraneHook, storeHook);
        storeHook.setCurveTension(0f);
        meStoreHook.setSpeed(baseSpeed);
        meStoreHook.play();
    }

    public void moveLift() {
        storeLift = new MotionPath();
        storeLift.addWayPoint(new Vector3f(Position));
        storeLift.addWayPoint(new Vector3f(Position.x, Position.y, Position.z - 0.75f));

        meStoreLift = new MotionEvent(StoreCraneLift, storeLift);
        storeLift.setCurveTension(0f);
        meStoreLift.setSpeed(baseSpeed);
        meStoreLift.play();

        storeHook = new MotionPath();
        storeHook.addWayPoint(new Vector3f(Position));
        storeHook.addWayPoint(new Vector3f(Position.x, Position.y, Position.z - 0.75f));

        meStoreHook = new MotionEvent(StoreCraneHook, storeHook);
        storeHook.setCurveTension(0f);
        meStoreHook.setSpeed(baseSpeed);
        meStoreHook.play();
    }
}
