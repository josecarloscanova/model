package org.hubotek;

import java.util.function.Supplier;
import org.w3c.dom.Document;
import org.hubotek.model.atom.AtomDocument;
import org.hubotek.model.atom.AtomDocumentBuilder;


public class AtomDocumentSupplier  implements Supplier<AtomDocument> //extends HttpRequestAccessor<AtomDocument>
{
	private Document sourceDocument;
	
	public AtomDocumentSupplier(Document adomDocument )
	{ 
		this.sourceDocument = adomDocument;
	}

	@Override
	public AtomDocument get() {
		return new AtomDocumentBuilder().withDocument(sourceDocument).build();
	}

}