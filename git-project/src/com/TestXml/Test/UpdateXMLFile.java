package com.TestXml.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/*
 * 修改节点属性
 */
public class UpdateXMLFile {
	public static void modifyXMLFile() {
		String oldStr = "D:/text.xml";
		String newStr = "D:/text1.xml";
		Document document = null;
		//修改节点的属性
		try {
		SAXReader saxReader = new SAXReader(); // 用来读取xml文档
		document = saxReader.read(new File(oldStr)); // 读取xml文档
		List list = document.selectNodes("/books/book/@show");// 用xpath查找节点book的属性
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
		Attribute attribute = (Attribute) iter.next();
		if (attribute.getValue().equals("yes")) 
			attribute.setValue("no");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//修改节点的内容
		try {
		SAXReader saxReader = new SAXReader(); // 用来读取xml文档
		document = saxReader.read(new File(oldStr)); // 读取xml文档
		List list = document.selectNodes("/books/book/title");// 用xpath查找节点book的内容
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
		Element element = (Element) iter.next();
		element.setText("xxx");// 设置相应的内容
		}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
		XMLWriter writer = new XMLWriter(new FileWriter(new File(newStr)));
		writer.write(document);
		writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		}


}
