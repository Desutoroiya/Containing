/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.containing;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iva
 */
public class MyTime 
{
    public MyTime(){
        
    }
    
    public static void main(String[] args){
        
    }
    
    public String getCurrentDate()
    {
        Calendar cal = new GregorianCalendar();
        int year = cal.get(cal.YEAR);
        int month = cal.get(cal.MONTH);
        int day = cal.get(cal.DAY_OF_MONTH);
        String date = ""+day+"/"+month+"/"+year+"";
        return date;
    }
    
    public void runTime()
    {
        int hour = 00;
        int minutes = 00;
        int seconds = 00;
        
        Thread clock = new Thread(){
            public void run(){
                int sleeptime = 1000;
                for(;;)
                {
                    System.out.println("p");
                    try
                    {
                        sleep(sleeptime);
                    } 
                    catch (InterruptedException ex)
                    {
                        Logger.getLogger(MyTime.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }           
            }         
        };
        clock.start();   
        
        String time = ""+hour+":"+minutes+":"+seconds+"";
        
    }   
    
    public void StopWatch(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        
        System.out.println("Tijd=" + stopWatch.getElapsedTime());
    }
        
}
