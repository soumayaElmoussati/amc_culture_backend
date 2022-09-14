package ma.digency.gov.amc.dto.card;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter

public class CardResponse {
    private String refCard;
    private int numCard;
    private LocalDate dateCardCreation;
    private LocalDate dateCardValidation;
    private String cardType;
    private String refArtistAccount;
    private String status;

}
