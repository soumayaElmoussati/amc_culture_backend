package ma.digency.gov.amc.dto.attributionsprix;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated

public class DemandAwardHassan2Request {

    private String refOwner;

    private String comment;

    private String award;

    private String refPersonConnected;
}
