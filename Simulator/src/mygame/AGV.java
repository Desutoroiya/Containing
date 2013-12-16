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
public class AGV extends Node {
    public AssetManager assetManager;
    Node agv = new Node();
    private MotionPath path;
    private MotionEvent motionControl;
    public boolean loaded = false;
    public AGV(AssetManager assetManager){
        this.assetManager = assetManager;
        
        
        
    }
    private int Speed(boolean loaded){
        int speed;
        if(loaded){
            speed = 2;
        }
        else{
            speed = 1;
        }
        return speed;
    }
    public void move(){
        path = new MotionPath();
        path.addWayPoint(new Vector3f(76,-0.1f,19.5f));
        path.addWayPoint(new Vector3f(4.6f,-0.1f,19.5f));
        path.addWayPoint(new Vector3f(4.6f,-0.1f,-19.5f));
        path.addWayPoint(new Vector3f(-67.2f,-0.1f,-19.5f));
        
        motionControl = new MotionEvent(this,path);
        path.setCurveTension(0f);
        motionControl.setDirectionType(MotionEvent.Direction.PathAndRotation);
        motionControl.setRotation(new Quaternion().fromAngleNormalAxis(-FastMath.HALF_PI,Vector3f.UNIT_Y));
        motionControl.setSpeed(Speed(loaded));
        motionControl.play();
    }
    public void pickUpContainer(){
        loaded = true;
        
    }
    public void dropContainer(){
        loaded = false;
    }
    public Spatial CreateAGV(){
         Spatial AGV = assetManager.loadModel("Models/agv.j3o");
         agv.attachChild(AGV);
         return AGV;
    }
    
}
