package org.hubotek.util;

import java.util.function.Supplier;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.hubotek.ElementEnum;
import org.hubotek.HubotekException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMElementExtratorUtil<T extends ElementEnum<String>> {

	private Supplier<XPath> xpathFactory;
	
	
	public DOMElementExtratorUtil(){
		prepare();
	}
	
	private void prepare() {
		xpathFactory = () -> new XPathSupplier().get();
	}

	protected String getFromDocument(Document document , T elementEnum) {
		String value = "";
		NodeList nodeList = document.getElementsByTagName(elementEnum.valueOf());
		Node node = nodeList.item(0);
		if (node !=null)
			value = node.getTextContent().trim();
		return value;
	}
	
	protected NodeList getNodeListWithXPath(String nodeExpression , Document document)
	{ 
		NodeList nodeList = null;
		try {
		nodeList  = (NodeList) xpathFactory.get().compile(nodeExpression).evaluate(document, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			throw new HubotekException(e);
		}
		return nodeList;
	}
	
	protected String getTextAttribute(Node node, String attr) {
		return (node.hasAttributes() == true) ? node.getAttributes().getNamedItem(attr).getTextContent():"";
	}
	
	protected  String getChildNodeAttributeValueWithXPath(Document  document , String parentExpression , T elementEnum , String attribute) throws XPathExpressionException{
		Node node = getNodeWithXPath(buildXPathExpression(parentExpression, elementEnum) , document);
		return getTextAttribute(node , attribute);
	}
	
	private String buildXPathExpression(String parentExpression , T elementEnum) {
		return new StringBuilder(parentExpression).append("/").append(elementEnum.valueOf()).toString();
	}

	protected  String getChildNodeTextValueWithXPath(Document  document , String parentExpression , T elementEnum) throws XPathExpressionException{
		Node node = getNodeWithXPath(buildXPathExpression(parentExpression, elementEnum) , document);
		return getTextContent(node);
	}
	
	protected Node getNodeWithXPath(String nodeExpression , Document document)
	{ 
		Node node = null;
		try {
				node = (Node) xpathFactory.get().compile(nodeExpression).evaluate(document, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			throw new HubotekException(e);
		}
		return node;
	}
	protected String getTextContent(Node node) {
		return (node!=null && node.hasChildNodes()) ? node.getTextContent() : "";
	}
	
}
