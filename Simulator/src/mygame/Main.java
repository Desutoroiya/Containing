package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.renderer.RenderManager;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import java.util.LinkedList;
import java.util.List;

/**
 * test
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    
    Node craneLift = new Node();

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        cam.setLocation(new Vector3f(0, 10, 0));
        flyCam.setMoveSpeed(25);

        /**
         * A white, directional light source
         */
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection((new Vector3f(-0.5f, -0.5f, -0.5f)).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun);

        AmbientLight ambLight = new AmbientLight();
        ambLight.setColor(new ColorRGBA(1f, 1f, 0.8f, 0.2f));
        rootNode.addLight(ambLight);

        Terrain terrain = new Terrain(assetManager, rootNode);
        terrain.initTerrain();
        viewPort.setBackgroundColor(ColorRGBA.Blue);

        AGV agv = new AGV(assetManager);
        agv.CreateAGV();
        agv.setLocalTranslation(4.6f, 0.9f, -19.5f);
        rootNode.attachChild(agv);
        agv.move();

        Truck truck = new Truck(assetManager);
        truck.CreateTruck();
        truck.setLocalTranslation(69.5f, 0, 24f);
        rootNode.attachChild(truck);
        truck.move();

        Truck truc = new Truck(assetManager);
        truc.CreateTruck();
        truc.setLocalTranslation(69.5f, 0, 24f);
        rootNode.attachChild(truc);

        Train train = new Train(assetManager);
        train.createTrain();
        train.setLocalTranslation(-63, 0.1f, -28);
        rootNode.attachChild(train);


        /*
         * Truck cranes maken
         */
        float XtC = 69.5f;
        float YtC = 0;
        float ZtC = 20.75f;
        
        List<TruckCrane> list = new LinkedList<TruckCrane>();
        TruckCrane[] tc = new TruckCrane[20];
        
        for (int i = 0; i < 20; i++){
            tc[i] = new TruckCrane(assetManager);
            list.add(tc[i]);
            
            tc[i].createTruckCrane();
            tc[i].craneLift.setLocalTranslation(XtC, YtC, ZtC);
            rootNode.attachChild(tc[i].craneLift);
            
            XtC -= 3;
            
            //SPACE
            //tc.moveHook();
            //tc.moveLift();
        }
        
            tc[0].moveBase(XtC, YtC, ZtC);
        
        //tc[2].moveBase(tc[2].craneLift.getLocalTranslation().x, tc[2].craneLift.getLocalTranslation().y, tc[2].craneLift.getLocalTranslation().z + 1);
        
        
        float Xtraincrane = -62.5f;
        float Ytraincrane = 0;
        float Ztraincrane = -28;
        
        for (int i = 0; i < 4; i++){
            TrainCrane trainc = new TrainCrane(assetManager);
            trainc.createTrainCrane();
            trainc.setLocalTranslation(Xtraincrane, Ytraincrane, Ztraincrane);
            rootNode.attachChild(trainc);
            Xtraincrane += 10;
        }
        
        float XstorecraneOne = 3.5f;
        float YstorecraneOne = 0;
        float ZstorecraneOne = -16.5f;
        
        for (int i = 0; i < 12; i++){
            StoreCrane storec = new StoreCrane(assetManager);
            storec.createStoreCrane();
            storec.setLocalTranslation(XstorecraneOne, YstorecraneOne, ZstorecraneOne);
            rootNode.attachChild(storec);
            ZstorecraneOne +=3;
            
        }
        
        float XstorecraneTwo = 5.5f;
        float YstorecraneTwo = 0;
        float ZstorecraneTwo = -16.5f;
        
        for (int i = 0; i < 12; i++){
            StoreCrane storec = new StoreCrane(assetManager);
            storec.createStoreCrane();
            storec.setLocalTranslation(XstorecraneTwo, YstorecraneTwo, ZstorecraneTwo);
            rootNode.attachChild(storec);
            ZstorecraneTwo +=3;
        }
        
        float Xshipcrane = -77;
        float Yshipcrane = 0;
        float Zshipcrane = -27;
        
        for (int i = 0; i < 10; i++){
            ShipCrane shipc = new ShipCrane(assetManager);
            shipc.createShipCrane();
            shipc.setLocalTranslation(Xshipcrane, Yshipcrane, Zshipcrane);
            rootNode.attachChild(shipc);
            Zshipcrane +=6;
        }
        
        float Xbargecrane = -65;
        float Ybargecrane = 0;
        float Zbargecrane = 29;
        
        for (int i = 0; i < 8; i++){
            BargeCrane bargec = new BargeCrane(assetManager);
            bargec.createBargeCrane();
            bargec.setLocalTranslation(Xbargecrane, Ybargecrane, Zbargecrane);
            rootNode.attachChild(bargec);
            Xbargecrane +=10;
        }
            
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
