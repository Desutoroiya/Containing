/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.containing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Timer;

/**
 *
 * @author Niels Riemersma
 */
public class Klokje {
    private final SimpleDateFormat sdf  = new SimpleDateFormat("hh.mm");
    private int currentSecond;
    private Calendar calendar;
    private double actualTime;
    private String tijd = Double.toString(actualTime);
    //VERSNELLING
    private final int speed = 100; // 1000 is realtime
    
    private void reset(){
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);     
    }
    
    public void start(){
        reset();
        Timer timer = new Timer(speed, new ActionListener(){
            public void actionPerformed( ActionEvent e ) {
                if ( currentSecond == 60){
                    actualTime += 00.01;
                    currentSecond = 0;
                }
                currentSecond++;
            }
        });
        timer.start();
    }
    
    public void yolo(){
        start();
        System.out.println(tijd);
    }
    
}
