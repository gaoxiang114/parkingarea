package com.cyou.library.xh.common.util;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 读取xml的工具类。
 * 
 * 说明：通过 dom4j进行读取。
 * 
 * @author lianze
 * @since 2011-11-02
 *
 */

public class XmlUtil {
	
	private static Logger logger = Logger.getLogger(XmlUtil.class);
	
	private static XmlUtil instance;
	
	private static Element root;
	
	public static List<XmlUtilHelpForm> xmlUtilHelpFormList = null;
	
	public static List<XmlUtilHelpForm> technicalList = null;
	
	public static List<XmlUtilHelpForm> childNodeList = null;
	
	public static Document doc = null;
	
	/**
	 * 
	 * @param fileName 读取的xml文件名
	 */
	private XmlUtil(String fileName) {
		try {
			File f = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath() + fileName);

			if (!f.isFile()) {
				return;
			}

			SAXReader reader = new SAXReader();
			doc = reader.read(f);
			root = doc.getRootElement();
			
		}catch (URISyntaxException e) {
			logger.error("在读取 xml 文件 " + fileName + " 时发生 URISyntaxException 异常！", e);
		}catch (DocumentException e) {
			logger.error("在读取 xml 文件 " + fileName + " 时发生 DocumentException 异常！", e);
		}
	}
	
	public static synchronized XmlUtil getInstance(String fileName) {
		if (instance == null) {
			instance = new XmlUtil(fileName);
		}
		return instance;
	}
	
	/**
	 * 由父点ID查询出父节点名称。
	 * @param parentId
	 * @return
	 */
	public String getNodeName(String parentNodeName, String nodeId) {
		String parentName = "";
		Element e_parent;
		for (Iterator iter = root.elementIterator(parentNodeName); iter.hasNext();) {
			e_parent = (Element) iter.next();
			
			Element e_child;
			
			for (Iterator iter_parent = e_parent.elementIterator(); iter_parent.hasNext();) {
				e_child = (Element) iter_parent.next();
				if(nodeId.equals(e_child.attributeValue("id"))) {
					parentName = e_child.attributeValue("name");
				}
			}
		}
		return parentName;
	}
	
	/**
	 *  读取 xml 信息
	 * @param parentNodeName
	 * @return
	 */
	public XmlUtilHelpForm readXmlDetail(String parentNodeName,String nodeName) {
		Element e_parent;
		
		XmlUtilHelpForm xmlUtilHelpForm = null;
		XmlUtilHelpForm childXmlHelpForm;
		for (Iterator iter = root.elementIterator(parentNodeName); iter.hasNext();) {
			e_parent = (Element) iter.next();
			
			Element e_child;
			
			List<XmlUtilHelpForm> childNodeList = null;
			childNodeList = new ArrayList<XmlUtilHelpForm>();
			for (Iterator iter_parent = e_parent.elementIterator(); iter_parent.hasNext();) {
				e_child = (Element) iter_parent.next();
				
				xmlUtilHelpForm = new XmlUtilHelpForm();
				xmlUtilHelpForm.setId(e_child.attributeValue("id"));
				xmlUtilHelpForm.setName(e_child.attributeValue("name"));
				xmlUtilHelpForm.setParentNodeId(e_child.attributeValue("parentId"));
				xmlUtilHelpForm.setValue(e_child.attributeValue("value"));
			
				if(e_child.attributeValue("name").equals(nodeName)){
						for (Iterator iter_child = e_child.elementIterator(); iter_child.hasNext();) {
							Element element_p = (Element) iter_child.next();
							
							// 得到子级的信息
							childXmlHelpForm = new XmlUtilHelpForm();
							childXmlHelpForm.setId(element_p.attributeValue("id"));
							childXmlHelpForm.setName(element_p.attributeValue("name"));
							childXmlHelpForm.setParentNodeId(element_p.attributeValue("parentId"));
							childXmlHelpForm.setValue(element_p.attributeValue("value"));
							
							childNodeList.add(childXmlHelpForm);
							
						}
				}
				xmlUtilHelpForm.setChildNodeNames(childNodeList);
			}
		}
		
		return xmlUtilHelpForm;
	}
	
	/**
	 *  读取 xml 信息
	 * @param parentNodeName
	 * @return
	 */
	public List<XmlUtilHelpForm> loadXmlDetail(String parentNodeName) {
		Element e_parent;
		
		xmlUtilHelpFormList = new ArrayList<XmlUtilHelpForm>();
		
		XmlUtilHelpForm xmlUtilHelpForm;
		for (Iterator iter = root.elementIterator(parentNodeName); iter.hasNext();) {
			e_parent = (Element) iter.next();
			
			Element e_child;
			
			List<Map<String,String>> childNodeList = null;
			for (Iterator iter_parent = e_parent.elementIterator(); iter_parent.hasNext();) {
				e_child = (Element) iter_parent.next();
				
				// 得到父级的信息
				xmlUtilHelpForm = new XmlUtilHelpForm();
				xmlUtilHelpForm.setId(e_child.attributeValue("id"));
				xmlUtilHelpForm.setName(e_child.attributeValue("name"));
				xmlUtilHelpForm.setParentNodeId(e_child.attributeValue("parentId"));
				
				childNodeList = new ArrayList();
				Map<String,String> childNodeNames = null ;
				for (Iterator iter_child = e_child.elementIterator(); iter_child.hasNext();) {
					Element element_p = (Element) iter_child.next();
					
					// 得到子级的信息
					childNodeNames = new HashMap<String,String>();
					childNodeNames.put("id", element_p.attributeValue("id"));
					childNodeNames.put("name", element_p.attributeValue("name"));
					childNodeNames.put("parentId", element_p.attributeValue("parentId"));
					
					childNodeList.add(childNodeNames);
					
				}
				
				xmlUtilHelpForm.setChildNodeNames(childNodeList);
				
				xmlUtilHelpFormList.add(xmlUtilHelpForm);
			}
		}
		
		return xmlUtilHelpFormList;
	}
	
	public static void main(String[] args) {
		XmlUtilHelpForm xmlUtilHelpForm = XmlUtil.getInstance("data.xml").readXmlDetail("data","recommandState");
		List<XmlUtilHelpForm> list = xmlUtilHelpForm.getChildNodeNames();
		for(XmlUtilHelpForm x : list){
			System.out.println(x.getName()+"\t\t\t"+x.getValue());
		}
	}
}
