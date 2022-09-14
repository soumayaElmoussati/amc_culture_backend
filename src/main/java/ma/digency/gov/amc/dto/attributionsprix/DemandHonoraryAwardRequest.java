package ma.digency.gov.amc.dto.attributionsprix;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;


@Getter
@Setter
@Validated
public class DemandHonoraryAwardRequest {

    private String candidate;

    private String comment;

    private String awardHonorary;

    private String refPersonConnected;

}
