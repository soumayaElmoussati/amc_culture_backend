package ma.digency.gov.amc.process;

import ma.digency.gov.amc.dto.DocumentResponse;
import ma.digency.gov.amc.dto.DocumentTypeResponse;
import ma.digency.gov.amc.repository.entity.Docum;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface DocumentProcess {

	DocumentTypeResponse saveDocument(String uploadType, MultipartFile multipartFile, String refObject,String refParent);

	DocumentResponse visualizeDocument(String refDocument);

	List<DocumentTypeResponse> findDocuments(String refObject);

	List<DocumentTypeResponse> findDocumentsByRefObjectAndRefParent(String refObject,String refParent);

	DocumentResponse generateRequestParticipation(@NotBlank String refExhibitor, @NotBlank String language) throws IOException;

	DocumentResponse generatePurchaseOrder(@NotBlank String refExhibitor, @NotBlank String language) throws IOException;

	HashMap<Integer,String> addExhibitorsFromDocument(String refExhibitor, MultipartFile multipartFile);

    String updateDocument(MultipartFile multipartFile, String refDocument);

    DocumentResponse uploadPublicationModel();
	List<Docum> findDocumentByRefObject(String refObject);

	Docum findDocumentByRef(String refDcument);

    DocumentResponse uploadForeignExhibitor();
}
