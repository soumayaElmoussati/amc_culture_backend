package ma.digency.gov.amc.dto.attributionsPrix1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Validated
public class PriceHonoraryResponse {

    private String refDemand;

    private String status;

    private Date decision_date;

    private LocalDate creationDate;

    private String comment;

    private String key;

    private OwnerPersonalInfoResponse ownerPersonalInfoResponse;

    private AwardCategoriesResponse awardCategories;

}
