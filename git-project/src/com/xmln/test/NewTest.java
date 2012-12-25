package com.xmln.test;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String,String> map = new HashMap<String,String>();

		//把默认名称空间也加在程序里一个前缀方便在xpath中用前缀确定Element
		map.put("newns", "http://www.binboot.com");
		map.put("myns", "http://www.hotnut.com.cn");

		//默认名称空间在程序中加入前缀就可以用xpath表达式了
		XPath xpathSelector = DocumentHelper.createXPath("//newns:price");

		//将装有prefix和URI映射关系的HashMap放入到xpath选择器中，xpath会自动从这些
		xpathSelector.setNamespaceURIs(map);
		
		List<Element> priceElements = xpathSelector.selectNodes(document);
		for (Element priceElement : priceElements) {
			System.out.println(priceElement.getText());
		}

		XPath xpathSelector1=DocumentHelper.createXPath("//myns:price");
		xpathSelector.setNamespaceURIs(map);
		
		List<Element> priceElements1s = xpathSelector1.selectNodes(document);
		for (Element priceElement : priceElements1s) {
			System.out.println(priceElement.getText());

		}
		
		XPath xpathSelector2=DocumentHelper.createXPath("//myns:price/myns:huiyuanprice");
		xpathSelector.setNamespaceURIs(map);
		
		List<Element> priceElements2s = xpathSelector2.selectNodes(document);
		for (Element priceElement : priceElements2s) {
			System.out.println(priceElement.getText());

		}
	}
}
