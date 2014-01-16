/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.containing;

import java.util.ArrayList;
import java.util.List;

/**
 * class.SortAlgorithm
 * @author Niels
 */
public class SortAlgorithm {
    XMLreader x = new XMLreader();
    
    /*
     * priority = HOOG-LAAG ; 1,2,3,4
     * period = case identifier
     * timeArrive1+2, aankomsttijden
     * timeDept1+2, vertrektijden
     * tot5,20,60 = periodelengtes voor prioriteitstelling
     */
    int priorityArrive, priorityDept;
    String periodArrive, periodDept;
    
    double currentTimeDubbel;// = Double.parseDouble());
    
    double currentTime = currentTimeDubbel;// = time.;
    double timeArrive1, timeArrive2;
    
    double timeDept1, timeDept2;
    
    double tot5 = 00.05;
    double tot20 = 00.20;
    double tot60 = 01.00;        
    
    /**
     * timeArrive holds two times, the containers should be unloaded between these times
     * @param timeArrive1
     * @param timeArrive2
     */
    public void arrivePeriod(double timeArrive1, double timeArrive2){
        /*
         * Aankomsttijdvak = aankomsttijd2-aankomsttijd1
         * Als huidige tijd > time Arrive 1 dan huidig = Arrive 1
         */
        
        if(currentTime > timeArrive1){
            timeArrive1 = currentTime;
        }
        
        double periodArriveD = timeArrive2 - timeArrive1;
        
        if (periodArriveD <= tot5){
            periodArrive = "minder dan 5";
            priorityArrive = 1;
        }
        else if (periodArriveD > tot5 || periodArriveD <= tot20){
            periodArrive = "5 tot 20";
            priorityArrive = 2;
        }
        else if (periodArriveD <= tot60){
            periodArrive = "20 tot 60";
           priorityArrive = 3;
        }
        else if (periodArriveD > tot60){
            periodArrive = "60+";
            priorityArrive = 4;
        }
    }
    
    /**
     * timeDept holds two times, the containers should be loaded between these times
     * @param timeDept1
     * @param timeDept2
     */
    public void deptPeriod(double timeDept1, double timeDept2){
        /*
         * Vertrektijdvak = vertrektijd2-vertrektijd1
         */
        
        if(currentTime > timeDept1){
            timeDept1 = currentTime;
        }
        
        double periodDeptD = timeDept2 - timeDept1;
        
        if (periodDeptD <= tot5){
            periodDept = "minder dan 5";
            priorityDept = 1;
        }
        else if (periodDeptD <= tot20){
            periodDept = "5 tot 20";
            priorityDept = 2;
        }
        else if (periodDeptD <= tot60){
            periodDept = "20 tot 60";
            priorityDept = 3;
        }
        else if (periodDeptD > tot60){
            periodDept = "60+";
            priorityDept = 4;
        }
    }
    
    /*
     * Sort op basis van hoogte en lengte
     */
    
    List YAS = new ArrayList();
    int containerHeight[] = {1, 2, 3, 4, 5};  // Y
    int containerWidth[] = {1, 2, 3, 4, 5};   // X
    int containerLenght[] = {1, 2, 3, 4, 5};  // Z
    
    
    //zeeschip / binnenschip
    String soort_vervoer;
        
    
    /**
     * unfortunately this doesnt work, but this would have to take the highest container of the stack
     */
    public void getHighest(){
        for (Container _container : x.getContainerList()){
            int id = _container.getID();
            String sID = String.valueOf(id);
            System.out.println(sID);
        }
//        if (soort_vervoer == "schip"){
//            int hoogste = containerHeight[4];
////            for (int y = 0; y <containerHeight.length; y++){
//////                for (int x = 5; x <containerHeight.length; x++){
////////                    for (int z = 5; z < containerHeight.length; z++){
////////                        
////////                    }
//////                }
////            }
//       }
    }
}
