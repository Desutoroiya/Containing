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
public class StoreCrane extends Node {

    private Node rootNode;
    public AssetManager assetManager;
    private MotionPath storeBase;
    private MotionEvent meStoreCrane;
    private Vector3f firstpoint = new Vector3f(0, 0, 0);
    private Vector3f secondpoint = new Vector3f(0, 0, 5);
    private int location;
    private boolean moving = false;
    private float baseSpeed = 1.0f;

    public StoreCrane(AssetManager assetManager) {
        this.assetManager = assetManager;
        this.rootNode = rootNode;
    }

    public void createStoreCrane() {
        Spatial StoreCraneLift = assetManager.loadModel("Models/Storagecrane/scraneLift.j3o");
        this.attachChild(StoreCraneLift);
        Spatial StoreCraneBase = assetManager.loadModel("Models/Storagecrane/scraneBase.j3o");
        this.attachChild(StoreCraneBase);
        Spatial StoreCraneHook = assetManager.loadModel("Models/Storagecrane/scraneHook.j3o");
        this.attachChild(StoreCraneHook);

        this.setLocalTranslation(0, 0, 0);
        this.rotate(0, 1.5707f, 0);

        StoreCraneLift.rotate(0, FastMath.PI / 2, 0);
        StoreCraneBase.rotate(0, FastMath.PI / 2, 0);
        StoreCraneHook.rotate(0, FastMath.PI / 2, 0);
    }

    public void moveBase() {

        storeBase = new MotionPath();
        storeBase.addWayPoint(new Vector3f(firstpoint));
        storeBase.addWayPoint(new Vector3f(secondpoint));

        meStoreCrane = new MotionEvent(this, storeBase);
        storeBase.setCurveTension(0f);
        meStoreCrane.setSpeed(baseSpeed);
        meStoreCrane.play();


    }
}
