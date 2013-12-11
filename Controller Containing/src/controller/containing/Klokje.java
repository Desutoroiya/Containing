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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Niels Riemersma
 */
public class Klokje {
    private final JLabel time = new JLabel();
    private final SimpleDateFormat sdf  = new SimpleDateFormat("hh.mm");
    private int currentSecond;
    private Calendar calendar;
    private double actualTime;
    private String tijd = Double.toString(actualTime);
    //VERSNELLING
    private final int speed = 1000; // 1000 is realtime
    
    private void reset(){
        currentSecond = calendar.get(Calendar.SECOND);
    }
    
    public void start(){
        Timer timer = new Timer(speed, new ActionListener(){
            public void actionPerformed( ActionEvent e ) {
                if ( currentSecond == 60){
                    actualTime += 00.01;
                    reset();
                }
                time.setText( String.format("%s:%02d", sdf.format(calendar.getTime()), currentSecond ));
                currentSecond++;
            }
        });
        timer.start();
    }
    
    public static void main( String [] args ) {
        JFrame frame = new JFrame();
        Clock clock = new Clock();
        frame.add( clock.time );
        frame.pack();
        frame.setVisible( true );
        clock.start();
    }
}
