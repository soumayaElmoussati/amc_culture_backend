package ma.digency.gov.amc.service.shared;

import java.io.*;
import java.util.Date;
import java.util.List;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.UnitValue;
import ma.digency.gov.amc.service.siel.SielDocumentResource;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.digency.gov.amc.exception.MinistryOfCultureBusinessException;
import ma.digency.gov.amc.exception.MinistryOfCultureMessage;
import ma.digency.gov.amc.repository.DocumentRepository;
import ma.digency.gov.amc.repository.entity.Docum;
import ma.digency.gov.amc.service.siel.SielParticipationDocument;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.InputStream;

import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.io.image.ImageDataFactory;
import java.net.MalformedURLException;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Override
    public Docum uploadDocument(Docum document) {
        return documentRepository.save(document);
    }

    @Override
    public Docum findByRefDocument(String refDocument) {
        return documentRepository.findByRefDocument(refDocument)
                .orElseThrow(() -> new MinistryOfCultureBusinessException(MinistryOfCultureMessage.AMC_DOCUMENT_NOT_FOUND));
    }

    @Override
    public List<Docum> findByRefObject(String refObject) {
        return documentRepository.findByRefObject(refObject);
    }

    @Override
    public void deleteDocument(Docum document) {
        this.documentRepository.delete(document);
    }

    @Override
    public List<Docum> findByRefObjectAndRefParent(String refObject, String refParent) {
        return documentRepository.findByRefObjectAndRefParent(refObject,refParent);
    }

    @Override
    public void deleteDocument(String refObject) {
        List<Docum> documents=documentRepository.findByRefObject(refObject);
        for (Docum document:documents) {
            documentRepository.delete(document);
        }
    }

    @Override
    public byte[] generateDocument(SielParticipationDocument documentRequest, boolean isPurchase) throws IOException {
        String documentClassPath = documentRequest.getResource().getClassPath();
        if (isPurchase) {
            documentClassPath = SielDocumentResource.SIEL_PURCHASE_ORDER_FR_DOC.getClassPath();
        }
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(documentClassPath);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfDocument doc = new PdfDocument(new PdfWriter(out));

        Document document = new Document(doc);
        Text text = new Text("Fiche 1\n").setFontSize(14).setBold().setItalic();

        Paragraph paragraph = new Paragraph(text);
        paragraph.setMarginTop(120);
        document.add(paragraph);

        Paragraph fiche1_para_heading = new Paragraph(new Text("DEMANDE DE PARTICIPATION ET ENGAGEMENT").setFontSize(11).setBold());
        document.add(fiche1_para_heading);
        Paragraph fiche1_para_content = new Paragraph(new Text("Tout exposant au SIEL 2022, en complétant et signant la présente demande, " +
                "s'engage à respecter les clauses du règlement intérieur du salon, cette demande de participation est à remettre à " +
                "la Direction du Livre, des Bibliothèques et des Archives avance le " + documentRequest.getEndDateEdition()).setFontSize(10));

        document.add(fiche1_para_content);
        document.add(new Paragraph("\n"));
        Paragraph info_title = new Paragraph(new Text("Informations à fournir :").setFontSize(11).setBold());
        document.add(info_title);

        Paragraph nous = new Paragraph(new Text("Nous").setFontSize(12));
        nous.setFirstLineIndent(15);
        document.add(nous);


        Paragraph nous_body = new Paragraph();
        nous_body.setFontSize(10);
        nous_body.setPaddingLeft(30);

        nous_body.add(new Text("Raison sociale :  " + documentRequest.getEstablishmentName()))
                .add(new Text("\n"))
                .add(new Text("Directeur responsable : " + documentRequest.getResponsible()))
                .add("\n")
                .add("Adresse : " + documentRequest.getAddress())
                .add("\n")
                .add(new Text("Tél : " + documentRequest.getPhoneNumber() + "\t\t"))
                .add(new Tab())
                .add(new Text("Fax : " + documentRequest.getFaxNumber() + "\t"))
                .add(new Tab())
                .add(new Text("E-mail : " + documentRequest.getEmail()))
                .add("\n")
                .add("Représenté au Salon par : " + documentRequest.getRepresenting())
                .add("\n")
                .add("Produits exposés : " + documentRequest.getProductsExhibited());
        document.add(nous_body);

        Paragraph table_desc = new Paragraph("Demandons à participer au salon et nous nous engageons à respecter son règlement intérieur");
        table_desc.setFontSize(12);
        table_desc.setPaddingLeft(15);
        document.add(table_desc);


        Table headerTable = new Table(new float[]{(float) 2.5, 1});
        headerTable.setWidth(UnitValue.createPercentValue(100));
        headerTable.addCell(new Cell().add(new Paragraph("Catégorie du stand")).setFontSize(12).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(ColorConstants.LIGHT_GRAY));
        headerTable.addCell(new Cell().add(new Paragraph("Surface réservé en m2")).setFontSize(12).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(ColorConstants.LIGHT_GRAY));

        headerTable.setFixedLayout();
        document.add(headerTable);

        Table contentTable = new Table(new float[]{2, 3, 2});
        contentTable.setWidth(UnitValue.createPercentValue(100));
        contentTable.addCell(new Cell().add(new Paragraph(documentRequest.getStandEquipped())).setFontSize(10).setTextAlignment(TextAlignment.CENTER));
        contentTable.addCell(new Cell().add(new Paragraph(documentRequest.getStandEmpty())).setFontSize(10).setTextAlignment(TextAlignment.CENTER));
        contentTable.addCell(new Cell().add(new Paragraph(documentRequest.getStandSize())).setFontSize(10).setTextAlignment(TextAlignment.CENTER));

        contentTable.setFixedLayout();
        document.add(contentTable);

        document.add(new Paragraph("\n"));



        Paragraph paragraph_4 = new Paragraph("A l’intention de l’ensemble des exposants :");
        paragraph_4.setFontSize(10).setBold();
        Paragraph paragraph_4_content = new Paragraph("Je m’engage à déclarer la valeur des ventes journalières, " +
                "et ce, en remplissant le formulaire des ventes par jour, et en le remettant à la Direction du salon, de façon " +
                "quotidienne, tout au longe d l’événement, conformément à l’article 6, alinéa10 du règlement du salon");
        paragraph_4_content.setFontSize(10).setItalic();
        paragraph_4_content.setBackgroundColor(ColorConstants.LIGHT_GRAY);
        document.add(paragraph_4).add(paragraph_4_content);


        Paragraph paragraph_5 = new Paragraph("A l’intention des exposants étrangers :");
        paragraph_5.setFontSize(10).setBold();
        Paragraph paragraph_5_content = new Paragraph("Je m’engage à réexpédier les ouvrages non vendus au Salon dans de " +
                "leur pays d’origine dans un délai de cinq jours après la clôture du salon, au-delà de cette date la direction du salon" +
                " se réserve le droit de les saisir.");
        paragraph_5_content.setFontSize(10).setItalic();
        paragraph_5_content.setBackgroundColor(ColorConstants.LIGHT_GRAY);
        document.add(paragraph_5).add(paragraph_5_content);
        document.add(new Paragraph("\n"));

        document.add(new Paragraph(new Text("•")).setFontSize(10).add(new Tab()).add("Toute participation n'est valable qu'après approbation de la Direction du Livre, des Bibliothèques et des Archives - Ministère de la Jeunesse, de la Culture et de la Communication, Département de la Culture- Maroc."));



        VariableHeaderEventHandler handler = new VariableHeaderEventHandler();
        handler.setHeader("Rabat du  " + documentRequest.getStartDateEdition() + " au " + documentRequest.getEndDateEdition());

        doc.addEventHandler(PdfDocumentEvent.END_PAGE, handler);


        //   document.add(new Paragraph(new Text("Date : #date0\tSignature et Cachet précédés de la mention :\n").setFontSize(10).setTextAlignment(TextAlignment.LEFT)));



        document.close();


        return out.toByteArray();

    }


    protected static class VariableHeaderEventHandler implements IEventHandler {
        String header;

        public void setHeader(String header) {
            this.header = header;
        }
        @Override
        public void handleEvent(com.itextpdf.kernel.events.Event event) {


            PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
            PdfDocument pdf = docEvent.getDocument();
            PdfPage page = docEvent.getPage();
            Rectangle pageSize = page.getPageSize();
            PdfCanvas pdfCanvas = new PdfCanvas(page.getLastContentStream(), page.getResources(), pdf);
//

            try {
                pdfCanvas.addImageFittedIntoRectangle(ImageDataFactory.create("./src/main/resources/header.png"), new Rectangle(0, pageSize.getTop() - 150, pageSize.getWidth(), 190), false);
                pdfCanvas.addImageFittedIntoRectangle(ImageDataFactory.create("./src/main/resources/siel_logo.png"), new Rectangle(pageSize.getWidth() / 2 - 109, pageSize.getTop() - 100, 217, 83), false);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            Paragraph end = new Paragraph(new Text("lus et approuvés : le dossier d’exposant et le règlement du Salon").setFontSize(10).setFontColor(ColorConstants.LIGHT_GRAY));
            Canvas canvas = new Canvas(pdfCanvas, pageSize);
            canvas.setFontSize(10f);
            //Write text at position

            canvas.showTextAligned(end,
                    pageSize.getWidth() / 2,
                    pageSize.getBottom() + 20, TextAlignment.CENTER);

            Canvas pp_canvas = new Canvas(pdfCanvas, pageSize);
            Paragraph pp = new Paragraph(new Text("Date : #date0\tSignature et Cachet précédés de la mention :\n").setFontSize(10).setTextAlignment(TextAlignment.LEFT));
            pp_canvas.showTextAligned(pp,
                    30,
                    pageSize.getBottom() + 40, TextAlignment.LEFT);

            Canvas canvas_header = new Canvas(pdfCanvas, pageSize);
            canvas_header.setFontSize(14f);

            canvas_header.showTextAligned(new Paragraph("Salon International de l’Edition et du Livre" ).setBold(),
                    pageSize.getWidth() / 2,
                    pageSize.getTop() - 130, TextAlignment.CENTER);

            canvas_header.showTextAligned(new Paragraph(header).setBold().setFontSize(12),
                    pageSize.getWidth() / 2,
                    pageSize.getTop() - 150, TextAlignment.CENTER);
//            Paragraph end = new Paragraph("lus et approuvés : le dossier d’exposant et le règlement du Salon");
//            canvas.showTextAligned(end, pageSize.getWidth()/2, pageSize.getBottom(), TextAlignment.CENTER);

            //pdfCanvas.release();

        }
    }


    @Override
    public void deleteByRefObject(String refObject) {

        List<Docum> documents_Demand=findByRefObject(refObject);
        for(Docum document:documents_Demand)
        {
            documentRepository.delete(document);
        }

    }

}
