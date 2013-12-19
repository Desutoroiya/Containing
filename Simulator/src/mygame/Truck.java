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
 *
 * @author Enzo van Kessel
 */
public class Truck extends Node implements VehController {

    AssetManager assetManager;
    MotionPath path;
    MotionEvent motionControl;
    Node truck = new Node();

    public Truck(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public void move() {

        float distanceX = 72f;
        float distanceY = 0f;
        float distanceZ = 28f;
        
        boolean looking = true;
        
        List <Vector3f> Points = new ArrayList <Vector3f>();

        path = new MotionPath();
        path.addWayPoint(new Vector3f(80f, 0f, 28f));


        if (looking) {
            for (int i = 0; i < 20; i++) {

                path.addWayPoint(new Vector3f(distanceX, distanceY, distanceZ));
                    
                        distanceX -= 3;

                        path.addWayPoint(new Vector3f(distanceX, distanceY, distanceZ));
                    
                        distanceZ -= 4;
                    
                        path.addWayPoint(new Vector3f(distanceX, distanceY, distanceZ));
                    
                        distanceZ += 4;
                        


                    }
        }else {

                        looking = false;
                        path.addWayPoint(new Vector3f(distanceX, 0f, 24f));

        }

        motionControl = new MotionEvent(this, path);
        path.setCurveTension(0f);
        motionControl.setDirectionType(MotionEvent.Direction.PathAndRotation);
        motionControl.setRotation(new Quaternion().fromAngleNormalAxis(-FastMath.HALF_PI, Vector3f.UNIT_Y));
        motionControl.setSpeed(0.5f);
        motionControl.play();
    }

    public boolean Checkloaded() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void createTruck() {
        Spatial Cart = assetManager.loadModel("Models/Truck/truckCart.j3o");
        Spatial Truck = assetManager.loadModel("Models/Truck/truckMachine.j3o");
        truck.attachChild(Cart);
        truck.attachChild(Truck);
        
        truck.setLocalTranslation(0, 0, 0);
    }
}
