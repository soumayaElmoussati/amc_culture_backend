package ma.digency.gov.amc.dto.attributionsprix;

import lombok.Getter;
import lombok.Setter;
import ma.digency.gov.amc.repository.entity.attributionsprix.AwardTheater;
import ma.digency.gov.amc.repository.entity.attributionsprix.TheaterPiece;
import ma.digency.gov.amc.repository.entity.proposalproject.ArtistAccount;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Getter
@Setter
@Validated
public class DemandAwardTheaterResponse {

    private String refDemand;

    private String status;

    private Date decision_date;

    private String comment;

    private AwardTheater awardTheater;

    private TheaterPiece theaterPiece;

    private ArtistAccount representativeTheaterPiece;

}
