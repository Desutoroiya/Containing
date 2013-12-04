/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.containing;

/**
 *
 * @author Niels Riemersma
 */
public class StopWatch {

  private double startTime = 00.00;
  private double stopTime = 00.00;
  private boolean running = false;


  public void start() {
    this.startTime = System.currentTimeMillis();
    this.running = true;
  }


  public void stop() {
    this.stopTime = System.currentTimeMillis();
    this.running = false;
  }


  //elaspsed time in milliseconds
  public double getElapsedTime() {
    double elapsed;
    if (running) {
      elapsed = (System.currentTimeMillis() - startTime);
    }
    else {
      elapsed = (stopTime - startTime);
    }
    return elapsed;
  }


  //elaspsed time in seconds
  public double getElapsedTimeSecs() {
    double elapsed;
    if (running) {
      elapsed = ((System.currentTimeMillis() - startTime) / 1000);
    }
    else {
      elapsed = ((stopTime - startTime) / 1000);
    }
    return elapsed;
  }
}
