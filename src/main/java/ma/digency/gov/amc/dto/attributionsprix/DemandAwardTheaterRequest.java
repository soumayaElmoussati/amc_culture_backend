package ma.digency.gov.amc.dto.attributionsprix;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class DemandAwardTheaterRequest {

    private String comment;

    private String representativeTheaterPiece;

    private String awardTheater;

    private TheaterPieceRequest theaterPieceRequest;

    private String refPersonConnected;

}
