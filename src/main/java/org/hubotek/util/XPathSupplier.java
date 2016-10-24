package org.hubotek.util;

import java.util.function.Supplier;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;


public class XPathSupplier implements Supplier<XPath> {
   
	private XPathFactory xpathFactory;
	
	public XPathSupplier()
	{
		prepare();
	}
	
	private void prepare() {
		xpathFactory = XPathFactory.newInstance();
	}

	@Override
	public XPath get() {
		return xpathFactory.newXPath();
	}

}
