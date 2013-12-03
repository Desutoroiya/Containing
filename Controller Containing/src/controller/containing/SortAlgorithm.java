/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.containing;

/**
 *
 * @author Niels
 */
public class SortAlgorithm {
    /*
     * priority = HOOG-LAAG ; 1,2,3,4
     * period = case identifier
     * timeArrive1+2, aankomsttijden
     * timeDept1+2, vertrektijden
     * tot5,20,60 = periodelengtes voor prioriteitstelling
     */
    int priority;
    String period;
    
    double timeArrive1, timeArrive2;
    
    double timeDept1, timeDept2;
    
    double tot5 = 00.05;
    double tot20 = 00.20;
    double tot60 = 01.00;        
    
    public void arrivePeriod(double timeArrive1, double timeArrive2){
        /*
         * Aankomsttijdvak = aankomsttijd2-aankomsttijd1
         * Vertrektijdvak = vertrektijd2-vertrektijd1
         */
        
        double periodArrive = timeArrive2 - timeArrive1;
        double periodDept = timeDept2 - timeDept1;
        
        if (periodArrive <= tot5){
            period = "minder dan 5";
            priority = 1;
        }
        else if (periodArrive <= tot20){
            period = "5 tot 20";
            priority = 2;
        }
        else if (periodArrive <= tot60){
            period = "20 tot 60";
            priority = 3;
        }
        else if (periodArrive > tot60){
            period = "60+";
            priority = 4;
        }
    }
        
    
    //List zas = new ArrayList();
    //int array1[] = {1, 2, 3, 4, 5};
    
    
    //zeeschip / binnenschip
    //String soort_vervoer = null;
    
    //public void getHighest(){
    //    if (soort_vervoer == "schip"){
    //        int hoogste = array1[4];
    //        for (int i = 0; i <array1.length; i++){
    //            if (array1[i]>hoogste){
    //                hoogste = array1[i];
    //           }
    //        }
    //   }
    //}
}
