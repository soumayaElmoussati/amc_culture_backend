package ma.digency.gov.amc.dto.siel;

import lombok.Getter;
import lombok.Setter;
import ma.digency.gov.amc.utils.enumeration.StatusEnum;
import ma.digency.gov.amc.utils.validation.annotation.NotEmptyString;

@Getter
@Setter
public class BookingStandResponse {

    private String refBookingStand;

    @NotEmptyString
    private String volumeInCubicMeter;

    @NotEmptyString
    private String category;

    @NotEmptyString
    private String paymentMethod;

    @NotEmptyString
    private String branchActivity;

    private StatusEnum status;

}
