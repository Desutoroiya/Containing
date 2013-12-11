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

class Clock {
    private final JLabel time = new JLabel();
    private final SimpleDateFormat sdf  = new SimpleDateFormat("hh.mm");
    private int currentSecond;
    private Calendar calendar;
    public String currentTimeClock;    
    public double tijd;
    //VERSNELLING
    private final int speed = 100; // 1000 is realtime
    

    public static void main( String [] args ) {
        JFrame frame = new JFrame();
        Clock clock = new Clock();
        frame.add( clock.time );
        frame.pack();
        frame.setVisible( true );
        clock.start();
    }
    private void reset(){
        calendar = Calendar.getInstance();
        currentSecond = calendar.get(Calendar.SECOND);
    }
    public void start(){
        reset();
        Timer timer = new Timer(speed, new ActionListener(){
        public void actionPerformed( ActionEvent e ) {
                if( currentSecond == 60 ) {
                    reset();
                    tijd += 00.01;
                }
                //ZONDER SECONDS
                //time.setText( String.format("%s", sdf.format(calendar.getTime())));
                //MET SECONDS
                //time.setText( String.format("%s.%02d", sdf.format(calendar.getTime()), currentSecond));
                //TEST
                //String tst = Double.toString(tijd);
                //time.setText(tst);
                currentSecond++;
            }
        });
        timer.start();
    }
}