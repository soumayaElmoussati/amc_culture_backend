package ma.digency.gov.amc.dto.attributionsPrix1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;


@Getter
@Setter
@Validated
public class PublicationPriceRequest {

    private String title;

    private String publishingHouse;

    private LocalDate publishingDate;

    private int pagesNumber;

    private String language;

    private String abstractBook;

    private String publicationPlace;

    private String country;

    private String author;

    private String domain;
}
