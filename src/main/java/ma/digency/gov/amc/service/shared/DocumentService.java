package ma.digency.gov.amc.service.shared;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import ma.digency.gov.amc.repository.entity.Docum;
import ma.digency.gov.amc.service.siel.SielParticipationDocument;

public interface DocumentService {

	Docum uploadDocument(Docum document);

	Docum findByRefDocument(String refDocument);

	List<Docum> findByRefObject(String refObject);

	void deleteDocument(Docum document);

	List<Docum> findByRefObjectAndRefParent(String refObject,String refParent);

	void deleteDocument(String refObject);

	@NotNull
	@Valid
	byte[] generateDocument(@NotNull @Valid SielParticipationDocument documentRequest, boolean isPurchase) throws IOException;

	void deleteByRefObject(String refObject);
}
