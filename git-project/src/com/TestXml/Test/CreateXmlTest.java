package com.TestXml.Test;

import java.io.File;
import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

/**
 * 用于生产xml文件
 * 
 * @author ZP
 * 
 */
public class CreateXmlTest {

	public static void main(String args[]) {
		String fileName = "D:/CreateText.xml";
		Document document = DocumentHelper.createDocument();// 建立document对象，用来操作xml文件
		Element booksElement = document.addElement("books");// 建立根节点
		booksElement.addComment("This is a test for dom4j ");// 加入一行注释
		Element bookElement = booksElement.addElement("book");// 添加一个book节点
		bookElement.addAttribute("show", "yes");// 添加属性内容
		Element titleElement = bookElement.addElement("title");// 添加文本节点
		titleElement.setText("ajax in action");// 添加文本内容
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(new File(fileName)));
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
