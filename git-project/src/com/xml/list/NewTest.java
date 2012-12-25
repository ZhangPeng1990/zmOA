package com.xml.list;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

public class NewTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		File file = new File("src/com/xmln/test/NewTest.xml");
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("newns", "http://www.binboot.com");
		map.put("myns", "http://www.hotnut.com.cn");
		
		XPath xpathSelector = DocumentHelper.createXPath("//newns:book/myns:price/myns:huiyuanprice");
		xpathSelector.setNamespaceURIs(map);
		
		List<Element> priceElements = xpathSelector.selectNodes(document);
		for (Element priceElement : priceElements) {
			System.out.println(priceElement.getText());
		}

	}
}
