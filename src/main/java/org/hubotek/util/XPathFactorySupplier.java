package org.hubotek.util;

import javax.xml.xpath.XPathFactory;


public class XPathFactorySupplier implements java.util.function.Supplier<XPathFactory> {

	@Override
	public XPathFactory get() {
		return XPathFactory.newInstance();
	}

}
