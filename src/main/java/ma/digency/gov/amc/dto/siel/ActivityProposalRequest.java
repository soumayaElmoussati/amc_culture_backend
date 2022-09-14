package ma.digency.gov.amc.dto.siel;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ActivityProposalRequest {


    private LocalDate proposedDate;

    private String topic;

    private String participants;

    private String activityPlace;

    private String bookTitle;

    private String author;

    private String publishingHouse;

    private String publishingYear;

    private String editeur;


}
