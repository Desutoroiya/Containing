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
        
        /*
         * Ambient Lightning
         */

        AmbientLight ambLight = new AmbientLight();
        ambLight.setColor(new ColorRGBA(1f, 1f, 0.8f, 0.2f));
        rootNode.addLight(ambLight);
        
        /*
         * Loading terrain
         */

        Terrain terrain = new Terrain(assetManager, rootNode);
        terrain.initTerrain();
        viewPort.setBackgroundColor(ColorRGBA.Blue);
        
        float Xagv = 4.6f;
        float Yagv = 0;
        float Zagv = -19.5f;
        
        List<AGV> AGVList = new LinkedList<AGV>();
        AGV[] agv = new AGV[100];
        
        for (int i = 0; i <100; i++){
            agv[i] = new AGV(assetManager);
            AGVList.add(agv[i]);

            agv[i].CreateAGV();
            agv[i].agv.setLocalTranslation(Xagv, Yagv, Zagv);
            rootNode.attachChild(agv[i].agv);
            
            Xagv -= 1.5f;
        }
        
//
//        AGV agv = new AGV(assetManager);
//        agv.CreateAGV();
//        agv.setLocalTranslation(4.6f, 0.9f, -19.5f);
//        rootNode.attachChild(agv);
//        agv.move();

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
        
        Ship ship = new Ship(assetManager);
        ship.createShip();
        ship.setLocalTranslation(-80, -0.5f, -20);
        rootNode.attachChild(ship);

        Barge barge = new Barge(assetManager);
        barge.createBarge();
        barge.setLocalTranslation(-62.5f, -0.5f, 31f);
        rootNode.attachChild(barge);
        
        /*
         * Truck cranes maken
         * BEGIN
         * NIELS RIEMERSMA
         */
        float XtruckCrane = 69.5f;
        float YtruckCrane = 0;
        float ZtruckCrane = 20.75f;

        List<TruckCrane> TruckCraneList = new LinkedList<TruckCrane>();
        TruckCrane[] truckCrane = new TruckCrane[20];

        for (int i = 0; i < 20; i++) {
            truckCrane[i] = new TruckCrane(assetManager);
            TruckCraneList.add(truckCrane[i]);

            truckCrane[i].createTruckCrane();
            truckCrane[i].craneLift.setLocalTranslation(XtruckCrane, YtruckCrane, ZtruckCrane);
            rootNode.attachChild(truckCrane[i].craneLift);

            XtruckCrane -= 3;
        }
//        int iNiels = 1;
//        tc[iNiels].moveBase(tc[iNiels].craneLift.getLocalTranslation().x, tc[iNiels].craneLift.getLocalTranslation().y, tc[iNiels].craneLift.getLocalTranslation().z + 1);
//        int isNiels = 2;
//        tc[isNiels].moveHook();
//        int isniels2 = 3;
//        tc[isniels2].moveLift();
        /*
         * Truck Cranes maken 
         * EINDE
         */

        /*
         * Train Cranes maken
         * BEGIN
         * IVAR DE LANGE
         */
        float XtrainCrane = -62.5f;
        float YtrainCrane = 0;
        float ZtrainCrane = -27;
        
        List<TrainCrane> TrainCraneList = new LinkedList<TrainCrane>();
        TrainCrane[] trainCrane = new TrainCrane[4];

        for (int i = 0; i < 4; i++) {
            trainCrane[i] = new TrainCrane(assetManager);
            TrainCraneList.add(trainCrane[i]);

            trainCrane[i].createTrainCrane();
            trainCrane[i].trainCrane.setLocalTranslation(XtrainCrane, YtrainCrane, ZtrainCrane);
            
            rootNode.attachChild(trainCrane[i].trainCrane);
            
            XtrainCrane += 10;
        }
        /*
         * Train Cranes maken
         * EINDE
         */

        /*
         * Storage Cranes maken
         * BEGIN
         * IVAR DE LANGE
         */
        float XstorecraneOne = 3.5f;
        float YstorecraneOne = 0;
        float ZstorecraneOne = -16.5f;
        
        float XstorecraneTwo = 5.5f;
        float YstorecraneTwo = 0;
        float ZstorecraneTwo = -16.5f;
        
        List<StoreCrane> StorageCraneList = new LinkedList<StoreCrane>();
        StoreCrane[] storageCrane = new StoreCrane[24];

        for (int i = 0; i < 12; i++) {
            storageCrane[i] = new StoreCrane(assetManager);
            StorageCraneList.add(storageCrane[i]);
            storageCrane[i].createStoreCrane();
            storageCrane[i].storageCrane.setLocalTranslation(XstorecraneOne, YstorecraneOne, ZstorecraneOne);
            
            rootNode.attachChild(storageCrane[i].storageCrane);
            
            ZstorecraneOne += 3;
        }
        
        for (int i = 12; i < 24; i++){
            storageCrane[i] = new StoreCrane(assetManager);
            StorageCraneList.add(storageCrane[i]);
            storageCrane[i].createStoreCrane();            
            storageCrane[i].storageCrane.setLocalTranslation(XstorecraneTwo, YstorecraneTwo, ZstorecraneTwo);
            
            rootNode.attachChild(storageCrane[i].storageCrane);
            
            ZstorecraneTwo += 3;
        }
        /*
         * Storage Cranes maken
         * EINDE
         */

        /*
         * Ship Cranes maken
         * BEGIN
         * IVAR DE LANGE
         */
        float Xshipcrane = -77;
        float Yshipcrane = 0;
        float Zshipcrane = -27;
        
        List<ShipCrane> ShipCraneList = new LinkedList<ShipCrane>();
        ShipCrane[] shipCrane = new ShipCrane[25];

        for (int i = 0; i < 10; i++) {
            shipCrane[i] = new ShipCrane(assetManager);
            ShipCraneList.add(shipCrane[i]);
            shipCrane[i].createShipCrane();            
            shipCrane[i].shipCrane.setLocalTranslation(Xshipcrane, Yshipcrane, Zshipcrane);
            
            rootNode.attachChild(shipCrane[i].shipCrane);
            
            Zshipcrane += 6;
        }

        /*
         * Ship Cranes maken
         * EINDE
         */

        /*
         * Barge Cranes maken
         * BEGIN
         * IVAR DE LANGE
         */
        float Xbargecrane = -65;
        float Ybargecrane = 0;
        float Zbargecrane = 29;
        
        List<BargeCrane> BargeCraneList = new LinkedList<BargeCrane>();
        BargeCrane[] bargeCrane = new BargeCrane[25];

        for (int i = 0; i < 8; i++) {
            bargeCrane[i] = new BargeCrane(assetManager);
            BargeCraneList.add(bargeCrane[i]);
            bargeCrane[i].createBargeCrane();            
            bargeCrane[i].bargeCrane.setLocalTranslation(Xbargecrane, Ybargecrane, Zbargecrane);
            
            rootNode.attachChild(bargeCrane[i].bargeCrane);
            Xbargecrane += 10;
        }

        /*
         * Barge Cranes maken
         * EINDE
         */
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
