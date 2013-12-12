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

/**
 *
 * @author Enzo van Kessel
 */
public class Truck extends Node implements VehController  {
    private AssetManager assetManager;
    private MotionPath path;
    private MotionEvent motionControl;
    
    public Truck(AssetManager assetManager){
        this.assetManager = assetManager;
    }
    
    public void move(){
        
        this.setLocalTranslation(0, 3.14f, 0);
        
        path = new MotionPath();
        path.addWayPoint(new Vector3f(80f,0f,28f));
        path.addWayPoint(new Vector3f(76f,0f,28f));
        path.addWayPoint(new Vector3f(70f,0f,28f));
        path.addWayPoint(new Vector3f(65f,0f,28f));

        
        motionControl = new MotionEvent(this,path);
        path.setCurveTension(0f);
        motionControl.setDirectionType(MotionEvent.Direction.PathAndRotation);
        motionControl.setRotation(new Quaternion().fromAngleNormalAxis(-FastMath.HALF_PI,Vector3f.UNIT_Y));
        motionControl.setSpeed(0.2f);
        motionControl.play();
    }

    public boolean Checkloaded() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void CreateTruck(){
        Spatial Cart = assetManager.loadModel("Models/Truck/truckCart.j3o");
        Spatial Truck = assetManager.loadModel("Models/Truck/truckMachine.j3o");
        this.attachChild(Cart);
        this.attachChild(Truck);
        Cart.setLocalTranslation(0,0, 0);
        Truck.setLocalTranslation(0,0f,0);
        
        
    }
}
