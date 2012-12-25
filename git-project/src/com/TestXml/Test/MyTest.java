package com.TestXml.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class MyTest {
	
	public static <K> void readXML(String xml){
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement();//获取根节点
			System.out.println("根节点" + rootElt.getName());
			
			Iterator<?> itor = rootElt.elementIterator("head");
			while(itor.hasNext()){
				Element elements = (Element) itor.next();
				String title = elements.elementTextTrim("title");
				System.out.println("title:" + title);
				
				Map<String, String> map = new HashMap<String, String>();
				map.put("title1", title);
				System.out.println(map.get("title1"));
				
				Hashtable<String,String> table = new Hashtable<String,String>();
				table.put("title1", title);
				System.out.println(table.get("title1"));
			}
			
			Iterator<?> itor1 = rootElt.elementIterator("head");
			while(itor1.hasNext()){
				Element element = (Element) itor1.next();
				String script = element.elementTextTrim("script");
				System.out.println("script:"+script);
			}
			
			Iterator<?> itorBody = rootElt.elementIterator("body");
			while(itorBody.hasNext()){
				Element elements = (Element) itorBody.next();
				String table = elements.elementTextTrim("table");
				System.out.println("table:" + table);
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String testXML = "<html>"+"<head>"+"<title>"+"此处是标题"+"</title>"+"<script>"+"此处是script内容"+"</script>"+"</head>"+
	                     "<body>"+"<table>"+"此处是body内容"+"</table>"+"</body>"+"</html>";
		readXML(testXML);
	}

}
