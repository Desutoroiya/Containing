/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Niels Riemersma
 */
public class ContainerControl {

    AssetManager assetManager;
    Node rootNode;

    public ContainerControl(AssetManager assetManager, Node rootNode) {
        this.assetManager = assetManager;
        this.rootNode = rootNode;
    }

    public void loadShipCont() {
        int containerAmountVar = 0;
        int containerAmount = 100;

        List<Container> containerList = new LinkedList<Container>();
        Container[] container = new Container[containerAmount];

        Ship ship = new Ship(assetManager, rootNode);


        float contXdist = -80;
        float contYdist = -0.5f;
        float contZdist = -20;

        for (int contX = 0; contX < 5; contX++) {
            container[containerAmountVar] = new Container(assetManager, rootNode);
            containerList.add(container[containerAmountVar]);

            container[containerAmountVar].loadContainer();
            container[containerAmountVar].contNode.setLocalTranslation(contXdist, contYdist, contZdist);
            rootNode.attachChild(container[containerAmountVar].contNode);
            contXdist += 0.255f;
        }

        //contYdist = 0.25f;

        for (int contY = 0; contY < 15; contY++) {
            container[containerAmountVar] = new Container(assetManager, rootNode);
            containerList.add(container[containerAmountVar]);

            container[containerAmountVar].loadContainer();
            container[containerAmountVar].contNode.setLocalTranslation(contXdist, contYdist, contZdist);
            rootNode.attachChild(container[containerAmountVar].contNode);
            contYdist += 0.265f;
        }

        for (int contZ = 0; contZ < 20; contZ++) {
            container[containerAmountVar] = new Container(assetManager, rootNode);
            containerList.add(container[containerAmountVar]);

            container[containerAmountVar].loadContainer();
            container[containerAmountVar].contNode.setLocalTranslation(contXdist, contYdist, contZdist);
            rootNode.attachChild(container[containerAmountVar].contNode);
            contZdist += 1.25;
        }
    }
//    List<TruckCrane> TruckCraneList = new LinkedList<TruckCrane>();
//    TruckCrane[] truckCrane = new TruckCrane[20];
//    for (int i = 0;i< 20; i++) {
//            truckCrane[i] = new TruckCrane(assetManager);
//            TruckCraneList.add(truckCrane[i]);
//
//            truckCrane[i].createTruckCrane();
//            truckCrane[i].craneLift.setLocalTranslation(XtruckCrane, YtruckCrane, ZtruckCrane);
//            rootNode.attachChild(truckCrane[i].craneLift);
//
//            XtruckCrane -= 3;
//    }

//    public void createShip() {
//        Spatial ship = assetManager.loadModel("Models/ship.j3o");
//        this.attachChild(ship);
//        ship.rotate(0, FastMath.PI * 1.5f, 0);
//        if (loaded) {
//            float yolo1 = 0;
//            float yolo2 = 0.5f;
//            float yolo3 = -7;
//            for (int i = 0; i < 15; i++) {
//                Spatial container = assetManager.loadModel("Models/container.j3o");
//                this.attachChild(container);
//                container.setLocalTranslation(yolo1, yolo2, yolo3);
//
//                Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//                mat.setColor("Color", ColorRGBA.randomColor());
//                container.setMaterial(mat);
//                yolo3 += 0.3f;
//                yolo3++;
//            }
//        }
//    }
}
