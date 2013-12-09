package controller.containing;

/**
 *
 * @author Johan
 */
public class Points {
    
    /**
     * This class has all the Vertexes used to make the graph used in the Dijkstra class.
     * Each vehicle crane, storage crane and way point has it's own Vertex.
     */
  
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
                
                Vertex TC1 = new Vertex("Train Crane 1");
                Vertex TC2 = new Vertex("Train Crane 2");
                Vertex TC3 = new Vertex("Train Crane 3");
                Vertex TC4 = new Vertex("Train Crane 4");
                
                Vertex BC1 = new Vertex("Barge Crane 1");
                Vertex BC2 = new Vertex("Barge Crane 2");
                Vertex BC3 = new Vertex("Barge Crane 3");
                Vertex BC4 = new Vertex("Barge Crane 4");
                Vertex BC5 = new Vertex("Barge Crane 5");
                Vertex BC6 = new Vertex("Barge Crane 6");
                Vertex BC7 = new Vertex("Barge Crane 7");
                Vertex BC8 = new Vertex("Barge Crane 8");
                
                Vertex TCC1 = new Vertex("Truck Crane 1");
                Vertex TCC2 = new Vertex("Truck Crane 2");
                Vertex TCC3 = new Vertex("Truck Crane 3");
                Vertex TCC4 = new Vertex("Truck Crane 4");
                Vertex TCC5 = new Vertex("Truck Crane 5");
                Vertex TCC6 = new Vertex("Truck Crane 6");
                Vertex TCC7 = new Vertex("Truck Crane 7");
                Vertex TCC8 = new Vertex("Truck Crane 8");
                Vertex TCC9 = new Vertex("Truck Crane 9");
                Vertex TCC10 = new Vertex("Truck Crane 10");
                Vertex TCC11 = new Vertex("Truck Crane 11");
                Vertex TCC12 = new Vertex("Truck Crane 12");
                Vertex TCC13 = new Vertex("Truck Crane 13");
                Vertex TCC14 = new Vertex("Truck Crane 14");
                Vertex TCC15 = new Vertex("Truck Crane 15");
                Vertex TCC16 = new Vertex("Truck Crane 16");
                Vertex TCC17 = new Vertex("Truck Crane 17");
                Vertex TCC18 = new Vertex("Truck Crane 18");
                Vertex TCC19 = new Vertex("Truck Crane 19");
                Vertex TCC20 = new Vertex("Truck Crane 20");
                
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
                
                /**
                 * The constructor creates the actual graph. 
                 * Each Vertex is linked to other Vertexes. 
                 * There is also given a weight to each point, 
                 * this is the amount it will cost to reach this point from your current one.
                 */
                
                public Points(){
                    
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
 	                             new Edge(TC1, 181.25 )};
                  TC1.adjacencies = new Edge[]{ new Edge(WP9, 181.25),
                                    new Edge(TC2,362.5)};
                  TC2.adjacencies = new Edge[]{ new Edge(WP10, 181.25),
                                    new Edge(TC1,362.5)};
                  TC3.adjacencies = new Edge[]{ new Edge(TC4, 362.5),
                                    new Edge(WP10,181.25)};
                  TC4.adjacencies = new Edge[]{ new Edge(WP11, 181.25),
                                    new Edge(TC2,362.5)};
                  WP11.adjacencies = new Edge[]{ new Edge(WP7,  20),
 	                             new Edge(WP10, 725) };
                  WP12.adjacencies = new Edge[]{ new Edge(WP4,  20),
 	                             new Edge(BC1,45.3125) };
                  BC1.adjacencies = new Edge[]{ new Edge(WP12, 45.3125),
                                    new Edge(BC2, 90.625)};
                  BC2.adjacencies = new Edge[]{ new Edge(BC3, 90.625),
                                    new Edge(BC1, 90.625)};
                  BC3.adjacencies = new Edge[]{ new Edge(BC2, 90.625),
                                    new Edge(BC4, 90.625)};
                  BC4.adjacencies = new Edge[]{ new Edge(BC3, 90.625),
                                    new Edge(BC5, 90.625)};
                  BC5.adjacencies = new Edge[]{ new Edge(BC4, 90.625),
                                    new Edge(BC6, 90.625)};
                  BC6.adjacencies = new Edge[]{ new Edge(BC5, 90.625),
                                    new Edge(BC7, 90.625)};
                  BC7.adjacencies = new Edge[]{ new Edge(BC6, 90.625),
                                    new Edge(BC8, 90.625)};
                  BC8.adjacencies = new Edge[]{ new Edge(BC7, 90.625),
                                    new Edge(WP13, 45.3125)};
                  WP14.adjacencies = new Edge[]{ new Edge(WP8,  20),
 	                             new Edge(TCC20, 18.125) };
                  WP10.adjacencies = new Edge[]{ new Edge(WP5,  20),
 	                             new Edge(TC2, 181.25),
                                               new Edge(TC3, 181.25) };
                  WP13.adjacencies = new Edge[]{ new Edge(WP6,  20),
 	                             new Edge(BC8, 45.3125),
                                               new Edge(TCC1, 18.125) };
                  TCC1.adjacencies = new Edge[]{new Edge(WP13,18.125),
                                     new Edge(TCC2,36.25)};
                  TCC2.adjacencies = new Edge[]{new Edge(TCC3,36.25),
                                     new Edge(TCC1,36.25)};
                  TCC3.adjacencies = new Edge[]{new Edge(TCC2,36.25),
                                     new Edge(TCC4,36.25)};
                  TCC4.adjacencies = new Edge[]{new Edge(TCC3,36.25),
                                     new Edge(TCC5,36.25)};
                  TCC5.adjacencies = new Edge[]{new Edge(TCC4,36.25),
                                     new Edge(TCC6,36.25)};
                  TCC6.adjacencies = new Edge[]{new Edge(TCC5,36.25),
                                     new Edge(TCC7,36.25)};
                  TCC7.adjacencies = new Edge[]{new Edge(TCC6,36.25),
                                     new Edge(TCC8,36.25)};
                  TCC8.adjacencies = new Edge[]{new Edge(TCC7,36.25),
                                     new Edge(TCC9,36.25)};
                  TCC9.adjacencies = new Edge[]{new Edge(TCC8,36.25),
                                     new Edge(TCC10,36.25)};
                  TCC10.adjacencies = new Edge[]{new Edge(TCC9,36.25),
                                     new Edge(TCC11,36.25)};
                  TCC11.adjacencies = new Edge[]{new Edge(TCC10,36.25),
                                     new Edge(TCC12,36.25)}; 
                  TCC12.adjacencies = new Edge[]{new Edge(TCC11,36.25),
                                     new Edge(TCC13,36.25)}; 
                  TCC13.adjacencies = new Edge[]{new Edge(TCC12,36.25),
                                     new Edge(TCC14,36.25)};
                  TCC14.adjacencies = new Edge[]{new Edge(TCC15,36.25),
                                     new Edge(TCC13,36.25)};
                  TCC15.adjacencies = new Edge[]{new Edge(TCC14,36.25),
                                     new Edge(TCC16,36.25)};
                  TCC16.adjacencies = new Edge[]{new Edge(TCC15,36.25),
                                     new Edge(TCC17,36.25)};
                  TCC17.adjacencies = new Edge[]{new Edge(TCC16,36.25),
                                     new Edge(TCC18,36.25)};
                  TCC18.adjacencies = new Edge[]{new Edge(TCC17,36.25),
                                     new Edge(TCC19,36.25)};
                  TCC19.adjacencies = new Edge[]{new Edge(TCC18,36.25),
                                     new Edge(TCC20,36.25)}; 
                  TCC20.adjacencies = new Edge[]{new Edge(TCC19,36.25),
                                     new Edge(WP14,18.125)};
                }
                
                  
}