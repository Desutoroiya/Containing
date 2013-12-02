/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.containing;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Iva
 */
public class XMLreader {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            File ContainerList = new File("xml7.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(ContainerList);
                      doc.getDocumentElement().normalize();
          
            System.out.println("root of XML file"+doc.getDocumentElement().getNodeName());
            NodeList nodes = doc.getElementsByTagName("record");
            NodeList nodes1 = doc.getElementsByTagName("vertrek");
            System.out.println("====================");
            
            for(int i =0; i < nodes.getLength(); i++){
                Node node = nodes.item(i);
                
                if(node.getNodeType()== Node.ELEMENT_NODE){
                    Element element =  (Element) node;
                    System.out.println("record Eigenaar:" + getValue("naam",element));
                    System.out.println("record aankomst:"+ getValue("van", element)+" tot:" +getValue("tot",element));
                    System.out.println("record vervoer_aankomst:"+getValue("soort_vervoer",element));
                    System.out.println("vertek: "+getDoubleValue("soort_vervoer",element));
                    //System.out.println("record vervoer_vertrek:"+getValue("vertrek soort_vervoer",element));
                    
                    System.out.println("==================");
                }
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

private static String getValue(String tag, Element element){
    NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
    Node node = (Node) nodes.item(0);
    return node.getNodeValue();
    }

private static String getDoubleValue(String tag1, Element element){
    NodeList nodes1 = element.getElementsByTagName(tag1).item(1).getChildNodes();
    Node node =(Node) nodes1.item(0);
    return node.getNodeValue();
}
}
