package org.hubotek.model.document;

import java.util.Map;

import javax.inject.Inject;

import org.hubotek.HubotekException;

public abstract class FeedHubotekDocumentProvider implements HubotekDocumentProvider
{

	private LegacyDocument legacyDocument; 
	
	@Inject 
	public Map<LegacyDocumentType , ?> documentTransformerAdapter;
	
	public <T extends LegacyDocument> FeedHubotekDocumentProvider(T legacyDocument)
	{ 
		this.legacyDocument = legacyDocument;
	}
	
	public void checkTranformationIntegrity() 
	{ 
		checkIfHasTransformer();
	}

	private void checkIfHasTransformer() {
		if (documentTransformerAdapter.get(legacyDocument.getLegacyDocumentyType()) == null)
			throw new HubotekException("No valid document transfomer registered");
	}
	
	@Override
	public HubotekDocument get() 
	{ 
		return null;
	}
}
