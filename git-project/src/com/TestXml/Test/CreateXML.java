package com.TestXml.Test;

import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class CreateXML {
	public CreateXML() {
		try {
			jbInit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 此API为了生成一个xml文件
	public void generateDocument() {

		// 使用 DocumentHelper 类创建一个文档实例。DocumentHelper 是生成 XML 文档节点的 dom4j API
		// 工厂类
		Document document = DocumentHelper.createDocument();

		Element catalogElement = document.addElement("catalog");
		// 使用 addElement() 方法创建根元素 catalog。 addElement() 用于向 XML 文档中增加元素

		catalogElement.addComment("An XML Catalog");
		// 在 catalog 元素中使用 addComment() 方法添加注释“An XML catalog”

		catalogElement.addProcessingInstruction("target", "text");
		// 在 catalog 元素中使用 addProcessingInstruction() 方法增加一个处理指令

		Element journalElement = catalogElement.addElement("journal");
		// 在 catalog 元素中使用 addElement() 方法增加 journal 元素

		journalElement.addAttribute("title", "XML Zone");
		journalElement.addAttribute("publisher", "IBM developerWorks");
		// 使用 addAttribute() 方法向 journal 元素添加 title 和 publisher 属性。

		Element articleElement = journalElement.addElement("文章");
		// 向journal 元素中添加 article 元素

		articleElement.addAttribute("level", "Intermediate");
		articleElement.addAttribute("date", "December-2001");
		// 为 article 元素增加 level 和 date 属性

		Element titleElement = articleElement.addElement("title");
		// 向 article 元素中增加 title 元素

		titleElement.setText("Java configuration with XML Schema");
		// 使用 setText() 方法设置 article 元素的文本

		Element authorElement = articleElement.addElement("author");
		// 在 article 元素中增加 author 元素

		Element firstNameElement = authorElement.addElement("firstname");
		firstNameElement.setText("Marcello");
		// 在 author 元素中增加 firstname 元素并设置该元素的文本

		Element lastNameElement = authorElement.addElement("lastname");
		lastNameElement.setText("Vitaletti");
		// 在 author 元素中增加 lastname 元素并设置该元素的文本

		// document.addDocType("catalog", null,"file://c:/Dtds/catalog.dtd");
		// 可以使用 addDocType() 方法添加文档类型说明。
		// 这样就向 XML 文档中增加文档类型说明：
		// <!DOCTYPE catalog SYSTEM "file://c:/Dtds/catalog.dtd">

		try {
			// XMLWriter output = new XMLWriter(new FileWriter( new
			// File("c:/test.xml") ));

			// 通过如下改变代码彻底解决中文输入问题
			// XML 声明 <?xml version="1.0" encoding="UTF-8"?> 自动添加到 XML 文档中。
			org.dom4j.io.XMLWriter output = new org.dom4j.io.XMLWriter(
					new FileOutputStream(
							"E:/JavaCodeCollection/java学习/test/test.xml"));

			output.write(document);
			output.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		// 如果文档要使用文档类型定义（DTD）文档验证则必须有 Doctype。
		// XML 声明 <?xml version="1.0" encoding="UTF-8"?> 自动添加到 XML 文档中。

	}

	public static void main(String[] argv) {
		CreateXML dom4j = new CreateXML();
		dom4j.generateDocument();
	}

	private void jbInit() throws Exception {
	}

}
