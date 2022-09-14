package ma.digency.gov.amc.dto.attributionsprix;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class ParticipantRequest {

    private String lastName;

    private String firstName;

    private String cin;

    private String role1;

    private String role2;

    private String role3;

    private String personalityName;

    private String theaterPiece;
}
