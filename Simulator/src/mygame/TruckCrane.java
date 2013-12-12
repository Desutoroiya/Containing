package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Johan
 */
public class TruckCrane extends Node implements CraneController{
    
    public AssetManager assetManager;
    private Node rootNode;
    

    public TruckCrane(AssetManager assetManager){
        this.assetManager = assetManager;
        this.rootNode = rootNode;
    }
        
   public void createTruckCrane(){
       
              
       Spatial TCraneLift = assetManager.loadModel("Models/scraneLift.j3o");
       this.attachChild(TCraneLift);
       Spatial TCraneBase = assetManager.loadModel("Models/scraneBase.j3o");
       this.attachChild(TCraneBase);
       
        this.setLocalTranslation(69.5f,0,24f);
        this.rotate(0,1.5707f,0);
        rootNode.attachChild(this);
       
   }
    
}

