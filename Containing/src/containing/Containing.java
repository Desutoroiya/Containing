/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package containing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Fons
 */
public class Containing extends javax.swing.JFrame {

    /**
     * Creates new form Containing
     */
    public Containing() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Containing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Containing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Containing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Containing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Containing().setVisible(true);
            }
        });
        
        Vertex SF1 = new Vertex("Strorage 1 Front");
                Vertex SF2 = new Vertex("Strorage 2 Front");
                Vertex SF3 = new Vertex("Strorage 3 Front");
                Vertex SF4 = new Vertex("Strorage 4 Front");
                Vertex SF5 = new Vertex("Strorage 5 Front");
                Vertex SF6 = new Vertex("Strorage 6 Front");
                Vertex SF7 = new Vertex("Strorage 7 Front");
                Vertex SF8 = new Vertex("Strorage 8 Front");
                Vertex SF9 = new Vertex("Strorage 9 Front");
                Vertex SF10 = new Vertex("Strorage 10 Front");            
 
                Vertex SE1 = new Vertex("Strorage 1 End");
                Vertex SE2 = new Vertex("Strorage 2 End");
                Vertex SE3 = new Vertex("Strorage 3 End");
                Vertex SE4 = new Vertex("Strorage 4 End");
                Vertex SE5 = new Vertex("Strorage 5 End");
                Vertex SE6 = new Vertex("Strorage 6 End");
                Vertex SE7 = new Vertex("Strorage 7 End");
                Vertex SE8 = new Vertex("Strorage 8 End");
                Vertex SE9 = new Vertex("Strorage 9 End");
                Vertex SE10 = new Vertex("Strorage 10 End");
                Vertex SE11 = new Vertex("Strorage 11 End");
                Vertex SE12 = new Vertex("Strorage 12 End");
                Vertex SE13 = new Vertex("Strorage 13 End");
                Vertex SE14 = new Vertex("Strorage 14 End");
                Vertex SE15 = new Vertex("Strorage 15 End");
                Vertex SE16 = new Vertex("Strorage 16 End");
                Vertex SE17 = new Vertex("Strorage 17 End");
                Vertex SE18 = new Vertex("Strorage 18 End");
                Vertex SE19 = new Vertex("Strorage 19 End");
                Vertex SE20 = new Vertex("Strorage 20 End");
                
                Vertex CSC1 = new Vertex("Container Crane 1");
                Vertex CSC2 = new Vertex("Container Crane 2");
                Vertex CSC3 = new Vertex("Container Crane 3");
                Vertex CSC4 = new Vertex("Container Crane 4");
                Vertex CSC5 = new Vertex("Container Crane 5");
                Vertex CSC6 = new Vertex("Container Crane 6");
                Vertex CSC7 = new Vertex("Container Crane 7");
                Vertex CSC8 = new Vertex("Container Crane 8");
                Vertex CSC9 = new Vertex("Container Crane 9");
                Vertex CSC10 = new Vertex("Container Crane 10");
                
                Vertex WP1 = new Vertex("Left Top Outer Way");
                Vertex WP2 = new Vertex("Left Bottom Outer Way");
                Vertex WP3 = new Vertex("Left Top Inner Way");
                Vertex WP4 = new Vertex("Left Bottom Inner Way");
                Vertex WP5 = new Vertex("Middle Top Inner Way");
                Vertex WP6 = new Vertex("Middle Bottom Inner Way");
                Vertex WP7 = new Vertex("Right Top Inner Way");
                Vertex WP8 = new Vertex("Right Bottom Inner Way");
                Vertex WP9 = new Vertex("Left Top Dock Way");
                Vertex WP10 = new Vertex("Middle Top Dock Way");
                Vertex WP11 = new Vertex("Right Top Dock Way");
                Vertex WP12 = new Vertex("Left Bottom Dock Way");
                Vertex WP13 = new Vertex("Middle Bottom Dock Way");
                Vertex WP14 = new Vertex("Right Bottom Dock Way");
                
                
 	WP1.adjacencies = new Edge[]{ new Edge(WP3,  80),
 	                             new Edge(CSC1, 26) };
         	CSC1.adjacencies = new Edge[]{ new Edge(WP1,  26),
 	                             new Edge(CSC2, 52) };
                  CSC2.adjacencies = new Edge[]{ new Edge(CSC1,  52),
 	                             new Edge(CSC3, 52) };
                  CSC3.adjacencies = new Edge[]{ new Edge(CSC2,  52),
 	                             new Edge(CSC4, 52) };
                  CSC4.adjacencies = new Edge[]{ new Edge(CSC3,  52),
 	                             new Edge(CSC5, 52) };
                  CSC5.adjacencies = new Edge[]{ new Edge(CSC4,  52),
 	                             new Edge(CSC6, 52) };
                  CSC6.adjacencies = new Edge[]{ new Edge(CSC5,  52),
 	                             new Edge(CSC7, 52) };
                  CSC7.adjacencies = new Edge[]{ new Edge(CSC6,  52),
 	                             new Edge(CSC8, 52) };
                  CSC8.adjacencies = new Edge[]{ new Edge(CSC7,  52),
 	                             new Edge(CSC9, 52) };
                  CSC9.adjacencies = new Edge[]{ new Edge(CSC8,  52),
 	                             new Edge(CSC10, 52) };
                  CSC10.adjacencies = new Edge[]{ new Edge(CSC9,  52),
 	                             new Edge(WP2, 26) };
                   WP2.adjacencies = new Edge[]{ new Edge(WP4,  80),
 	                             new Edge(CSC10, 26) };
                   WP4.adjacencies = new Edge[]{new Edge(WP2, 80),
                                                new Edge(WP12, 20),
                                                new Edge(WP6,725),
                                                new Edge(SE10,26)};
                  WP3.adjacencies = new Edge[]{new Edge(WP1, 80),
                                                new Edge(WP9, 20),
                                                new Edge(SE1,26),
                                                new Edge(WP5,725)};
                  SE1.adjacencies = new Edge[]{ new Edge(WP3,  26),
 	                             new Edge(SE2, 52) };
                  SE2.adjacencies = new Edge[]{ new Edge(SE1,  52),
 	                             new Edge(SE3, 52) };
                  SE3.adjacencies = new Edge[]{ new Edge(SE2,  52),
 	                             new Edge(SE4, 52) };
                  SE4.adjacencies = new Edge[]{ new Edge(SE3,  52),
 	                             new Edge(SE5, 52) };
                  SE5.adjacencies = new Edge[]{ new Edge(SE4,  52),
 	                             new Edge(SE6, 52) };
                  SE6.adjacencies = new Edge[]{ new Edge(SE5,  52),
 	                             new Edge(SE7, 52) };
                  SE7.adjacencies = new Edge[]{ new Edge(SE6,  52),
 	                             new Edge(SE8, 52) };
                  SE8.adjacencies = new Edge[]{ new Edge(SE7,  52),
 	                             new Edge(SE9, 52) };
                  SE9.adjacencies = new Edge[]{ new Edge(SE8,  52),
 	                             new Edge(SE10, 52) };
                  SE10.adjacencies = new Edge[]{ new Edge(SE9,  52),
 	                             new Edge(WP4, 26) };
                   WP5.adjacencies = new Edge[]{new Edge(WP10, 20),
                                                new Edge(SF1,26 ),
                                                new Edge(WP7,725),
                                                new Edge(WP3,725)};
                  WP6.adjacencies = new Edge[]{new Edge(WP13, 20),
                                                new Edge(WP4, 725),
                                                new Edge(WP8, 725),
                                                new Edge(SF10,26)};
                  SF1.adjacencies = new Edge[]{ new Edge(WP5,  26),
 	                             new Edge(SF2, 52) };
                  SF2.adjacencies = new Edge[]{ new Edge(SF1,  52),
 	                             new Edge(SF3, 52) };
                  SF3.adjacencies = new Edge[]{ new Edge(SF2,  52),
 	                             new Edge(SF4, 52) };
                  SF4.adjacencies = new Edge[]{ new Edge(SF3,  52),
 	                             new Edge(SF5, 52) };
                  SF5.adjacencies = new Edge[]{ new Edge(SF4,  52),
 	                             new Edge(SF6, 52) };
                  SF6.adjacencies = new Edge[]{ new Edge(SF5,  52),
 	                             new Edge(SF7, 52) };
                  SF7.adjacencies = new Edge[]{ new Edge(SF6,  52),
 	                             new Edge(SF8, 52) };
                  SF8.adjacencies = new Edge[]{ new Edge(SF7,  52),
 	                             new Edge(SF9, 52) };
                  SF9.adjacencies = new Edge[]{ new Edge(SF8,  52),
 	                             new Edge(SF10, 52) };
                  SF10.adjacencies = new Edge[]{ new Edge(SF9,  52),
 	                             new Edge(WP6, 26) };
                  WP7.adjacencies = new Edge[]{new Edge(WP11, 20),
                                                new Edge(WP5, 725),
                                                new Edge(SE11,26)};
                  WP8.adjacencies = new Edge[]{new Edge(WP14, 20),
                                                new Edge(SE20,26),
                                                new Edge(WP6,725)};
                  SE11.adjacencies = new Edge[]{ new Edge(WP7,  26),
 	                             new Edge(SE12, 52) };
                  SE12.adjacencies = new Edge[]{ new Edge(SE11,  52),
 	                             new Edge(SE13, 52) };
                  SE13.adjacencies = new Edge[]{ new Edge(SE12,  52),
 	                             new Edge(SE14, 52) };
                  SE14.adjacencies = new Edge[]{ new Edge(SE13,  52),
 	                             new Edge(SE15, 52) };
                  SE15.adjacencies = new Edge[]{ new Edge(SE14,  52),
 	                             new Edge(SE16, 52) };
                  SE16.adjacencies = new Edge[]{ new Edge(SE15,  52),
 	                             new Edge(SE17, 52) };
                  SE17.adjacencies = new Edge[]{ new Edge(SE16,  52),
 	                             new Edge(SE18, 52) };
                  SE18.adjacencies = new Edge[]{ new Edge(SE17,  52),
 	                             new Edge(SE19, 52) };
                  SE19.adjacencies = new Edge[]{ new Edge(SE18,  52),
 	                             new Edge(SE20, 52) };
                  SE20.adjacencies = new Edge[]{ new Edge(SE19,  52),
 	                             new Edge(WP8, 26) };
                  WP9.adjacencies = new Edge[]{ new Edge(WP3,  20),
 	                             new Edge(WP10, 725) };
                  WP11.adjacencies = new Edge[]{ new Edge(WP7,  20),
 	                             new Edge(WP10, 725) };
                  WP12.adjacencies = new Edge[]{ new Edge(WP4,  20),
 	                             new Edge(WP13, 725) };
                  WP14.adjacencies = new Edge[]{ new Edge(WP8,  20),
 	                             new Edge(WP13, 725) };
                  WP10.adjacencies = new Edge[]{ new Edge(WP5,  20),
 	                             new Edge(WP9, 725),
                                               new Edge(WP11, 725) };
                   WP13.adjacencies = new Edge[]{ new Edge(WP6,  20),
 	                             new Edge(WP12, 725),
                                               new Edge(WP14, 725) };
                   
                   computePaths(CSC7);   
                   computePaths(CSC5);
                      System.out.println("Distance from " + SF7 +" to " + SE11 + " is: " + SE11.minDistance);
	    List<Vertex> path = getShortestPathTo(SF7);
	    System.out.println("Path: " + path);
        
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

     public static void computePaths(Vertex source)
      {
         source.minDistance = 0.;
          PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
  	vertexQueue.add(source);
  
  	while (!vertexQueue.isEmpty()) {
 	    Vertex u = vertexQueue.poll();

             // Visit each edge exiting u
            for (Edge e : u.adjacencies)
              {
                 Vertex v = e.target;
                  double weight = e.weight;
                  double distanceThroughU = u.minDistance + weight;
 		if (distanceThroughU < v.minDistance) {
 		    vertexQueue.remove(v);
 
 		    v.minDistance = distanceThroughU ;
 		    v.previous = u;
 		    vertexQueue.add(v);
  		}
              }
         }
     }
    
          public static List<Vertex> getShortestPathTo(Vertex target)
      {
          List<Vertex> path = new ArrayList<Vertex>();
         for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
              path.add(vertex);
 
         Collections.reverse(path);
          return path;
    }    
}
