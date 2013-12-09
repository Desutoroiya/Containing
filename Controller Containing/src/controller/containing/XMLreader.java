/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.containing;

import java.io.File;
import java.util.ArrayList;

import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Enzo
 */
public class XMLreader {
    
    /**
     * @param args the command line arguments
     */
    public void XMLreader() {
       /*
        *  instance sortAlgorithm and Dijkstra creates container lists
        */
        SortAlgorithm s = new SortAlgorithm();
        DijkstraAlgorithm z = new DijkstraAlgorithm();
        
        List<Container> _containerList;
        _containerList = new ArrayList<Container>();
        
        /*
         * loads the XML File
         */
        try{
            File ContainerList = new File("xml1.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(ContainerList);
                      doc.getDocumentElement().normalize();
          
            System.out.println("root of XML file"+doc.getDocumentElement().getNodeName());
            NodeList nodes = doc.getElementsByTagName("record");
            NodeList nodes1 = doc.getElementsByTagName("vertrek");
            System.out.println("====================");
            /*
             * loops through the XML file and creates a container for every record
             */
            for(int i =0; i < nodes.getLength(); i++){
                Node node = nodes.item(i);
                Element element =  (Element) node;
                
                int id = 01+i;
                
                if(node.getNodeType()== Node.ELEMENT_NODE){
                    Container _container = new Container(id,getValue("d", element)+getValue("m", element)+getValue("j", element),getDoubleValue(0,"van", element),getDoubleValue(1,"tot", element),getValue("soort_vervoer", element),
                           getValue("bedrijf", element),getIntValue(0,"x", element),getIntValue(0,"y", element),getIntValue(0,"z", element),getDoubleValue("d",element)+getDoubleValue("m",element)+
                           getDoubleValue("j",element),getDoubleValue(1,"van",element),getDoubleValue(1,"tot",element),getDoubleValue("soort_vervoer",element),getDoubleValue("bedrijf",element),getValue("eigenaar", element),getIntValue(0,"containernr", element),
                           getIntValue(0,"leeg", element)+getIntValue(0,"inhoud",element),getDoubleValue("naam",element),getValue("soort", element),getValue("gevaar", element),getValue("ISO",element));
                    _containerList.add(_container);
                    s.arrivePeriod(getDoubleValue(0,"van", element),getDoubleValue(0,"tot", element));
                    s.deptPeriod(getDoubleValue(1,"van", element), getDoubleValue(1,"tot", element));
                    z.makePath(getValue("soort_vervoer", element));
                    
                    DijkstraAlgorithm d = new DijkstraAlgorithm();

                    d.makePath(getValue("soort_vervoer",element));
                }
                
                
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        for(int i = 0;i<_containerList.size();i++){
            System.out.println("--------------------------");
            System.out.println(_containerList.get(i));
            System.out.println("period aankomst " + s.periodArrive);
            System.out.println("prio " + s.priorityArrive);
            System.out.println("period vertrek " + s.periodDept);
            System.out.println("prio " + s.priorityDept);
        }
    }

    /*
     *  returns string from the corresponding element
     */
private static String getValue(String tag, Element element){
    NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
    Node node = (Node) nodes.item(0);
    return node.getNodeValue();
    }

/*
 * return a string where the index is 1
 */
private static String getDoubleValue(String tag1, Element element){
    NodeList nodes1 = element.getElementsByTagName(tag1).item(1).getChildNodes();
    Node node =(Node) nodes1.item(0);
    return node.getNodeValue();
}
/*
 * returns an int with the given index
 */
private static int getIntValue(int index,String tag, Element element){
    NodeList nodes = element.getElementsByTagName(tag).item(index).getChildNodes();
    Node node = (Node) nodes.item(0);
    String transform=node.getNodeValue();
    int value = Integer.parseInt(transform);
    return value;
}
/*
 *  returns a double  with the given index
 */
  private static double getDoubleValue(int index, String tag, Element element){
     NodeList nodes = element.getElementsByTagName(tag).item(index).getChildNodes();
    Node node = (Node) nodes.item(0);
      String transform= node.getNodeValue();
      double value =Double.parseDouble(transform);
      return value;
  }      
}
