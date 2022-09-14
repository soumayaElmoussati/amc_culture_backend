package ma.digency.gov.amc.dto.attributionsprix;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.Date;


@Getter
@Setter
@Validated

public class DemandHonoraryAwardResponse {

    private String refDemand;

    private String status;

    private String comment;

    private Date decisionDate;

    private String refHonoraryAward;
}
