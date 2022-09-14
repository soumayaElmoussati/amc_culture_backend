package ma.digency.gov.amc.dto.attributionsprix;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class AwardObtainedRequest {

    private String award;

    private String organisers;

    private float year;

    private String artist;
}
