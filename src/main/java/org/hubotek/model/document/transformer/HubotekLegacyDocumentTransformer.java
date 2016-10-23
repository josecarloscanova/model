package org.hubotek.model.document.transformer;

import org.hubotek.model.document.HubotekDocument;
import org.hubotek.model.document.LegacyDocument;

@FunctionalInterface
public interface HubotekLegacyDocumentTransformer <T extends LegacyDocument> extends BaseTransformer<T,HubotekDocument>{
}
