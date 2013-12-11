package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Johan
 */
public class TruckCrane extends Node implements CraneController{
    
    public AssetManager assetManager;

    public TruckCrane(AssetManager assetManager){
        this.assetManager = assetManager;
    }
        
   public void createTruckCrane(){
       
              
       Spatial TCraneBase = assetManager.loadModel("Models/scraneLift.j3o");
       this.attachChild(TCraneBase);
       Spatial TCrane = assetManager.loadModel("Models/scraneBase.j3o");
       this.attachChild(TCrane);
       
   }
    
}

