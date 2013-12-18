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
    private float Speed(boolean loaded){
        float speed;
        if(loaded){
            speed = 1f;
        }
        else{
            speed = 1f;
        }
        return speed;
    }
    public void move(Vector3f pos, Vector3f pos2){
        path = new MotionPath();
        path.addWayPoint(pos);
        path.addWayPoint(pos2);
        //path.addWayPoint(new Vector3f(4.6f,-0.1f,-19.5f));
        //path.addWayPoint(new Vector3f(-67.2f,-0.1f,-19.5f));
        
        motionControl = new MotionEvent(agv,path);
        path.setCurveTension(0f);
        motionControl.setDirectionType(MotionEvent.Direction.PathAndRotation);
        motionControl.setRotation(new Quaternion().fromAngleNormalAxis(-FastMath.HALF_PI,Vector3f.UNIT_Y));
        motionControl.setSpeed(Speed(false));
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
         agv.rotate(0, FastMath.HALF_PI,0);
         return AGV;
    }
    
}
