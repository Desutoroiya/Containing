package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.renderer.RenderManager;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
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

        float Xagv = 6f;
        float Yagv = 0;
        float Zagv = -22f;

        List<AGV> AGVList = new LinkedList<AGV>();
        AGV[] agv = new AGV[100];

        for (int i = 0; i < 50; i++) {
            agv[i] = new AGV(assetManager);
            AGVList.add(agv[i]);

            agv[i].CreateAGV();
            agv[i].agv.setLocalTranslation(Xagv, Yagv, Zagv);
            rootNode.attachChild(agv[i].agv);

            Xagv += 1f;
        }
        
        Xagv = 6f;
        
        for (int i = 50; i < 100; i++) {
            agv[i] = new AGV(assetManager);
            AGVList.add(agv[i]);

            agv[i].CreateAGV();
            agv[i].agv.setLocalTranslation(Xagv, Yagv, Zagv - 2f);
            rootNode.attachChild(agv[i].agv);

            Xagv += 1f;
            //System.out.println("ID= " + agv[i]);
        }
        
        for (int test = 0; test < 100; test++)
            agv[test].move(agv[test].agv.getLocalTranslation(), new Vector3f(agv[test].agv.getLocalTranslation().x, agv[test].agv.getLocalTranslation().y, agv[test].agv.getLocalTranslation().z + 2));
        
        
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

        CreateTrain(5);

        Ship ship = new Ship(assetManager, rootNode);
        ship.createShip();
        ship.ship.setLocalTranslation(-80, -0.5f, -20);
        rootNode.attachChild(ship.ship);

        Barge barge = new Barge(assetManager);
        barge.createBarge();
        barge.setLocalTranslation(-62.5f, -0.5f, 31f);
        rootNode.attachChild(barge);

        /*
         * Truck cranes maken
         * BEGIN
         * NIELS RIEMERSMA
         */
        float XtruckCrane = 69;
        float YtruckCrane = 0;
        float ZtruckCrane = 22f;

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
        int iTruckCrane = 1;
        truckCrane[iTruckCrane].moveBase(truckCrane[iTruckCrane].craneLift.getLocalTranslation().x, truckCrane[iTruckCrane].craneLift.getLocalTranslation().y, truckCrane[iTruckCrane].craneLift.getLocalTranslation().z);
        int iTruckCrane1 = 2;
        truckCrane[iTruckCrane1].moveHook();
        int iTruckCrane2 = 3;
        truckCrane[iTruckCrane2].moveLift();
        truckCrane[10].moveBase(truckCrane[10].craneLift.getLocalTranslation().x, truckCrane[10].craneLift.getLocalTranslation().y, truckCrane[10].craneLift.getLocalTranslation().z);
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

        int iTrainCrane = 0;
        trainCrane[iTrainCrane].moveBase(trainCrane[iTrainCrane].trainCrane.getLocalTranslation().x, trainCrane[iTrainCrane].trainCrane.getLocalTranslation().y, trainCrane[iTrainCrane].trainCrane.getLocalTranslation().z);
        int iTrainCrane1 = 1;
        trainCrane[iTrainCrane1].moveHook();
        int iTrainCrane2 = 2;
        trainCrane[iTrainCrane2].moveLift();
        int iTrainCrane3 = 3;
        trainCrane[iTrainCrane3].moveBase(trainCrane[iTrainCrane3].trainCrane.getLocalTranslation().x, trainCrane[iTrainCrane3].trainCrane.getLocalTranslation().y, trainCrane[iTrainCrane3].trainCrane.getLocalTranslation().z);
        

        /*
         * Train Cranes maken
         * EINDE
         */

        /*
         * Storage Cranes maken
         * BEGIN
         * IVAR DE LANGE
         */
        float XstorecraneOne = -64.5f;
        float YstorecraneOne = 0;
        float ZstorecraneOne = 18;

        float XstorecraneTwo = 7.5f;
        float YstorecraneTwo = 0;
        float ZstorecraneTwo = 18;

        List<StoreCrane> StorageCraneList = new LinkedList<StoreCrane>();
        StoreCrane[] storageCrane = new StoreCrane[46];

        for (int i = 0; i < 23; i++) {
            storageCrane[i] = new StoreCrane(assetManager);
            StorageCraneList.add(storageCrane[i]);
            storageCrane[i].createStoreCrane();
            storageCrane[i].storageCrane.setLocalTranslation(XstorecraneOne, YstorecraneOne, ZstorecraneOne);

            rootNode.attachChild(storageCrane[i].storageCrane);

            XstorecraneOne += 3;
        }

        for (int i = 23; i < 46; i++) {
            storageCrane[i] = new StoreCrane(assetManager);
            StorageCraneList.add(storageCrane[i]);
            storageCrane[i].createStoreCrane();
            storageCrane[i].storageCrane.setLocalTranslation(XstorecraneTwo, YstorecraneTwo, ZstorecraneTwo);

            rootNode.attachChild(storageCrane[i].storageCrane);

            XstorecraneTwo += 3;
        }
        int iStoreCrane = 30;
        storageCrane[iStoreCrane].moveBase(storageCrane[iStoreCrane].storageCrane.getLocalTranslation().x, storageCrane[iStoreCrane].storageCrane.getLocalTranslation().y, storageCrane[iStoreCrane].storageCrane.getLocalTranslation().z);
        int iStoreCrane1 = 2;
        storageCrane[iStoreCrane1].moveHook();
        int iStoreCrane2 = 10;
        storageCrane[iStoreCrane2].moveLift();

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
        float Zshipcrane = -24;

        List<ShipCrane> ShipCraneList = new LinkedList<ShipCrane>();
        ShipCrane[] shipCrane = new ShipCrane[10];

        for (int i = 0; i < 10; i++) {
            shipCrane[i] = new ShipCrane(assetManager);
            ShipCraneList.add(shipCrane[i]);
            shipCrane[i].createShipCrane();
            shipCrane[i].shipCrane.setLocalTranslation(Xshipcrane, Yshipcrane, Zshipcrane);

            rootNode.attachChild(shipCrane[i].shipCrane);

            Zshipcrane += 5.5f;
        }
        
        int iShipCrane = 1;
        shipCrane[iShipCrane].moveBase(shipCrane[iShipCrane].shipCrane.getLocalTranslation().x, shipCrane[iShipCrane].shipCrane.getLocalTranslation().y, shipCrane[iShipCrane].shipCrane.getLocalTranslation().z);
        int iShipCrane1 = 3;
        shipCrane[iShipCrane1].moveHook();
        int iShipCrane2 = 5;
        shipCrane[iShipCrane2].moveLift();

        /*
         * Ship Cranes maken
         * EINDE
         */

        /*
         * Barge Cranes maken
         * BEGIN
         * IVAR DE LANGE
         */
        float Xbargecrane = -64;
        float Ybargecrane = 0;
        float Zbargecrane = 29;

        List<BargeCrane> BargeCraneList = new LinkedList<BargeCrane>();
        BargeCrane[] bargeCrane = new BargeCrane[8];

        for (int i = 0; i < 8; i++) {
            bargeCrane[i] = new BargeCrane(assetManager);
            BargeCraneList.add(bargeCrane[i]);
            bargeCrane[i].createBargeCrane();
            bargeCrane[i].bargeCrane.setLocalTranslation(Xbargecrane, Ybargecrane, Zbargecrane);

            rootNode.attachChild(bargeCrane[i].bargeCrane);
            Xbargecrane += 9.25f;
        }
        int iBargeCrane = 1;
        bargeCrane[iBargeCrane].moveBase(bargeCrane[iBargeCrane].bargeCrane.getLocalTranslation().x, bargeCrane[iBargeCrane].bargeCrane.getLocalTranslation().y, bargeCrane[iBargeCrane].bargeCrane.getLocalTranslation().z);
        int iBargeCrane1 = 3;
        bargeCrane[iBargeCrane1].moveHook();
        int iBargeCrane2 = 5;
        bargeCrane[iBargeCrane2].moveLift();

        /*
         * Barge Cranes maken
         * EINDE
         */
        
        ContainerControl cc = new ContainerControl(assetManager, rootNode);
        cc.loadShipCont();
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    public void CreateTrain(int wagons){
        Train train = new Train(assetManager);
        train.createTrain();
        train.setLocalTranslation(-63, 0.1f, -28);
        rootNode.attachChild(train);
        for(int i =0;i<wagons;i++){
            TrainWagon wagon = new TrainWagon(assetManager);
            wagon.CreateWagon();
            wagon.setLocalTranslation(-63+(1.43f*i), 0.1f, -28);
            rootNode.attachChild(wagon);
        }
    }
}
