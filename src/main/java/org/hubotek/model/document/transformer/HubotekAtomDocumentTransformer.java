package org.hubotek.model.document.transformer;

import java.util.Date;

import javax.inject.Named;

import org.hubotek.model.atom.AtomDocument;
import org.hubotek.model.atom.AtomEntry;
import org.hubotek.model.document.DocumentType;
import org.hubotek.model.document.HubotekDocument;
import org.hubotek.model.document.HubotekDocumentEntry;
import org.hubotek.model.lob.HubotekDocumentContent;

@Named(value="hubotekAtomDocumentTransformer")
public class HubotekAtomDocumentTransformer implements HubotekLegacyDocumentTransformer<AtomDocument> {

	public HubotekAtomDocumentTransformer()
	{ 
		super();
	}
	
	@Override
	public HubotekDocument apply(AtomDocument atomDocument) {
		return generateDocumentFromAtom(atomDocument);
	}

	private HubotekDocument generateDocumentFromAtom(AtomDocument atomDocument) {
		HubotekDocument document = new HubotekDocument();
		document.setOrigin(atomDocument);
		document.setDateInsert(new Date());
		document.setDocumentType(DocumentType.XML);
		document.setLanguage("en");
		atomDocument.getEntries().stream().forEach(e -> document.getDocumentEntries().add(addNewEntryFromAtomEntry(e)));
		return document;
	}

	private HubotekDocumentEntry addNewEntryFromAtomEntry(AtomEntry e) {
		return new HubotekDocumentEntry(new HubotekDocumentContent(e.getContent().getContent()));
	}

}
