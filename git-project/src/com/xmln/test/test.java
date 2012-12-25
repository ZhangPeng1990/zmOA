package com.xmln.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class test {
	public static void main(String[] args) {
		SAXReader saxReader = new SAXReader();  
		Document document = null;  
		try {  
			    Map<String, String> nameSpaceMap = new HashMap<String, String>();  
			    nameSpaceMap.put("googleMap", "http://earth.google.com/kml/2.0");  
			    saxReader.getDocumentFactory().setXPathNamespaceURIs(nameSpaceMap);  
			    document = saxReader.read("src/com/xmln/test/test.xml");  
			} catch (DocumentException e) {  
			    e.printStackTrace();  
			}  
		@SuppressWarnings("unchecked")
		List<Node> nodeList = document.selectNodes("/kml/googleMap:Response/googleMap:Placemark/googleMap:Point");  
		System.out.println(nodeList.size());  
		for (Node n : nodeList) {  
		    System.out.println(n.getName()); 
		}
	}
}