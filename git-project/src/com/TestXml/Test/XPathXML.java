package com.TestXml.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 以路径方式读取xml文件并解析
 * @author tyr
 *
 */
public class XPathXML {
    public static void main(String[] args) throws Exception {
        readFile("src/com/TestXml/Test/test.xml");
        }  
      
    public static void readFile(String fileName) throws Exception{
    	//处理命名空间
		Map<String, String> nameSpaceMap = new HashMap<String, String>();
	    nameSpaceMap.put("defu","http://www.epcregister.com");
	    //处理命名空间
        SAXReader reader = new SAXReader();
	    reader.getDocumentFactory().setXPathNamespaceURIs(nameSpaceMap);
	    Document document = reader.read(new File(fileName));
//	    List listSingedInfo = document.selectNodes("//xmln:SignedInfo");//获取SignedInfo节点
//	    List listSignatureValue = document.selectNodes("//xmln:SignedInfo/xmln:SignatureValue")//获取SignatureValue节
          
	    Element nowOne = (Element)document.selectSingleNode("//defu:nowOne/defu:SAPReport-Header");
	    System.out.println(nowOne.getName());
	    System.out.println(nowOne.getTextTrim());
	    
//		List<Element> list =  document.selectNodes("//defu:nowOne");
//        for(Element e :list){
//            System.out.println(e.getName()+"="+e.getText());
//        }
        
//        Element zp = (Element)document.selectSingleNode("ROWDATA/nowOne/SAPReport-Header");
//        System.out.println(zp.getName()+"="+zp.getText());
//        //遍历属性 属性名前面加 @
//        List<Attribute> listAtt =  document.selectNodes("ROWDATA/ROW/ENAME/@firstname");  
//        for(Attribute att :listAtt){
//            System.out.println(att.getName()+"="+att.getText());  
//        }  
    }  
}  
