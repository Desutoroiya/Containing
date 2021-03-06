/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.cinematic.MotionPath;
import com.jme3.cinematic.events.MotionEvent;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.ArrayList;
import java.util.List;

/**
 * class.Truck
 * @author Enzo van Kessel
 */
public class Truck extends Node  {

    /*
     * Declaring values that are used in Truck
     */
    
    AssetManager assetManager;
    MotionPath path;
    MotionEvent motionControl;
    Node truck = new Node();

    /**
     * Truck
     * @param assetManager
     */
    public Truck(AssetManager assetManager) {
        this.assetManager = assetManager;
    }
    
    /**
     * Move truck to plaats
     * @param plaats
     */
    public void move(String plaats) {
        
        int Parking = Integer.parseInt(plaats);

        float distanceX = 75f - (Parking * 3);
        float distanceY = 0f;
        float distanceZ = 28f;

        path = new MotionPath();
        path.addWayPoint(new Vector3f(80f, 0f, 28f));
        path.addWayPoint(new Vector3f(distanceX, distanceY, distanceZ));
        distanceZ -= 4;
        path.addWayPoint(new Vector3f(distanceX, distanceY, distanceZ));


        motionControl = new MotionEvent(this, path);
        path.setCurveTension(0f);
        motionControl.setDirectionType(MotionEvent.Direction.PathAndRotation);
        motionControl.setRotation(new Quaternion().fromAngleNormalAxis(-FastMath.HALF_PI, Vector3f.UNIT_Y));
        motionControl.setSpeed(0.5f);
        motionControl.play();
    }

    /**
     * check if truck is loaded
     * @return
     */
    public boolean Checkloaded() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Create a new truck
     */
    public void createTruck() {
        Spatial Cart = assetManager.loadModel("Models/Truck/truckCart.j3o");
        Spatial Truck = assetManager.loadModel("Models/Truck/truckMachine.j3o");
        truck.attachChild(Cart);
        truck.attachChild(Truck);
        
        truck.setLocalTranslation(0, 0, 0);
        truck.rotate(0,FastMath.HALF_PI,0);
    }
}
